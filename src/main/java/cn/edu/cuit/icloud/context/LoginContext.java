package cn.edu.cuit.icloud.context;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

import cn.edu.cuit.icloud.annotation.Role;
import cn.edu.cuit.icloud.dto.MessageDTO;
import cn.edu.cuit.icloud.dto.UserDTO;
import cn.edu.cuit.icloud.pojo.User;
import cn.edu.cuit.icloud.service.LoginService;

/**
 * 登录上下文
 * @date: 2020年3月11日
 * @author: flfan
 */
public class LoginContext {
	
	private static Map<Integer, Object> objMap = new HashMap<Integer,Object>();
	private UserDTO userDto;
	static{
		String pkg = "cn.edu.cuit.icloud.service.impl";
		Reflections reflections = new Reflections(pkg);
		Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(Role.class);
		for (Class<?> clazz : typesAnnotatedWith) {
			Role role = clazz.getAnnotation(Role.class);
			try {
				objMap.put(role.type().getCode(), clazz.newInstance());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public LoginContext(UserDTO userDto){
		this.userDto = userDto;
	}
	
	public MessageDTO login() throws Exception{
		LoginService loginService = (LoginService)objMap.get(getUser().getRole());
		MessageDTO dto = loginService.loginCheck(getUser());
		return dto;
	}

	public UserDTO getUser() {
		return userDto;
	}

	

	
	
	
}
