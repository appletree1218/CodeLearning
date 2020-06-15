package online.chenke.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 达到指定的线程数后执行
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        int n = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(n,()->{
            System.out.println("满了");
        });

        for (int i = 0; i < n; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    cyclicBarrier.await();
                    System.out.println(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
