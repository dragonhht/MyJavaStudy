package handler;

/**
 * ClassDescription
 * <p>
 * User : Dragon_hht
 * Date : 17-4-4
 * Time : 下午2:30
 */
public class EmailLogger extends Logger{
    public EmailLogger(int mask) {
        this.mask = mask;
    }
    @Override
    protected void writeMessage(String msg) {
        System.out.println("Sending via email:"+msg);
    }
}
