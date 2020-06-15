package online.chenke.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 *
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 */
public class FooBar {
    private int n;

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private int count = 0;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            if (count!=0) {
                condition1.await();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            condition2.signal();
            count=1;
            lock.unlock();
        }

    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            if (count!=1) {
                condition2.await();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printBar.run();
            count=0;
            condition1.signal();
            lock.unlock();
        }
    }

    static class Print_Foo implements Runnable{

        @Override
        public void run() {
            System.out.print("foo");
        }
    }

    static class Print_Bar implements Runnable{

        @Override
        public void run() {
            System.out.print("bar");
        }
    }

    public static void main(String[] args) {
        int n = 2;

        FooBar fooBar = new FooBar(n);
        new Thread(()->{
            try {
                fooBar.foo(new Print_Foo());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                fooBar.bar(new Print_Bar());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

