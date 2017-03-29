package abstractFactory;

/**
 * 宝马类
 * 产品类
 * <p>
 * User : Dragon_hht
 * Date : 17-3-29
 * Time : 下午8:25
 */
public class BWM implements Car{
    @Override
    public Parts getWheels() {
        return new Parts("BWM Wheels");
    }

    @Override
    public Parts getMirrors() {
        return new Parts("BWM Mirrors");
    }

    @Override
    public Parts getEngine() {
        return new Parts("BWM Engine");
    }

    @Override
    public Parts getBody() {
        return new Parts("BWM Body");
    }
}
