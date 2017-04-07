package memento;

/**
 * 测试类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-7
 * Time : 下午2:24
 */
public class MementoTest {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();
        originator.setState("State 1");
        originator.setState("State 2");
        caretaker.addMemento(originator.saveToMemento());
        originator.setState("State 3");
        caretaker.addMemento(originator.saveToMemento());
        originator.restoreFormMemento(caretaker.getMemento(1));
    }
}
