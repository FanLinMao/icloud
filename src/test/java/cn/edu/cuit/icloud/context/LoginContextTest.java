package cn.edu.cuit.icloud.context;

import org.junit.Test;

import cn.edu.cuit.icloud.dto.MessageDTO;
import cn.edu.cuit.icloud.dto.UserDTO;
import cn.edu.cuit.icloud.pojo.User;

/**
 * TODO
 * @date: 2020Äê3ÔÂ11ÈÕ
 * @author: flfan
 */
public class LoginContextTest {
	
	@Test
	public void testLoginContext() throws Exception{
		UserDTO userDTO = new UserDTO("admin","123456",1);
		LoginContext loginContext = new LoginContext(userDTO);
		MessageDTO login = loginContext.login();
		System.out.println(login);
	}
}
