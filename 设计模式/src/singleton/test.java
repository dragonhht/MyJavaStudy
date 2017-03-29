package singleton;

/**
 * ClassDescription
 * <p>
 * User : Dragon_hht
 * Date : 17-3-29
 * Time : 下午9:09
 */
public class test {
    public static void main(String[] arg) {
        //主动实例化
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        if (s1 == s2) {
            System.out.println("为同一个");
        }else {
            System.out.println("不为同一个");
        }

        //被动实例化
        Singleton2 s3 = Singleton2.getInstance();
        Singleton2 s4 = Singleton2.getInstance();

        if (s3 == s4) {
            System.out.println("为同一个");
        }else {
            System.out.println("不为同一个");
        }
    }
}
