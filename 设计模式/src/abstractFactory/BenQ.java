package abstractFactory;

/**
 * 奔驰汽车
 * 产品类
 * <p>
 * User : Dragon_hht
 * Date : 17-3-29
 * Time : 下午8:23
 */
public class BenQ implements Car{
    @Override
    public Parts getWheels() {
        return new Parts("BenQ Wheels");
    }

    @Override
    public Parts getMirrors() {
        return new Parts("BenQ Mirrors");
    }

    @Override
    public Parts getEngine() {
        return new Parts("BenQ Engine");
    }

    @Override
    public Parts getBody() {
        return new Parts("BenQ Body");
    }
}
