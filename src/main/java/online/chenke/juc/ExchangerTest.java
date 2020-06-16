package online.chenke.juc;

import java.util.concurrent.Exchanger;

public class ExchangerTest {
    public static void main(String[] args) {
        String t1Name = "t1";
        String t2Name = "t2";
        Exchanger exchanger = new Exchanger();

        Thread t1 = new Thread(()->{
            try {
                Object exchange = exchanger.exchange(t2Name);
                System.out.println("==="+exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }, t1Name);
        Thread t2 = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            try {
                Object exchange = exchanger.exchange(t1Name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, t2Name);

        t1.start();
        t2.start();
    }
}
