package cn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class Demo1Proxy {
    public static void main(String[] args) {
        Demo1 demo1 = new Demo1Impl();
        Demo1 proxy_demo1 = (Demo1) Proxy.newProxyInstance(demo1.getClass().getClassLoader(), demo1.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //对show1方法进行增强
                if(method.getName().equals("show1")){
                    System.out.println("show1 has been enhanced....");
                    //增强参数
                    int i = (int)args[0];
                    i +=1000;
                    String o = (String)method.invoke(demo1, args);
                    //增强返回值
                    return o+"........hahaha";
                }else{
                    //其他方法原样执行
                    Object o = method.invoke(demo1, args);
                    return o;
                }

            }
        });

        String s1 = proxy_demo1.show1(2);
        System.out.println(s1);
        proxy_demo1.show2(1);
    }
}
