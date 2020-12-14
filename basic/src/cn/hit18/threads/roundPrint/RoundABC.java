package cn.hit18.threads.roundPrint;

public class RoundABC {
    public static volatile Integer i = 0;
    public static class Printer1 implements Runnable{
        @Override
        public void run() {
            while(i<=100){
                if(i%2==1){
                    synchronized(i){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                        i++;
                    }
                }
            }
        }
    }
    public static class Printer2 implements Runnable{
        @Override
        public void run() {
            while(i<=100){
                if(i%2==0){
                    synchronized(i){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                        i++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Printer1()).start();
        new Thread(new Printer2()).start();
    }
}
