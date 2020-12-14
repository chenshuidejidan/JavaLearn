package cn.hit18.threads.condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 早餐：两个包子一碗粥
 * 一个学生需要一份早餐
 */
public class ProducerAndConsumerZaocan {
    private static ReentrantLock lockBaozi = new ReentrantLock();
    private static Condition conditionBaozi = lockBaozi.newCondition();
    private static ReentrantLock lockZhou = new ReentrantLock();
    private static Condition conditionZhou = lockZhou.newCondition();
    private static ReentrantLock lockZaocan = new ReentrantLock();
    private static Condition conditionZaocan = lockZaocan.newCondition();
    private static volatile int baozi = 0;
    private static volatile int zhou = 0;
    private static volatile int zaocan = 0;

    public static class ProducerBaozi implements Runnable{
        @Override
        public void run() {
            while (true) {
                try{
                    lockBaozi.lock();
                    while(baozi>=2){
                        conditionBaozi.await();
                    }
                    baozi+=2;
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("生产了两个包子，包子数为"+baozi);
                    conditionBaozi.signal();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    lockBaozi.unlock();
                }
            }
        }
    }

    public static class ProducerZhou implements Runnable{
        @Override
        public void run() {
            while (true) {
                try{
                    lockZhou.lock();
                    while(zhou>=1){
                        conditionZhou.await();
                    }
                    zhou++;
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("生产了一份粥，粥数为"+zhou);
                    conditionZhou.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lockZhou.unlock();
                }
            }
        }
    }

    public static class ProducerDama implements Runnable{
        @Override
        public void run() {
            while (true) {
                try{
                    lockZhou.lock();
                    lockBaozi.lock();
                    while(zhou<1||baozi<2){
                        if(zhou<1) conditionZhou.await();
                        if(baozi<2) conditionBaozi.await();
                    }
                    lockZaocan.lock();
                    while(zaocan>=1){
                        conditionZaocan.await();
                    }
                    zhou--;
                    baozi-=2;
                    zaocan++;
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("大妈打了一份饭，现在有"+zaocan+"份");
                    conditionZaocan.signalAll();
                    conditionBaozi.signalAll();
                    conditionZhou.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lockZaocan.unlock();
                    lockBaozi.unlock();
                    lockZhou.unlock();
                }
            }
        }
    }

    public static class ConsumerStudent implements Runnable{

        @Override
        public void run() {
            while (true) {
                try{
                    lockZaocan.lock();
                    while(zaocan<=0){
                        conditionZaocan.await();
                    }
                    zaocan--;
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("学生拿走了一份饭，现在有"+zaocan+"份");
                    conditionZaocan.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ProducerBaozi()).start();
        new Thread(new ProducerZhou()).start();
        new Thread(new ProducerDama()).start();
        new Thread(new ConsumerStudent()).start();
    }
}
