package hht.dragon.utils;

import java.util.UUID;

/**
 * 获取随机字符
 * <p>
 * User : Dragon_hht
 * Date : 17-5-15
 * Time : 下午7:12
 */
public class Uuid {
	public static String getUuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
