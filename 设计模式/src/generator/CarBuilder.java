package generator;

/**
 * 生成器接口
 * <p>
 * User : Dragon_hht
 * Date : 17-3-30
 * Time : 下午10:09
 */
public interface CarBuilder {
    public void buildBase();
    public void buildWheels();
    public void buildEngine();
    public void buildRoof();
    public void buildMirrors();
    public void buildLights();
    public void buildInterior();
    public Car getCar();
}
