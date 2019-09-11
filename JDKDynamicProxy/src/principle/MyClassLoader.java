package principle;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 自定义类记载器.
 *
 * @author: huang
 * @Date: 2019-9-11
 */
public class MyClassLoader extends ClassLoader {

    private static final String CLASS_SUFFIX = ".class";
    private static final String JAR_SUFFIX = ".jar";

    Map<String, Class<?>> classMap = new ConcurrentHashMap<>();

    private String classPath;

    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    public Class<?> findClass(String className) throws ClassNotFoundException {
        String filePath = className;
        if (filePath.endsWith(CLASS_SUFFIX)) {
            filePath = filePath.substring(0, filePath.lastIndexOf(CLASS_SUFFIX));
            className = filePath;
        }

        if (classMap.get(className) != null) {
            return classMap.get(className);
        }

        filePath = filePath.replace('.', File.separatorChar);
        filePath = classPath + File.separatorChar + filePath + CLASS_SUFFIX;
        try {
            byte[] bytes = getClassBytes(new File(filePath));
            return defineClass(className, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(className);
    }

    private byte[] getClassBytes(File file) {
        // 使用NIO
        FileInputStream fis = null;
        FileChannel fc = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel wbc = null;
        ByteBuffer bb = null;
        try {
            fis = new FileInputStream(file);
            fc = fis.getChannel();
            wbc = Channels.newChannel(baos);
            bb = ByteBuffer.allocate(1024);

            while (fc.read(bb) != -1) {
                bb.flip();
                wbc.write(bb);
                bb.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (wbc != null) {
                try {
                    wbc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fc != null) {
                try {
                    fc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return baos.toByteArray();
    }

}
