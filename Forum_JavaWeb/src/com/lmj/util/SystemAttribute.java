package com.lmj.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class SystemAttribute {
	//����Id
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	//����ʱ��
	public static String getTime() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}
}
