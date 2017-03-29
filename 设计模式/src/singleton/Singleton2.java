package singleton;

/**
 * 单例模式
 * 被动实例化（赖汉模式）
 * <p>
 * User : Dragon_hht
 * Date : 17-3-29
 * Time : 下午9:17
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2(){}

    public synchronized static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }

        return instance;
    }
}
