package com.fjl.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 针对字符串进行的一系列判断方法 判断字符串是否为空
 * 
 * @author fujianglong
 *
 */
public class StringUtils {

	// trim() 去除字符串两边空白
	public static boolean isEmpty(String info) {
		if (info == null || info.trim().equals("")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isEmpty(Date info) {
		if (info == null) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isEmpty(Integer grade) {
		// TODO Auto-generated method stub
		if (grade == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 生成订单编号
	 * 
	 * @return
	 */
	public static String createOrderCodeId() {

		String uuid = UUID.randomUUID().toString().replace("-", "");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = sdf.format(new Date());
		String orderCode = uuid + time;

		return orderCode;
	}

}
