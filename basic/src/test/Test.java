package test;

public class Test {
    public static void main(String[] args) {
        long totalMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("-Xms:"+totalMemory/(1<<20)+"MB");
        System.out.println("-Xmx:"+maxMemory/(1<<20)+"MB");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}







