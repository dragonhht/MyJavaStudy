package bridging;

/**
 * TV遥控器的抽象化对象
 * <p>
 * User : Dragon_hht
 * Date : 17-3-31
 * Time : 下午8:17
 */
public abstract class TVRemoteControl {
    private TV implementor;

    public void powerOn() {
        implementor.powerOn();
    }

    public void powerOff() {
        implementor.powerOff();
    }

    public void setChannel(int channel) {
        implementor.changeChannel(channel);
    }
}
