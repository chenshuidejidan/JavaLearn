package cn.hit17.designPattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DemoProxyFactory {
    private Object demo; //维护一个目标对象

    public DemoProxyFactory(Object demo) {
        this.demo = demo;
    }

    //为目标对象生成代理对象
    public Object getProxy(){
        return Proxy.newProxyInstance(demo.getClass().getClassLoader(), demo.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强show1方法
                if(method.getName().equals("show1")){
                    System.out.println("show1 has been enhanced...");
                    //增强参数
                    args[0] = (int)args[0] + 1000;
                    String o = (String)method.invoke(demo, args);
                    //增强返回值结果
                    return o+"...........haha";
                } else {
                    return method.invoke(demo, args);
                }
            }
        });
    }
}
