package handler;

/**
 * ClassDescription
 * <p>
 * User : Dragon_hht
 * Date : 17-4-4
 * Time : 下午2:28
 */
public class StdoutLogger extends Logger{
    public StdoutLogger(int mask) {
        this.mask = mask;
    }
    @Override
    protected void writeMessage(String msg) {
        System.out.println("Writing to stdout:"+msg);
    }
}
