package online.chenke.designpattern.singleton;

/**
 * 静态内部类
 * 线程安全
 * 懒加载
 */
public class Singleton03 {
    private Singleton03(){}

    private static class Singleton03Holder{
        private final static Singleton03 instance = new Singleton03();
    }

    public static Singleton03 getInstance(){
        return Singleton03Holder.instance;
    }
}
