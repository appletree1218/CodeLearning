package online.chenke.leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 交替打印0和奇偶数
 */
public class ZeroEvenOddTest1 {
    public static void main(String[] args) {
        int n = 5;
        ZeroEvenOdd1 zeroEvenOdd = new ZeroEvenOdd1(n);

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

class ZeroEvenOdd1 {
    private int n;
    private int index=0;

    public ZeroEvenOdd1(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=0;i<n;){
            synchronized (this){
                if(index%2==0){
                    printNumber.accept(0);
                    index++;
                    i++;
                    this.notifyAll();
                }else{
                    this.wait();
                }
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int j=2;j<=n;){
            synchronized (this) {
                if(index%2!=0 && (index+1)/2%2==0){
                    printNumber.accept(j);
                    j+=2;
                    index++;
                    this.notifyAll();
                }else{
                    this.wait();
                }
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int j=1;j<=n;){
            synchronized (this) {
                if(index%2!=0 && (index+1)/2%2!=0){
                    printNumber.accept(j);
                    index++;
                    j+=2;
                    this.notifyAll();
                }else{
                    this.wait();
                }
            }
        }
    }
}
