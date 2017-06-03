package encryption.decryption.messagedigest;


import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
import org.junit.Test;
import static org.junit.Assert.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * Created by huang on 17-6-3.
 * MD系列的加密校验
 */
public class MDTest {

    /**
     * 使用Java自带的MD2
     */
    @Test
    public void MD2Test() throws NoSuchAlgorithmException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 初始化MessageDigest,并指定为MD2
        MessageDigest md = MessageDigest.getInstance("MD2");

        // 加密
        byte[] a = md.digest(input.getBytes());
        byte[] b = md.digest(input.getBytes());
        // 校验
        assertArrayEquals(a, b);

        // 输出16进制数
        System.out.println("加密后: " + new String(Hex.encode(a)));

    }

    /**
     * 使用Java自带的MD5
     */
    @Test
    public void MD5Test() throws NoSuchAlgorithmException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 初始化MessageDigest,并指定为MD5
        MessageDigest md = MessageDigest.getInstance("MD5");

        // 加密
        byte[] a = md.digest(input.getBytes());
        byte[] b = md.digest(input.getBytes());
        // 校验
        assertArrayEquals(a, b);

        // 输出16进制数
        System.out.println("加密后: " + new String(Hex.encode(a)));
    }

    /**
     * 使用 Bouncy Castle 的MD4
     */
    @Test
    public void MD4Test() throws NoSuchAlgorithmException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 加入 BouncyCastleProvider的支持
        Security.addProvider(new BouncyCastleProvider());
        // 初始化MessageDigest,并指定为MD4
        MessageDigest md = MessageDigest.getInstance("MD4");

        // 加密
        byte[] a = md.digest(input.getBytes());
        byte[] b = md.digest(input.getBytes());
        // 校验
        assertArrayEquals(a, b);

        // 输出16进制数
        System.out.println("加密后: " + new String(Hex.encode(a)));
    }
}
