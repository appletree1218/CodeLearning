package online.chenke.designpattern.singleton;

/**
 * 懒汉
 * 线程不安全
 * 可以懒加载
 *
 * 线程不安全，所以出现线程安全的懒汉式{@link Singleton06}
 */
public class Singleton02 {
    private static Singleton02 instance = null;

    private Singleton02(){}

    public static Singleton02 getInstance(){
        if(instance == null){
            instance = new Singleton02();
        }

        return instance;
    }
}
