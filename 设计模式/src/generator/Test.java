package generator;

/**
 * ClassDescription
 * <p>
 * User : Dragon_hht
 * Date : 17-3-30
 * Time : 下午10:27
 */
public class Test {
    public static void main(String[] arg) {
        CarBuilder lowPriceCarBuilder = new LowPriceCarBuilder();
        MechaincalEngineer engineer = new MechaincalEngineer(lowPriceCarBuilder);
        engineer.buildCar();
        Car car = engineer.getCar();
        System.out.println("Builder Constructed Car:"+car);
    }
}
