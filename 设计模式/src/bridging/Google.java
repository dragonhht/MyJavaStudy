package bridging;

/**
 * 具体实现化对象 1
 * <p>
 * User : Dragon_hht
 * Date : 17-3-31
 * Time : 下午8:13
 */
public class Google implements TV{
    @Override
    public void powerOn() {
        System.out.println("Google powerOn");
    }

    @Override
    public void powerOff() {
        System.out.println("Google powerOff");
    }

    @Override
    public void changeChannel(int channel) {
        System.out.println("Google changeChannel:"+channel);
    }
}
