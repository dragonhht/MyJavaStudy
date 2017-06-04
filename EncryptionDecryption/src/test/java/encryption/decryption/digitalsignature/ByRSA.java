package encryption.decryption.digitalsignature;

import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Hex;
import org.junit.Before;
import org.junit.Test;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Created by huang on 17-6-4.
 * 使用RSA(这里为MD5withRSA)实现数字签名
 */
public class ByRSA {

    /** 秘钥算法. */
    private static final String KEY_ALGORITHM = "RSA";
    /** 签名/验证算法. */
    private static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    /** 公钥. */
    private static final String PUBLIC_KEY = "RSAPublicKey";
    /** 私钥. */
    private static final String PRIVATE_KEY = "RSAPrivateKey";
    /** 秘钥长度. */
    private static final int KEY_SIZE = 512;

    /**
     * 签名
     * @param data 待签名的数据
     * @param privateKey 私钥
     * @return 数字签名
     * @throws Exception
     */
    public byte[] sign(byte[] data, byte[] privateKey) throws Exception {
        // 装换私钥材料
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKey);
        // 实例化秘钥工厂
        KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 去私钥对象
        PrivateKey priKey = factory.generatePrivate(pkcs8EncodedKeySpec);
        // 实例化Singnature
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        // 初始化Signature
        signature.initSign(priKey);
        // 更新
        signature.update(data);
        // 签名
        return signature.sign();
    }

    /**
     * 校验.
     * @param data 待校验的数据
     * @param publicKey 公钥
     * @param sign 数字签名
     * @return 校验结果
     * @throws Exception
     */
    public boolean verify(byte[] data, byte[] publicKey, byte[] sign) throws Exception {
        // 转换公钥材料
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKey);
        // 实例化秘钥工厂
        KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 生成公钥
        PublicKey pubKey = factory.generatePublic(keySpec);
        // 示例化Signature
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        // 初始化Signature
        signature.initVerify(pubKey);
        // 更新
        signature.update(data);
        // 验证
        return signature.verify(sign);
    }

    /**
     * 获取私钥.
     * @param keyMap 秘钥Map
     * @return 私钥
     * @throws Exception
     */
    public byte[] getPrivateKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return key.getEncoded();
    }

    /**
     * 取得公钥.
     * @param keyMap 秘钥Map
     * @return 公钥
     * @throws Exception
     */
    public byte[] getPublicKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return key.getEncoded();
    }

    /**
     * 初始化秘钥
     * @return 秘钥Map
     * @throws Exception
     */
    public Map<String, Object> initKey() throws Exception {
        // 实例化秘钥对生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        // 初始化密钥对生成器
        keyPairGenerator.initialize(KEY_SIZE);
        // 生成密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // 公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        // 私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        // 封装秘钥
        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

    /**
     * 测试签名
     * @throws Exception
     */
    @Test
    public void testSign() throws Exception {
        Map<String, Object> keyMap = initKey();
        byte[] publicKey = getPublicKey(keyMap);
        byte[] privateKey = getPrivateKey(keyMap);
        System.out.println("公钥: " + new String(Base64.encode(publicKey)));
        System.out.println("私钥: " + new String(Base64.encode(privateKey)));

        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 产生签名
        byte[] sign = sign(input.getBytes(), privateKey);
        System.out.println("签名: " + new String(Hex.encode(sign)));

        // 验证签名
        boolean ok = verify(input.getBytes(), publicKey, sign);
        System.out.println("验证: " + ok);
        // 验证
        assertTrue(ok);
    }
}
