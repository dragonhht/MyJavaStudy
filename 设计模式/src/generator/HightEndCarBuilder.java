package generator;

/**
 * 生成器的第二个实现
 * 具体生成器
 * <p>
 * User : Dragon_hht
 * Date : 17-3-30
 * Time : 下午10:18
 */
public class HightEndCarBuilder implements CarBuilder{
    private Car car;

    public HightEndCarBuilder(){
        car = new Car();
    }

    @Override
    public void buildBase() {
        car.setBase("Height prices base");
    }

    @Override
    public void buildWheels() {
        car.setWheels("Height prices wheels");
    }

    @Override
    public void buildEngine() {
        car.setEngine("Height prices engine");
    }

    @Override
    public void buildRoof() {
        car.setRoof("Height prices roof");
    }

    @Override
    public void buildMirrors() {
        car.setMirrors("Height prices mirrors");
    }

    @Override
    public void buildLights() {
        car.setLights("Height prices lights");
    }

    @Override
    public void buildInterior() {
        car.setInterior("Height prices interior");
    }

    @Override
    public Car getCar() {
        return this.car;
    }
}
