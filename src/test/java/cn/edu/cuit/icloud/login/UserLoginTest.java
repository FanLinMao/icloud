package cn.edu.cuit.icloud.login;

import org.junit.Test;

import cn.edu.cuit.icloud.context.LoginContext;
import cn.edu.cuit.icloud.dto.UserDTO;
import cn.edu.cuit.icloud.pojo.User;

/**
 * TODO
 * @date: 2020Äê3ÔÂ12ÈÕ
 * @author: flfan
 */
public class UserLoginTest {
	
	@Test
	public void testLogin() throws Exception{
		UserDTO userDTO = new UserDTO("admin","123456",1);
		LoginContext loginContext = new LoginContext(userDTO);
		User user = loginContext.login();
		System.out.println(user);
	}
}
