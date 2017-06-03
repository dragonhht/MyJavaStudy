package encryption.decryption.Symmetric;

import org.bouncycastle.util.encoders.Hex;
import org.junit.Test;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by huang on 17-6-3.
 * 使用DES算法加密和解密
 */
public class DESTest {

    /**
     * DES
     */
    @Test
    public void DES() throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 实例化秘钥生成器
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        // 初始化, 56位秘钥
        keyGenerator.init(56);
        // 生成秘钥
        SecretKey key = keyGenerator.generateKey();

        // 将秘钥转换成二进制便于保存
        byte[] code = key.getEncoded();

        /*还原秘钥*/
        {
            // 实例化DES秘钥材料
            //DESKeySpec desKeySpec = new DESKeySpec(code);
            // 实例化秘钥工厂
            //SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // 生成秘钥
            //SecretKey key1 = keyFactory.generateSecret(desKeySpec);
        }

        /*加密*/
        // 实例化 , 算法/工作模式/填充方式
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        // 初始化, 设为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // 加密
        byte[] a = cipher.doFinal(input.getBytes());

        String str = new String(Hex.encode(a));
        System.out.println("加密后: " + str);


        /*解密*/
        {
            Cipher cipher1 = Cipher.getInstance("DES/ECB/PKCS5Padding");
            // 初始化, 设为解密模式
            cipher1.init(Cipher.DECRYPT_MODE, key);
            // 解密
            byte[] b = cipher1.doFinal(a);

            String str1 = new String(b);
            System.out.println("解密后: " + str1);
        }

    }
}
