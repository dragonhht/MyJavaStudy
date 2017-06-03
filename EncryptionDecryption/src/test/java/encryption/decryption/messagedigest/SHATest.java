package encryption.decryption.messagedigest;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
import org.junit.Before;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by huang on 17-6-3.
 * SHA系列的加密校验
 */
public class SHATest {



    /**
     * 使用Java自带的SHA-1
     */
    @Test
    public void SHA_1() throws NoSuchAlgorithmException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 初始化MessageDigest,并指定SHA算法
        MessageDigest md = MessageDigest.getInstance("SHA");

        // 加密
        byte[] a = md.digest(input.getBytes());
        byte[] b = md.digest(input.getBytes());
        // 校验
        assertArrayEquals(a, b);

        // 输出16进制数
        System.out.println("加密后: " + new String(Hex.encode(a)));
    }


    /**
     * 使用Java自带的SHA-256
     */
    @Test
    public void SHA_256() throws NoSuchAlgorithmException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 初始化MessageDigest,并指定SHA算法
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // 加密
        byte[] a = md.digest(input.getBytes());
        byte[] b = md.digest(input.getBytes());
        // 校验
        assertArrayEquals(a, b);

        // 输出16进制数
        System.out.println("加密后: " + new String(Hex.encode(a)));
    }



    /**
     * 使用Java自带的SHA-384
     */
    @Test
    public void SHA_384() throws NoSuchAlgorithmException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 初始化MessageDigest,并指定SHA算法
        MessageDigest md = MessageDigest.getInstance("SHA-384");

        // 加密
        byte[] a = md.digest(input.getBytes());
        byte[] b = md.digest(input.getBytes());
        // 校验
        assertArrayEquals(a, b);

        // 输出16进制数
        System.out.println("加密后: " + new String(Hex.encode(a)));
    }


    /**
     * 使用Java自带的SHA-512
     */
    @Test
    public void SHA_512() throws NoSuchAlgorithmException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 初始化MessageDigest,并指定SHA算法
        MessageDigest md = MessageDigest.getInstance("SHA-512");

        // 加密
        byte[] a = md.digest(input.getBytes());
        byte[] b = md.digest(input.getBytes());
        // 校验
        assertArrayEquals(a, b);

        // 输出16进制数
        System.out.println("加密后: " + new String(Hex.encode(a)));
    }


    /**
     * 使用 Bouncy Castle 的SHA-224
     */
    @Test
    public void SHA_224() throws NoSuchAlgorithmException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 加入 BouncyCastleProvider的支持
        Security.addProvider(new BouncyCastleProvider());
        // 初始化MessageDigest,并指定SHA算法
        MessageDigest md = MessageDigest.getInstance("SHA-224");

        // 加密
        byte[] a = md.digest(input.getBytes());
        byte[] b = md.digest(input.getBytes());
        // 校验
        assertArrayEquals(a, b);

        // 输出16进制数
        System.out.println("加密后: " + new String(Hex.encode(a)));
    }
}
