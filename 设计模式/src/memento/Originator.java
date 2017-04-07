package memento;

/**
 * 发起者
 * <p>
 * User : Dragon_hht
 * Date : 17-4-7
 * Time : 下午2:20
 */
public class Originator {
    private String state;

    public void setState(String state) {
        System.out.println("Setting state to ");
        this.state = state;
    }

    public Memento saveToMemento() {
        System.out.println("Saving to Memento:");
        return new Memento(state);
    }

    public void restoreFormMemento(Memento memento) {
        state = memento.getSaveState();
        System.out.println("Restoring state from Memento:");
    }
}
