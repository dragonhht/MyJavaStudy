package generator;

/**
 *
 * <p>
 * User : Dragon_hht
 * Date : 17-3-30
 * Time : 下午10:20
 */
public class MechaincalEngineer {
    private CarBuilder carBuilder;

    public MechaincalEngineer(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public Car getCar() {
        return carBuilder.getCar();
    }

    public void buildCar() {
        carBuilder.buildBase();
        carBuilder.buildEngine();
        carBuilder.buildInterior();
        carBuilder.buildLights();
        carBuilder.buildMirrors();
        carBuilder.buildRoof();
        carBuilder.buildWheels();
    }
}
