package state;

/**
 * 内容类接口
 * <p>
 * User : Dragon_hht
 * Date : 17-4-8
 * Time : 上午10:15
 */
public interface MusicPlayerContextInterface {
    public State state = null;
    public void requestPlay();
    public void setState(State state);
    public State getState();
}
