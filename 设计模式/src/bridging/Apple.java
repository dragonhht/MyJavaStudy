package bridging;

/**
 * 具体实现化对象 2
 * <p>
 * User : Dragon_hht
 * Date : 17-3-31
 * Time : 下午8:15
 */
public class Apple implements TV{
    @Override
    public void powerOn() {
        System.out.println("Apple powerOn");
    }

    @Override
    public void powerOff() {
        System.out.println("Apple powerOff");
    }

    @Override
    public void changeChannel(int channel) {
        System.out.println("Apple changeChannel:"+channel);
    }
}
