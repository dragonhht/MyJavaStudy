package handler;

/**
 * ClassDescription
 * <p>
 * User : Dragon_hht
 * Date : 17-4-4
 * Time : 下午2:22
 */
public abstract class Logger {
    public static int ERR = 3;
    public static int NOTICE = 5;
    public static int DEBUG = 7;
    protected int mask;
    //链中的下一个元素
    protected Logger next;

    public Logger setNext(Logger log) {
        next = log;
        return log;
    }

    public void message(String msg, int priority) {
        if (priority <=mask) {
            writeMessage(msg);
        }
        if (next !=null) {
            next.message(msg, priority);
        }
    }

    abstract protected void writeMessage(String msg);
}
