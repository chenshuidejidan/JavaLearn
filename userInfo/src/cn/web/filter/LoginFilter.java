package cn.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //request和response强转
        HttpServletRequest request = (HttpServletRequest)req;

        //获取资源请求路径
        String uri = request.getRequestURI();

        //判断uri是否包含登陆相关资源，注意排除 css/js/图片/验证码等资源
        if(uri.contains("/login.jsp")||uri.contains("/loginServlet")||uri.contains("/checkCodeServlet")
                ||uri.contains("/js/")||uri.contains("/css/")||uri.contains("/fonts")){
            chain.doFilter(req, resp);
        }else{
            //不包含则验证是否登陆
            Boolean hasLogin = (Boolean) request.getSession().getAttribute("hasLogin");
            if(hasLogin!=null && hasLogin==true){
                chain.doFilter(req, resp);
            }else{
                request.setAttribute("login_msg","您尚未登陆，请登陆！");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

}
