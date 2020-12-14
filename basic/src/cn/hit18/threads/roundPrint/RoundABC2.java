package cn.hit18.threads.roundPrint;

public class RoundABC2 {
    public static volatile Integer i = 0;
    public static class Printer1 implements Runnable{
        @Override
        public void run() {
            while(i<=100){
                synchronized(i){
                    if(i%2==0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                        i++;
                        try {
                            i.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }
        }
    }
}
