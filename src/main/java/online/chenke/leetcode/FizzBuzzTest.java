package online.chenke.leetcode;

import java.util.function.IntConsumer;

public class FizzBuzzTest {
    public static void main(String[] args) {
    }
}

class FizzBuzz {
    private int n;
    private int index=1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (this){
            while (index<=n){
                if (index % 3 == 0 && index % 5 != 0){
                    printFizz.run();
                    index++;
                    this.notifyAll();
                }else{
                    this.wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (this){
            while (index<=n) {
                if (index % 3 != 0 && index % 5 == 0) {
                    printBuzz.run();
                    index++;
                    this.notifyAll();
                }else{
                    this.wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (this) {
            while (index <= n) {
                if (index % 3 == 0 && index % 5 == 0) {
                    printFizzBuzz.run();
                    index++;
                    this.notifyAll();
                }else{
                    this.wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (index <= n) {
                if (index % 3 != 0 && index % 5 != 0) {
                    printNumber.accept(index);
                    index++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }
}
