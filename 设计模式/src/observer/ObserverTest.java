package observer;

/**
 * 测试类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-8
 * Time : 上午9:54
 */
public class ObserverTest {
    public static void main(String[] args) {
        TemperatureStation temperatureStation = new TemperatureStation(38);
        TemperatureCustomer1 temperatureCustomer1 = new TemperatureCustomer1();
        TemperatureCustomer2 temperatureCustomer2 = new TemperatureCustomer2();

        temperatureStation.addObserver(temperatureCustomer1);
        temperatureStation.addObserver(temperatureCustomer2);
        temperatureStation.setTemperature(34);
        temperatureStation.removeObserver(temperatureCustomer1);
        temperatureStation.removeObserver(temperatureCustomer2);
        temperatureStation.setTemperature(35);
    }
}
