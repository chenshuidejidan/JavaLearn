package cn.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //创建代理对象增强 getParameter 方法
        ServletRequest proxy_req = (ServletRequest)Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getParameter")) {
                    //增强返回值
                    String value = (String)method.invoke(req, args);
                    if(value!=null){
                        for(String s:sensitiveWordsList){
                            if(value.contains(s)){
                                value = value.replaceAll(s, "*");
                            }
                        }
                    }
                    System.out.println(value);
                    return value;
                }else{
                    //对其他方法原样执行
                    return method.invoke(req, args);
                }
            }
        });

        chain.doFilter(proxy_req, resp);
    }

    //在init中加载敏感词汇
    private List<String> sensitiveWordsList = new ArrayList<>();   //敏感词汇集合
    public void init(FilterConfig config) throws ServletException {
        //加载并读取文件，按行添加到集合中
        String realPath = config.getServletContext().getRealPath("/WEB-INF/classes/敏感词汇.txt");

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(realPath));

            String line = null;
            while((line = reader.readLine())!=null){
                sensitiveWordsList.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(reader!=null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void destroy() {
    }

}
