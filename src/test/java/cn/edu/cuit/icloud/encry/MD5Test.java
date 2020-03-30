package cn.edu.cuit.icloud.encry;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import cn.edu.cuit.icloud.utils.MD5Util;

/**
 * TODO
 * @date: 2020Äê3ÔÂ30ÈÕ
 * @author: flfan
 */
public class MD5Test {
	
	@Test
	public void testMD5(){
		String password = "123456";
		String encryMD5 = MD5Util.encryMD5(password);
		System.out.println(encryMD5);
			
	}
	
}
