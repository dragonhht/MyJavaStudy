package observer;

/**
 * 被观察者接口
 * <p>
 * User : Dragon_hht
 * Date : 17-4-8
 * Time : 上午9:38
 */
public interface TemperatureSubject {
    public void addObserver(TemperatureObserver temperatureObserver);
    public void removeObserver(TemperatureObserver temperatureObserver);
    public void notify2();
}
