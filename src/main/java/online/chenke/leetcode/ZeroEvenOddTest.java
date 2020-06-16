package online.chenke.leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 交替打印0和奇偶数
 */
public class ZeroEvenOddTest {
    public static void main(String[] args) throws InterruptedException {
        int n = 5;
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);

        IntConsumer zeroConsumer = System.out::print;
        IntConsumer evenConsumer = System.out::print;
        IntConsumer oddConsumer = System.out::print;

        new Thread(()->{
            try {
                zeroEvenOdd.zero(zeroConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                zeroEvenOdd.even(evenConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                zeroEvenOdd.odd(oddConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}

class ZeroEvenOdd {
    private int n;

    Semaphore zeroSemaphore = new Semaphore(1);
    Semaphore evenSemaphore = new Semaphore(0);
    Semaphore oddSemaphore = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=0;i<n;i++){
            zeroSemaphore.acquire();
            printNumber.accept(0);
            if(i%2==0){
                oddSemaphore.release();
            }else{
                evenSemaphore.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=2;i<=n;i+=2){
            evenSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i+=2){
            oddSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }
}
