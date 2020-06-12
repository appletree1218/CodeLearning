package online.chenke.designpattern.singleton;

/**
 * 枚举
 * 线程安全
 * 不是懒加载
 *
 * 锁粒度太大，所以出现DCL{@link Singleton04}
 */
public class Singleton06 {
    private static Singleton06 instance = null;

    private Singleton06(){}

    public static synchronized Singleton06 getInstance(){
        if(instance == null){
            instance = new Singleton06();
        }

        return instance;
    }
}
