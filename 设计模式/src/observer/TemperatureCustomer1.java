package observer;

/**
 * 具体观察者 1
 * <p>
 * User : Dragon_hht
 * Date : 17-4-8
 * Time : 上午9:51
 */
public class TemperatureCustomer1 implements TemperatureObserver{
    @Override
    public void update(int temoerature) {
        System.out.println("Customer 1 found the temperature as : "+temoerature);
    }
}
