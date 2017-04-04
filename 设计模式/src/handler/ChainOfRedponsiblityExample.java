package handler;

/**
 * ClassDescription
 * <p>
 * User : Dragon_hht
 * Date : 17-4-4
 * Time : 下午2:33
 */
public class ChainOfRedponsiblityExample {
    public static void main(String[] arg) {

        //创建责任链
        Logger logger,logger1,logger2;
        logger = new StdoutLogger(Logger.DEBUG);
        logger1 = logger.setNext(new EmailLogger(Logger.NOTICE));
        logger2 = logger1.setNext(new StderrLogger(Logger.ERR));

        //由StdoutLogger处理
        logger.message("Entering", Logger.DEBUG);

        //由StdoutLogger和EmailLogger处理
        logger.message("Step 1 completed", Logger.NOTICE);

        //有全部的三个处理器一起处理
        logger.message("An error has occurred",Logger.ERR);
    }
}
