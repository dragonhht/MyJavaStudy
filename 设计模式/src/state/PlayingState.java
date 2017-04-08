package state;

/**
 * 具体状态类
 * 选择了播放状态
 * <p>
 * User : Dragon_hht
 * Date : 17-4-8
 * Time : 上午10:18
 */
public class PlayingState implements State{

    @Override
    public void pressPlay(MusicPlayerContextInterface musicPlayerContextInterface) {
        musicPlayerContextInterface.setState(new StandbyState());
    }
}
