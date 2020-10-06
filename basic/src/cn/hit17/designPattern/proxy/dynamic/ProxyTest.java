package cn.hit17.designPattern.proxy.dynamic;

public class ProxyTest {
    public static void main(String[] args) {
        IDemo demo = new Demo();
        IDemo proxy_demo = (IDemo)new DemoProxyFactory(demo).getProxy();
        demo.show1(1);
        demo.show2(2);
        proxy_demo.show1(1);
        proxy_demo.show2(2);
    }
}
