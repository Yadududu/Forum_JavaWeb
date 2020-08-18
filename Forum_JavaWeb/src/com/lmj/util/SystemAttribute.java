package com.lmj.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class SystemAttribute {
	//生成Id
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	//生成时间
	public static String getTime() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}
}
