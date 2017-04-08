package observer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 具体被观察者
 * <p>
 * User : Dragon_hht
 * Date : 17-4-8
 * Time : 上午9:42
 */
public class TemperatureStation implements TemperatureSubject{

    Set<TemperatureObserver> temperatureObservers;
    int temperature;

    public TemperatureStation(int temperature) {
        temperatureObservers = new HashSet<TemperatureObserver>();
        this.temperature = temperature;
    }
    @Override
    public void addObserver(TemperatureObserver temperatureObserver) {
        temperatureObservers.add(temperatureObserver);
    }

    @Override
    public void removeObserver(TemperatureObserver temperatureObserver) {
        temperatureObservers.remove(temperatureObserver);
    }

    @Override
    public void notify2() {
        Iterator<TemperatureObserver> it = temperatureObservers.iterator();
        while (it.hasNext()) {
            TemperatureObserver temperatureObserver = it.next();
            temperatureObserver.update(temperature);
        }
    }

    public void setTemperature(int newTemperature) {
        System.out.println("Setting temperature to "+ newTemperature);
        temperature = newTemperature;
        notify2();
    }
}
