package online.chenke.juc;

import java.util.LinkedList;
import java.util.Random;

public class ContainerTest1 {
    public static void main(String[] args) {
        Random random = new Random();
        CustomContainer1<Integer> customContainer = new CustomContainer1<>(5);

        for (int i=0;i<2;i++){
            new Thread(()->{
                try {
                    for (int j=0;j<100;j++){
                        int i1 = random.nextInt();
                        System.out.println("生产了"+i1);
                        customContainer.put(i1);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i=0;i<10;i++){
            new Thread(()->{
                for (int j=0;j<100;j++){
                    try {
                        System.out.println("拿了："+customContainer.get());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
}

class CustomContainer1<T>{
    private LinkedList<T> list = new LinkedList<>();

    private int size=0;
    private int limit=0;

    public CustomContainer1(int limit){
        this.limit = limit;
    }

    public synchronized void put(T t) throws InterruptedException {
        while (list.size()==limit){
            this.wait();
            System.out.println("满了");
        }

        list.add(t);
        size++;
        this.notifyAll();
    }

    public synchronized T get() throws InterruptedException {
        while (list.size()==0){
            System.out.println("空了");
            this.wait();

            return null;
        }

        size--;
        this.notifyAll();
        return list.poll();
    }

}
