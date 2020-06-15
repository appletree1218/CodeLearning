package online.chenke.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        int n = 8;
        CountDownLatch countDownLatch = new CountDownLatch(n);

        for (int i = 0; i < n; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println(finalI);
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        System.out.println("finish");
    }
}
