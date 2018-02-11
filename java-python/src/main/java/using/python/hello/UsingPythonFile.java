package using.python.hello;

import org.python.util.PythonInterpreter;

/**
 * 调用Python文件.
 *
 * @author: huang
 * Date: 18-2-11
 */
public class UsingPythonFile {
    public static void main(String[] args) {
        PythonInterpreter python = new PythonInterpreter();
        // 执行Python文件
        python.execfile("./java-python/src/main/java/using/python/hello/SingleProcess.py");
    }
}
