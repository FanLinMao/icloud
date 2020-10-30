package cn.edu.cuit.icloud.service;

import cn.edu.cuit.icloud.dto.MessageDTO;
import cn.edu.cuit.icloud.dto.UserDTO;
import cn.edu.cuit.icloud.pojo.User;

/**
 * TODO
 * @date: 2020年3月11日
 * @author: flfan
 */
public interface LoginService {
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public User login(UserDTO user);
	/**
	 * 登录校验
	 * @return
	 */
	public MessageDTO loginCheck(UserDTO user);
}
