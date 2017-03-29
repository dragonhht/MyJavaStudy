package abstractFactory;


/**
 * 所有汽车的基类
 * <p>
 * User : Dragon_hht
 * Date : 17-3-29
 * Time : 下午8:17
 */
public interface Car {
    //车轮
    public Parts getWheels();
    //后视镜
    public Parts getMirrors();
    //引擎
    public Parts getEngine();
    //车身
    public Parts getBody();
}
