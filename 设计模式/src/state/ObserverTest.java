package state;

/**
 * 测试类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-8
 * Time : 上午10:29
 */
public class ObserverTest {
    public static void main(String[] args) {
        MusicPalyerContext musicPalyerContext = new MusicPalyerContext(new StandbyState());
        musicPalyerContext.requestPlay();
        musicPalyerContext.setState(new PlayingState());

    }
}
