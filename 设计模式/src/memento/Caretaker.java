package memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理者
 * 需要处理在何时、为何发起者进行数据保存和回滚
 * <p>
 * User : Dragon_hht
 * Date : 17-4-7
 * Time : 下午2:15
 */
public class Caretaker {
    private List<Memento> saveState = new ArrayList<Memento>();

    public void addMemento(Memento memento) {
        saveState.add(memento);
    }

    public Memento getMemento(int index) {
        return saveState.get(index);
    }

}
