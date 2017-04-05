package command;

/**
 * 关闭空调的具体命令
 * <p>
 * User : Dragon_hht
 * Date : 17-4-5
 * Time : 下午7:29
 */
public class StopCommand implements Command{
    private AirConditioner airConditioner;

    public StopCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.stop();
    }
}
