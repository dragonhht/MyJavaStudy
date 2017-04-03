package proxy;


/**
 * 真实对象
 * <p>
 * User : Dragon_hht
 * Date : 17-4-3
 * Time : 下午3:07
 */
public class RealImage implements Image{

    public RealImage(String url) {
        loadImage(url);
    }

    @Override
    public void showImage() {

    }

    //一个只有真实对象才有的方法
    public void loadImage(String url) {
        //相关操作
    }
}
