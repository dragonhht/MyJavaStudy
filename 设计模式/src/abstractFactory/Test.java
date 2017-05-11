package abstractFactory;

/**
 * ClassDescription
 * <p>
 * User : Dragon_hht
 * Date : 17-3-29
 * Time : 下午8:31
 */
public class Test {
    public static void main(String[] arg) {
        CarFactory carFactory = new CarFactory();
        Car car = carFactory.getCar("BWM");

        System.out.println(car.getWheels().getSpecification());
    }
}
