package command;

/**
 * 开启空调的具体命令
 * <p>
 * User : Dragon_hht
 * Date : 17-4-5
 * Time : 下午7:27
 */
public class StartCommand implements Command{

    private AirConditioner airConditioner;

    public StartCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }
    @Override
    public void execute() {
        airConditioner.start();
    }
}
