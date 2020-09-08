package cn.hit14.atomic;

class DemoVolatile3{
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread{
        public void run(){
            while(!ready) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(1000);
        number = 42;
        ready = true;
    }
}
