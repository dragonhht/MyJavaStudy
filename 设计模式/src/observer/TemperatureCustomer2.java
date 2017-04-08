package observer;

/**
 * 具体观察者 2
 * <p>
 * User : Dragon_hht
 * Date : 17-4-8
 * Time : 上午9:53
 */
public class TemperatureCustomer2 implements TemperatureObserver{
    @Override
    public void update(int temoerature) {
        System.out.println("Customer 2 found the temperature as : "+temoerature);
    }
}
