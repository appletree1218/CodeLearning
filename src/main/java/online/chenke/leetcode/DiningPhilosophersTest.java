package online.chenke.leetcode;

import java.util.concurrent.Semaphore;

/**
 * 哲学家进餐
 */
public class DiningPhilosophersTest {
    public static void main(String[] args) {

    }
}

class DiningPhilosophers {
    private Semaphore[] forkSemaphore = {
        new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1), new Semaphore(1)
    };

    private Semaphore count = new Semaphore(2);

    public DiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        Semaphore right = forkSemaphore[philosopher];
        Semaphore left = forkSemaphore[(philosopher+1)%5];

        count.acquire();

        left.acquire();
        right.acquire();
        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        putRightFork.run();
        left.release();
        right.release();

        count.release();

    }
}
