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
 * HmacRipeMD系列的加密校验,秘钥不同加密结果也不同
 */
public class HmacRipeMdTest {

    /**
     * 使用 Bouncy Castle 的HmacRipeMD128
     */
    @Test
    public void HmacRipeMD128() throws NoSuchAlgorithmException, InvalidKeyException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 添加BouncyCastleProvider支持
        Security.addProvider(new BouncyCastleProvider());

        // 初始化KeyGenerator, 并指明算法
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacRipeMD128");
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
     * 使用 Bouncy Castle 的HmacRipeMD160
     */
    @Test
    public void HmacRipeMD160() throws NoSuchAlgorithmException, InvalidKeyException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 添加BouncyCastleProvider支持
        Security.addProvider(new BouncyCastleProvider());

        // 初始化KeyGenerator, 并指明算法
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacRipeMD160");
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
}
