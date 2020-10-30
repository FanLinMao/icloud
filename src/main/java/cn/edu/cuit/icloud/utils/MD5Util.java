package cn.edu.cuit.icloud.utils;

import java.security.MessageDigest;

/**
 * TODO
 * @date: 2020年3月30日
 * @author: flfan
 */
public class MD5Util {
	
	private static final String KEY_MD5 = "MD5";
	
	public final static String encryMD5(String originStr) {
        try {
            MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
            md5.update(originStr.getBytes());
            byte[] bytes = md5.digest();
            StringBuffer sb = new StringBuffer();
            //将整数转换成十六进制形式的字符串 这里与0xff进行与运算的原因是保证转换结果为32位
            for (int i = 0; i < bytes.length; i++) {
                int val = ((int) bytes[i]) & 0xff;
                if (val < 16){
                	sb.append("0");
                }
                sb.append(Integer.toHexString(val));
            }
            return sb.toString().toUpperCase();
        } catch (Exception e) {
            return null;
        }
    }

	
}
