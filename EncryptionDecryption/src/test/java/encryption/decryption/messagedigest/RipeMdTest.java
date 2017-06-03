package encryption.decryption.messagedigest;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by huang on 17-6-3.
 * RipeMD系列的加密校验
 */
public class RipeMdTest {

    /**
     * 使用 Bouncy Castle 的RipeMD128
     */
    @Test
    public void RipeMD128() throws NoSuchAlgorithmException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 加入 BouncyCastleProvider的支持
        Security.addProvider(new BouncyCastleProvider());
        // 初始化MessageDigest,并指定算法
        MessageDigest md = MessageDigest.getInstance("RipeMD128");

        // 加密
        byte[] a = md.digest(input.getBytes());
        byte[] b = md.digest(input.getBytes());
        // 校验
        assertArrayEquals(a, b);

        // 输出16进制数
        System.out.println("加密后: " + new String(Hex.encode(a)));
    }


    /**
     * 使用 Bouncy Castle 的RipeMD160
     */
    @Test
    public void RipeMD160() throws NoSuchAlgorithmException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 加入 BouncyCastleProvider的支持
        Security.addProvider(new BouncyCastleProvider());
        // 初始化MessageDigest,并指定算法
        MessageDigest md = MessageDigest.getInstance("RipeMD160");

        // 加密
        byte[] a = md.digest(input.getBytes());
        byte[] b = md.digest(input.getBytes());
        // 校验
        assertArrayEquals(a, b);

        // 输出16进制数
        System.out.println("加密后: " + new String(Hex.encode(a)));
    }


    /**
     * 使用 Bouncy Castle 的RipeMD256
     */
    @Test
    public void RipeMD256() throws NoSuchAlgorithmException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 加入 BouncyCastleProvider的支持
        Security.addProvider(new BouncyCastleProvider());
        // 初始化MessageDigest,并指定算法
        MessageDigest md = MessageDigest.getInstance("RipeMD256");

        // 加密
        byte[] a = md.digest(input.getBytes());
        byte[] b = md.digest(input.getBytes());
        // 校验
        assertArrayEquals(a, b);

        // 输出16进制数
        System.out.println("加密后: " + new String(Hex.encode(a)));
    }


    /**
     * 使用 Bouncy Castle 的RipeMD320
     */
    @Test
    public void RipeMD320() throws NoSuchAlgorithmException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 加入 BouncyCastleProvider的支持
        Security.addProvider(new BouncyCastleProvider());
        // 初始化MessageDigest,并指定算法
        MessageDigest md = MessageDigest.getInstance("RipeMD320");

        // 加密
        byte[] a = md.digest(input.getBytes());
        byte[] b = md.digest(input.getBytes());
        // 校验
        assertArrayEquals(a, b);

        // 输出16进制数
        System.out.println("加密后: " + new String(Hex.encode(a)));
    }
}
