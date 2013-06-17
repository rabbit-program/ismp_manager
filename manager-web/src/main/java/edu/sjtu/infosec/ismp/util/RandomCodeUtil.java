package edu.sjtu.infosec.ismp.util;

import org.apache.commons.lang.RandomStringUtils;

public class RandomCodeUtil {

	/**
	 * 产生唯一的随机码
	 * @return String
	 */
	public static String getSingleRandomCode() {
		return RandomStringUtils.random(19, "abcdefghijkmnlopqrstuvwxyzABCDEFGHIJKMNLOPQRSTUVWXYZ0123456789") + String.valueOf(System.currentTimeMillis());
	}
}
