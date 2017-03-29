package abstractFactory;

/**
 * 返回工厂类Car的抽象工厂类
 * <p>
 * User : Dragon_hht
 * Date : 17-3-29
 * Time : 下午8:27
 */
public class CarFactory {
    public Car car = null;

    public Car getCar(String carType) {
        if ("BenQ".equals(carType)) {
            car = new BenQ();
        }else if ("BWM".equals(carType)) {
            car = new BWM();
        }

        return car;
    }
}
