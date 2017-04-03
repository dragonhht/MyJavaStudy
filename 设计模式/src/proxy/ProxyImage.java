package proxy;

import java.net.URL;

/**
 * 代理类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-3
 * Time : 下午3:11
 */
public class ProxyImage implements Image{

    private String url;

    public ProxyImage(String url) {
        this.url = url;
    }

    //该方法会委托给真实类,在调用该方法之前不需要实际使用数据
    @Override
    public void showImage() {
        RealImage realImage = new RealImage(url);
        realImage.showImage();
    }
}
