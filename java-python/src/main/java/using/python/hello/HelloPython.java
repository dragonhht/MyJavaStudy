package using.python.hello;

import org.python.util.PythonInterpreter;

/**
 * Java 调用Python语句.
 *
 * @author: huang
 * Date: 18-2-11
 */
public class HelloPython {

    public static void main(String[] args) {
        PythonInterpreter python = new PythonInterpreter();
        // 执行Python 输出打印
        python.exec("print('hello world')");
    }
}
