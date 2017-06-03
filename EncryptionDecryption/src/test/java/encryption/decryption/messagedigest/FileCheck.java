package encryption.decryption.messagedigest;

import org.bouncycastle.util.encoders.Hex;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by huang on 17-6-3.
 * 文件的校验
 */
public class FileCheck {

    /**
     * 得到MD5的校验码
     * @return 文件的MD5校验码
     */
    @Test
    public String MD5Code() throws IOException, NoSuchAlgorithmException {
        String code = null;

        File file = new File("test.xml");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileInputStream fis = new FileInputStream(file);

        // 初始化MessageDigest, 并指明MD5算法
        DigestInputStream dis = new DigestInputStream(fis, MessageDigest.getInstance("MD5"));

        int len = 1024;
        byte[] buffer = new byte[len];
        int read = dis.read(buffer, 0, len);
        while (read > -1) {
            read = dis.read(buffer, 0, len);
        }
        fis.close();
        dis.close();

        // 获得MessageDigest
        MessageDigest md = dis.getMessageDigest();

        byte[] a = md.digest();

        code = new String(Hex.encode(a));

        System.out.println("MD5: " + code);

        return code;
    }

}
