package com.fjl.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5 hash算法
 * 
 * @author fujianglong
 *
 */
// 通过hash算法可以生成一个固定长度的数据(使用md5会生成32位16进位制值的字符串)
// hash算法相对来说不好破解,不同的数据经过hash后得到相同值的概率非常小(碰撞的概率非常小)
public class MD5Utils {
	public static String getMD5(String content) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(content.getBytes());
			return getHashString(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String getHashString(MessageDigest digest) {
		StringBuilder builder = new StringBuilder();
		for (byte b : digest.digest()) {
			builder.append(Integer.toHexString((b >> 4) & 0xf));
			builder.append(Integer.toHexString(b & 0xf));
		}
		return builder.toString();
	}

	// 测试
	// public static void main(String[] args) {
	// String md5 = getMD5("admin");
	// System.out.println(md5);
	// }

}
