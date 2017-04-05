package command;

/**
 * 使用命令模式
 * <p>
 * User : Dragon_hht
 * Date : 17-4-5
 * Time : 下午7:30
 */
public class PressSwitch {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        Command switchOn = new StartCommand(airConditioner);
        Command switchOff = new StopCommand(airConditioner);

        Switch sw = new Switch();

        try {
            if (args[0].equalsIgnoreCase("ON")) {
                sw.storeAndExecute(switchOn);
                System.exit(0);
            }

            if (args[0].equalsIgnoreCase("OFF")) {
                sw.storeAndExecute(switchOff);
                System.exit(0);
            }

            System.out.println("Argument \"ON \" or \" OFF \" is required");
        }catch (Exception ex) {
            System.out.println("Argument required");
        }
    }
}
