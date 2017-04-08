package state;

/**
 * 具体内容类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-8
 * Time : 上午10:25
 */
public class MusicPalyerContext implements MusicPlayerContextInterface{
    State state;

    public MusicPalyerContext(State state) {
        this.state = state;
    }

    @Override
    public void requestPlay() {
        state.pressPlay(this);
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public State getState() {
        return state;
    }
}
