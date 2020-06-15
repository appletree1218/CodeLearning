package online.chenke.juc;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

        for (int i=0;i<18;i++){
            new Thread(()->{
                try {
                    readLock.lock();
                    System.out.println("read...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    readLock.unlock();
                }

            }).start();
        }

        for (int i=0;i<2;i++){
            new Thread(()->{
                try {
                    writeLock.lock();
                    System.out.println("write...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    writeLock.unlock();
                }
            }).start();
        }

    }
}
