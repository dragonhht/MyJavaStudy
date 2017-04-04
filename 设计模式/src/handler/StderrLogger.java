package handler;

/**
 * ClassDescription
 * <p>
 * User : Dragon_hht
 * Date : 17-4-4
 * Time : 下午2:31
 */
public class StderrLogger extends Logger {
    public StderrLogger(int mask) {
        this.mask = mask;
    }
    @Override
    protected void writeMessage(String msg) {
        System.out.println("Sending via stderr:"+msg);
    }
}
