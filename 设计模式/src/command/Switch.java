package command;

import java.util.ArrayList;
import java.util.List;

/**
 * 调用者
 * <p>
 * User : Dragon_hht
 * Date : 17-4-5
 * Time : 下午7:21
 */
public class Switch {
    private List<Command> commandHistory = new ArrayList<Command>();

    public Switch() {

    }

    public void storeAndExecute(Command cmd) {
        this.commandHistory.add(cmd);
        cmd.execute();
    }
}
