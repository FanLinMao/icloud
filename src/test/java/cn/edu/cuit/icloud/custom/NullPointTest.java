package cn.edu.cuit.icloud.custom;

import java.util.ArrayList;

import org.junit.Test;

import cn.edu.cuit.icloud.pojo.User;

/**
 * TODO
 * @date: 2020Äê3ÔÂ11ÈÕ
 * @author: flfan
 */
public class NullPointTest {
	
	@Test
	public void testNullPoint(){
		/*User user = new User();
		System.out.println(null == user.getUsername());
		ArrayList<String> arrayList = new ArrayList<String>();
		System.out.println(0== arrayList.size());*/
	}
	@Test
	public void testNullString(){
		String str = null + "haha";
		System.out.println(str);
	}
	
}
