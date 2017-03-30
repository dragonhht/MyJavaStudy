package generator;

/**
 * 生成器的第一个实现
 * 具体生成器
 * <p>
 * User : Dragon_hht
 * Date : 17-3-30
 * Time : 下午10:12
 */
public class LowPriceCarBuilder implements CarBuilder{
    private Car car;

    public LowPriceCarBuilder(){
        car = new Car();
    }

    @Override
    public void buildBase() {
        car.setBase("Low prices base");
    }

    @Override
    public void buildWheels() {
        car.setWheels("Low prices wheels");
    }

    @Override
    public void buildEngine() {
        car.setEngine("Low prices engine");
    }

    @Override
    public void buildRoof() {
        car.setRoof("Low prices roof");
    }

    @Override
    public void buildMirrors() {
        car.setMirrors("Low prices mirrors");
    }

    @Override
    public void buildLights() {
        car.setLights("Low prices lights");
    }

    @Override
    public void buildInterior() {
        car.setInterior("Low prices interior");
    }

    @Override
    public Car getCar() {
        return this.car;
    }
}
