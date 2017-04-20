package com.crazybunqnq.test;

import org.junit.Test;

import com.crazybunqnq.utils.MD5Util;

public class MD5Test {

	@Test
	public void connectionMySQL() {
		System.out.println(MD5Util.getMD5("123456"));
	}
}
