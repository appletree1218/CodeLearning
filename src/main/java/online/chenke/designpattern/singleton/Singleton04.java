package online.chenke.designpattern.singleton;

/**
 * 双重检查锁
 * 线程安全
 * 懒加载
 */
public class Singleton04 {
    private Singleton04(){}

    private static Singleton04 instance = null;

    public static Singleton04 getInstance(){
        if(instance == null){
            synchronized (Singleton04.class){
                if(instance == null){
                    //容易发生指令重排造成某个线程拿到半初始化状态的对象进行使用
                    instance = new Singleton04();
                }
            }
        }

        return instance;
    }
}
