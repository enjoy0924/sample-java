package com.allere.sample.zookeeper.configure.util;

public class StringUtils {
	
	public static boolean isNotEmpty(String s) {
		return !isEmpty(s);
	}
	
	public static boolean isEmpty(String s) {
		return s == null || "".equals(s.trim());
	}
}
