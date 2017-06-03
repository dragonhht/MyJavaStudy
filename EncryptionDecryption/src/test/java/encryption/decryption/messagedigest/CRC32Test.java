package encryption.decryption.messagedigest;

import org.junit.Test;

import java.util.zip.CRC32;

/**
 * Created by huang on 17-6-3.
 * CRC32的加密校验
 */
public class CRC32Test {

    /**
     * CRC32
     */
    @Test
    public void CRC32() {
        String input = "Java加密和解密";
        System.out.println("原文: " + input);

        // 创爱CRC32
        CRC32 crc32 = new CRC32();
        // 更新校验和
        crc32.update(input.getBytes());
        // 转换为16进制
        String code = Long.toHexString(crc32.getValue());
        System.out.println(code);
    }
}
