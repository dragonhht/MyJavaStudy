package bridging;

/**
 * 扩充抽象化对象
 * <p>
 * User : Dragon_hht
 * Date : 17-3-31
 * Time : 下午8:21
 */
public class ConcreteTVRemoteControl extends TVRemoteControl{
    private int currentChannel;

    public void nextChannel() {
        currentChannel++;
        setChannel(currentChannel);
    }

    public void prevChannel() {
        currentChannel--;
        setChannel(currentChannel);
    }
}
