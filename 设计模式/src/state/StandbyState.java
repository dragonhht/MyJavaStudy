package state;

/**
 * 具体状态类
 * 选择了暂停
 * <p>
 * User : Dragon_hht
 * Date : 17-4-8
 * Time : 上午10:24
 */
public class StandbyState implements State{
    @Override
    public void pressPlay(MusicPlayerContextInterface musicPlayerContextInterface) {
        musicPlayerContextInterface.setState(new PlayingState());
    }
}
