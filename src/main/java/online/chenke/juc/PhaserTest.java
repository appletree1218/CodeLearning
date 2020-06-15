package online.chenke.juc;

import java.util.concurrent.Phaser;

public class PhaserTest {
    static Phaser phaser = new CustomPhaser();

    public static void main(String[] args) {
        int n = 7;

        phaser.bulkRegister(n);
        for (int i = 0; i < n-2; i++) {
            new Thread(new Person("p"+i)).start();
        }

        new Thread(new Person("a")).start();
        new Thread(new Person("b")).start();
    }

    static class Person implements Runnable{
        private String name;

        public Person(String name){
            this.name = name;
        }

        public void phaser1(){
            phaser.arriveAndAwaitAdvance();
        }

        public void phaser0(){
            phaser.arriveAndAwaitAdvance();
        }

        public void phaser2(){
            if(name.equals("a") || name.equals("b")){
                phaser.arriveAndAwaitAdvance();
            }else{
                phaser.arriveAndDeregister();
            }
        }

        @Override
        public void run() {
            phaser0();
            phaser1();
            phaser2();
        }
    }

    static class CustomPhaser extends Phaser{
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {

            if(phase==0){
                System.out.println("phaser0:"+registeredParties);
                return false;
            }else if(phase==1){
                System.out.println("phaser1:"+registeredParties);
                return false;
            }else if(phase==2){
                System.out.println("phaser2:"+registeredParties);
                return true;
            }else{
                return true;
            }
        }
    }
}
