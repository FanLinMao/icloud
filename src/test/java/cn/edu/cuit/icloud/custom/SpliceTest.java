package cn.edu.cuit.icloud.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.Test;

import cn.edu.cuit.icloud.pojo.User;

/**
 * TODO
 * @date: 2020年3月20日
 * @author: flfan
 */
public class SpliceTest {
	
	@Test
	public void testStrSplice(){
		User user = new User.Builder().setUserId(1)
				.setEmail("test@163.com")
				.setPassword("")
				.setRole(1)
				.setUsername("admin")
				.setEnable(1)
				.setPhone("18234567123")
				.builder();
		StringBuffer sql = new StringBuffer("update sys_user set");
		List<Object> params = new ArrayList<Object>();
		try{
			if(Objects.isNull(user.getUserId())){
				System.out.println("怎么会引发空指针");
				return;
			}
		}catch(Exception e){
			System.out.println("请设置userId");
			System.out.println(e.getMessage());
			return;
		}
		if(!Objects.isNull(user.getUsername())){
			sql.append(" username=?,");
			params.add(user.getUsername());
		}
		if(!Objects.isNull(user.getPassword()) && !"".equals(user.getPassword())){
			sql.append(" password=?,");
			params.add(user.getPassword());
		}
		if(!Objects.isNull(user.getRole())){
			sql.append(" role=?,");
			params.add(user.getRole());
		}
		if(!Objects.isNull(user.getPhone())){
			sql.append(" phone=?,");
			params.add(user.getPhone());
		}
		if(!Objects.isNull(user.getEmail())){
			sql.append(" email=?,");
			params.add(user.getEmail());
		}
		if(!Objects.isNull(user.getWechat())){
			sql.append(" wechat=?,");
			params.add(user.getWechat());
		}
		if(!Objects.isNull(user.getEnable())){
			sql.append(" enable=?,");
			params.add(user.getEnable());
		}
		sql.replace(sql.lastIndexOf(","), sql.length(), "");
		sql.append(" where userId=?");
		params.add(user.getUserId());
		System.out.println(sql.toString());
		params.forEach(s->System.out.print(s+"\t"));
	}
	@Test
	public void testNullStr(){
		Integer st = null;
		/*System.out.println(!"".equals(""));
		System.out.println(!"".equals(null));
		System.out.println(null != null);
		System.out.println(null != "");
		System.out.println(null != "123456");
		System.out.println(Objects.isNull(""));
		System.out.println(Objects.isNull("123456"));
		System.out.println(Objects.isNull(null));
		System.out.println(Objects.isNull(0));
		System.out.println(null != Integer.valueOf(2));*/
		
		System.out.println(st != null);
		String str ="";
		System.out.println(str.length());
	}
}
