package singleton;

/**
 * 单例模式
 * 主动实例化（饿汉模式）
 * <p>
 * User : Dragon_hht
 * Date : 17-3-29
 * Time : 下午9:00
 */
public class Singleton {
    //创建类的唯一实例
    private static Singleton instance = new Singleton();

    //将构造方法变为私有
    private Singleton(){}

    //提供一个公开的获取实例的方法
    public static Singleton getInstance(){
        return instance;
    }
}
