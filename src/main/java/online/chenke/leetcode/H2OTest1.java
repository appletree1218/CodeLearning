package online.chenke.leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class H2OTest1 {
    public static void main(String[] args) {
        H2O1 h2O = new H2O1();
        new Thread(()->{
            try {
                h2O.oxygen(()->{
                    System.out.println("O");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                h2O.oxygen(()->{
                    System.out.println("O");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                h2O.hydrogen(()->{
                    System.out.println("H");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                h2O.hydrogen(()->{
                    System.out.println("H");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                h2O.hydrogen(()->{
                    System.out.println("H");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                h2O.hydrogen(()->{
                    System.out.println("H");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class H2O1 {
    ReentrantLock lock = new ReentrantLock();
    Condition hCondition = lock.newCondition();
    Condition oCondition = lock.newCondition();

    volatile int h=0;
    volatile int o=0;

    public H2O1() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();

        if ((o+h)==3){
            o=0;
            h=0;
            hCondition.signalAll();
            oCondition.signalAll();
        }

        while (h>=2){
            hCondition.await();
        }

        releaseHydrogen.run();
        h++;

        lock.unlock();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();

        if ((o+h)==3){
            o=0;
            h=0;
            hCondition.signalAll();
            oCondition.signalAll();
        }

        while (o>=1){
            oCondition.await();
        }

        releaseOxygen.run();
        o++;

        lock.unlock();
    }
}