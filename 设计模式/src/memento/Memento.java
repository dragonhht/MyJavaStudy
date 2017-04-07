package memento;

import mediator.Mediator;

/**
 * 备忘录
 * 会保存发起者的状态信息，而这些信息不能由管理者修改
 * <p>
 * User : Dragon_hht
 * Date : 17-4-7
 * Time : 下午2:13
 */
public class Memento {
    private String state;

    public Memento(String stateToSave) {
        state = stateToSave;
    }

    public String getSaveState() {
        return state;
    }
}
