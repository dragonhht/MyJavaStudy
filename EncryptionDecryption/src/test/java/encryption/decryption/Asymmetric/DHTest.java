package encryption.decryption.Asymmetric;

import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Hex;
import org.junit.Test;

import javax.crypto.*;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by huang on 17-6-3.
 * DH的加密和解密
 */
public class DHTest {

    /** 非对称加密算法. */
    private static final String KEY_ALGORITHM = "DH";
    /**
     * 对称加密秘钥算法.
     * 可选: DES, DESede, AES
     */
    private static final String SECRET_ALGORITHM = "AES";
    /** 秘钥长度. */
    private static final int KEY_SIZE = 512;
    /** 公钥. */
    private static final String PUBLIC_KEY = "PUBLICKEY";
    /** 私钥. */
    private static final String PRIVATE_KEY = "PRIVATEKEY";

    /**
     * 初始化甲方秘钥.
     * @return 甲方秘钥
     */
    public Map<String, Object> initKey() throws NoSuchAlgorithmException {
        // 实例化秘钥对生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        // 初始化密钥对生成器
        keyPairGenerator.initialize(KEY_SIZE);
        // 生成密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // 甲方私钥
        DHPrivateKey privateKey = (DHPrivateKey) keyPair.getPrivate();
        // 甲方公钥
        DHPublicKey publicKey = (DHPublicKey) keyPair.getPublic();

        Map<String, Object> keyMap = new HashMap<String, Object>();
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);

        return keyMap;
    }

    /**
     * 初始化乙方秘钥.
     * @param key 甲方公钥
     * @return 乙方秘钥
     */
    public Map<String, Object> initKey(byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException {
        /*解析甲方公钥*/
        // 转换公钥材料
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(key);
        // 实例化秘钥工厂
        KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 产生公钥
        PublicKey publicKey = factory.generatePublic(keySpec);
        // 由甲方公钥构建乙方秘钥
        DHParameterSpec parameterSpec = ((DHPublicKey)publicKey).getParams();
        // 实例化秘钥对生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(factory.getAlgorithm());
        // 初始化秘钥生成器
        keyPairGenerator.initialize(parameterSpec);
        // 产生秘钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // 乙方公钥
        DHPublicKey publicKey1 = (DHPublicKey) keyPair.getPublic();
        // 乙方私钥
        DHPrivateKey privateKey1 = (DHPrivateKey) keyPair.getPrivate();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put(PUBLIC_KEY, publicKey1);
        map.put(PRIVATE_KEY, privateKey1);

        return map;
    }


    /**
     * 加密.
     * @param data 待加密的数据
     * @param key 秘钥
     * @return 已加密的数据
     */
    public byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成本地秘钥
        SecretKey secretKey = new SecretKeySpec(key, SECRET_ALGORITHM);
        // 数据加密
        Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] a = cipher.doFinal(data);

        return a;
    }

    /**
     * 解密.
     * @param data 待解密书记
     * @param key 秘钥
     * @return 已解密数据
     * @throws Exception
     */
    public byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成本地秘钥
        SecretKey secretKey = new SecretKeySpec(key, SECRET_ALGORITHM);
        // 数据解密
        Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] a = cipher.doFinal(data);

        return a;
    }

    /**
     * 构建秘钥
     * @param publicKey 公钥
     * @param privateKey 私钥
     * @return 本地秘钥
     * @throws Exception
     */
    public byte[] getSecretKey(byte[] publicKey, byte[] privateKey) throws Exception {
        // 实例化秘钥工厂
        KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);

        /*初始化公钥*/
        // 秘钥材料转换
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKey);
        // 产生公钥
        PublicKey publicKey1 = factory.generatePublic(x509EncodedKeySpec);

        /*初始化私钥*/
        // 秘钥转换材料
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKey);
        // 产生私钥
        PrivateKey privateKey1 = factory.generatePrivate(pkcs8EncodedKeySpec);

        // 实例化
        KeyAgreement keyAgreement = KeyAgreement.getInstance(factory.getAlgorithm());
        // 初始化
        keyAgreement.init(privateKey1);
        keyAgreement.doPhase(publicKey1, true);

        // 生成本地秘钥
        SecretKey secretKey = keyAgreement.generateSecret(SECRET_ALGORITHM);
        byte[] a = secretKey.getEncoded();

        return a;
    }

    /**
     * 取得私钥.
     * @param keyMap 秘钥Map
     * @return 私钥
     * @throws Exception
     */
    public byte[] getPrivateKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        byte[] a = key.getEncoded();

        return a;
    }

    /**
     * 取得公钥.
     * @param keyMap 秘钥map
     * @return 公钥
     * @throws Exception
     */
    public byte[] getPublicKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        byte[] a = key.getEncoded();
        return a;
    }

    @Test
    public void test() throws Exception {
        // 生成甲方密钥对
        Map<String, Object> keyMap1 = initKey();
        byte[] publicKey = getPublicKey(keyMap1);
        byte[] privateKey = getPrivateKey(keyMap1);
        System.out.println("甲方公钥: " + new String(Base64.encode(publicKey)));
        System.out.println("甲方私钥: " + new String(Base64.encode(privateKey)));

        // 由甲方公钥产生本地秘钥对
        Map<String, Object> keyMap2 = initKey(publicKey);
        byte[] publicKey2 = getPublicKey(keyMap2);
        byte[] privateKey2 = getPrivateKey(keyMap2);
        System.out.println("乙方公钥: " + new String(Base64.encode(publicKey2)));
        System.out.println("乙方私钥: " + new String(Base64.encode(privateKey2)));

        byte[] key1 = getSecretKey(publicKey2, privateKey);
        System.out.println("甲方本地秘钥: " + new String(Base64.encode(key1)));
        byte[] key2 = getSecretKey(publicKey, privateKey2);
        System.out.println("乙方本地秘钥: " + new String(Base64.encode(key2)));
        assertArrayEquals(key1, key2);

        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 使用甲方本地秘钥对数据进行加密
        byte[] code1 = encrypt(input.getBytes(), key1);
        System.out.println("甲方加密: " + new String(code1));
        System.out.println("甲方加密: " + new String(Hex.encode(code1)));
        // 使用乙方本地密钥对数据解密
        byte[] decode1 = decrypt(code1, key2);
        System.out.println("乙方解密: " + new String(decode1));
        System.out.println("乙方解密: " + new String(Hex.encode(decode1)));

        // 使用乙方本地秘钥对数据进行加密
        byte[] code2 = encrypt(input.getBytes(), key2);
        System.out.println("乙方加密: " + new String(code2));
        System.out.println("乙方加密: " + new String(Hex.encode(code2)));
        // 使用甲方本地密钥对数据解密
        byte[] decode2 = decrypt(code2, key1);
        System.out.println("甲方解密: " + new String(decode2));
        System.out.println("甲方解密: " + new String(Hex.encode(decode2)));
    }
}
