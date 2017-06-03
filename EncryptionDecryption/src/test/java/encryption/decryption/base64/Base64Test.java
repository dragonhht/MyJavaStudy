package encryption.decryption.base64;


import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.UrlBase64;
import org.junit.Test;

/**
 * Created by huang on 17-6-3.
 * base64的编码和解码
 */
public class Base64Test {

    @Test
    public  void base64Test() {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 编码
        String code = new String(Base64.encode(input.getBytes()));
        System.out.println("编码后: " + code);

        // 解码
        code = new String(Base64.decode(code.getBytes()));
        System.out.println("解码后: " + code);

    }

    @Test
    public void urlBase64Test() {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 编码
        String code = new String(UrlBase64.encode(input.getBytes()));
        System.out.println("编码后: " + code);

        // 解码
        code = new String(UrlBase64.decode(code.getBytes()));
        System.out.println("解码后: " + code);
    }
}
