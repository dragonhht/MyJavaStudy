package encryption.decryption.messagedigest;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
import org.junit.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by huang on 17-6-3.
 * MAC系列的加密校验,秘钥不同加密结果也不同
 */
public class MACTest {

    /**
     * 使用Java自带的HmacMD5
     */
    @Test
    public void HmacMD5() throws NoSuchAlgorithmException, InvalidKeyException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 初始化KeyGenerator, 并指明算法
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
        // 产生秘钥
        SecretKey secretKey = keyGenerator.generateKey();

        // 获得秘钥
        //byte[] key = secretKey.getEncoded();
        // 还原秘钥
        //SecretKey secretKey = new SecretKeySpec(key, "HmacMD5");

        // 实例化Mac
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        // 初始化Mac
        mac.init(secretKey);
        // 加密
        byte[] a = mac.doFinal(input.getBytes());
        byte[] b = mac.doFinal(input.getBytes());
        // 校验
        assertArrayEquals(a, b);

        // 输出16进制数
        System.out.println("加密后: " + new String(Hex.encode(a)));
    }


    /**
     * 使用Java自带的HmacSHA1
     */
    @Test
    public void HmacSHA1() throws NoSuchAlgorithmException, InvalidKeyException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 初始化KeyGenerator, 并指明算法
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA1");
        // 产生秘钥
        SecretKey secretKey = keyGenerator.generateKey();

        // 获得秘钥
        //byte[] key = secretKey.getEncoded();
        // 还原秘钥
        //SecretKey secretKey = new SecretKeySpec(key, "HmacSHA1");

        // 实例化Mac
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        // 初始化Mac
        mac.init(secretKey);
        // 加密
        byte[] a = mac.doFinal(input.getBytes());
        byte[] b = mac.doFinal(input.getBytes());
        // 校验
        assertArrayEquals(a, b);

        // 输出16进制数
        System.out.println("加密后: " + new String(Hex.encode(a)));
    }


    /**
     * 使用Java自带的HmacSHA256
     */
    @Test
    public void HmacSHA256() throws NoSuchAlgorithmException, InvalidKeyException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 初始化KeyGenerator, 并指明算法
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
        // 产生秘钥
        SecretKey secretKey = keyGenerator.generateKey();

        // 获得秘钥
        //byte[] key = secretKey.getEncoded();
        // 还原秘钥
        //SecretKey secretKey = new SecretKeySpec(key, "HmacSHA256");

        // 实例化Mac
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        // 初始化Mac
        mac.init(secretKey);
        // 加密
        byte[] a = mac.doFinal(input.getBytes());
        byte[] b = mac.doFinal(input.getBytes());
        // 校验
        assertArrayEquals(a, b);

        // 输出16进制数
        System.out.println("加密后: " + new String(Hex.encode(a)));
    }

    /**
     * 使用Java自带的HmacSHA384
     */
    @Test
    public void HmacSHA384() throws NoSuchAlgorithmException, InvalidKeyException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 初始化KeyGenerator, 并指明算法
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA384");
        // 产生秘钥
        SecretKey secretKey = keyGenerator.generateKey();

        // 获得秘钥
        //byte[] key = secretKey.getEncoded();
        // 还原秘钥
        //SecretKey secretKey = new SecretKeySpec(key, "HmacSHA384");

        // 实例化Mac
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        // 初始化Mac
        mac.init(secretKey);
        // 加密
        byte[] a = mac.doFinal(input.getBytes());
        byte[] b = mac.doFinal(input.getBytes());
        // 校验
        assertArrayEquals(a, b);

        // 输出16进制数
        System.out.println("加密后: " + new String(Hex.encode(a)));
    }


    /**
     * 使用Java自带的HmacSHA512
     */
    @Test
    public void HmacSHA512() throws NoSuchAlgorithmException, InvalidKeyException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 初始化KeyGenerator, 并指明算法
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA512");
        // 产生秘钥
        SecretKey secretKey = keyGenerator.generateKey();

        // 获得秘钥
        //byte[] key = secretKey.getEncoded();
        // 还原秘钥
        //SecretKey secretKey = new SecretKeySpec(key, "HmacSHA512");

        // 实例化Mac
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        // 初始化Mac
        mac.init(secretKey);
        // 加密
        byte[] a = mac.doFinal(input.getBytes());
        byte[] b = mac.doFinal(input.getBytes());
        // 校验
        assertArrayEquals(a, b);

        // 输出16进制数
        System.out.println("加密后: " + new String(Hex.encode(a)));
    }


    /**
     * 使用 Bouncy Castle 的HmacMD2
     */
    @Test
    public void HmacMD2() throws NoSuchAlgorithmException, InvalidKeyException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 添加BouncyCastleProvider支持
        Security.addProvider(new BouncyCastleProvider());

        // 初始化KeyGenerator, 并指明算法
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD2");
        // 产生秘钥
        SecretKey secretKey = keyGenerator.generateKey();

        // 获得秘钥
        //byte[] key = secretKey.getEncoded();
        // 还原秘钥
        //SecretKey secretKey = new SecretKeySpec(key, "HmacMD2");

        // 实例化Mac
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        // 初始化Mac
        mac.init(secretKey);
        // 加密
        byte[] a = mac.doFinal(input.getBytes());
        byte[] b = mac.doFinal(input.getBytes());
        // 校验
        assertArrayEquals(a, b);

        // 输出16进制数
        System.out.println("加密后: " + new String(Hex.encode(a)));
    }


    /**
     * 使用 Bouncy Castle 的HmacMD4
     */
    @Test
    public void HmacMD4() throws NoSuchAlgorithmException, InvalidKeyException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 添加BouncyCastleProvider支持
        Security.addProvider(new BouncyCastleProvider());

        // 初始化KeyGenerator, 并指明算法
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD4");
        // 产生秘钥
        SecretKey secretKey = keyGenerator.generateKey();

        // 获得秘钥
        //byte[] key = secretKey.getEncoded();
        // 还原秘钥
        //SecretKey secretKey = new SecretKeySpec(key, "HmacMD4");

        // 实例化Mac
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        // 初始化Mac
        mac.init(secretKey);
        // 加密
        byte[] a = mac.doFinal(input.getBytes());
        byte[] b = mac.doFinal(input.getBytes());
        // 校验
        assertArrayEquals(a, b);

        // 输出16进制数
        System.out.println("加密后: " + new String(Hex.encode(a)));
    }


    /**
     * 使用 Bouncy Castle 的HmacSHA224
     */
    @Test
    public void HmacSHA224() throws NoSuchAlgorithmException, InvalidKeyException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 添加BouncyCastleProvider支持
        Security.addProvider(new BouncyCastleProvider());

        // 初始化KeyGenerator, 并指明算法
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA224");
        // 产生秘钥
        SecretKey secretKey = keyGenerator.generateKey();

        // 获得秘钥
        //byte[] key = secretKey.getEncoded();
        // 还原秘钥
        //SecretKey secretKey = new SecretKeySpec(key, "HmacSHA224");

        // 实例化Mac
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        // 初始化Mac
        mac.init(secretKey);
        // 加密
        byte[] a = mac.doFinal(input.getBytes());
        byte[] b = mac.doFinal(input.getBytes());
        // 校验
        assertArrayEquals(a, b);

        // 输出16进制数
        System.out.println("加密后: " + new String(Hex.encode(a)));
    }
}
