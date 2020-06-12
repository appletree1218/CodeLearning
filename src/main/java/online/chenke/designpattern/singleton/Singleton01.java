package online.chenke.designpattern.singleton;

/**
 * 饿汉
 * 线程安全
 * 不能懒加载
 *
 * 不能懒加载，提前初始化浪费空间，所以出现懒汉式{@link Singleton02}
 */
public class Singleton01 {
    private static final Singleton01 instance = new Singleton01();

    private Singleton01(){}

    public static Singleton01 getInstance(){
        return instance;
    }
}
