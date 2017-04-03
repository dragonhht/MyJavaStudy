package proxy;

/**
 * 代理模式测试类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-3
 * Time : 下午3:17
 */
public class TestProxy {
    public static void main(String[] arg) {
        Image image = new ProxyImage("路径");

        image.showImage();
    }
}
