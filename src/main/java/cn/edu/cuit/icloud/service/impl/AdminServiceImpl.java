package cn.edu.cuit.icloud.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import cn.edu.cuit.icloud.annotation.Role;
import cn.edu.cuit.icloud.constant.RoleEnum;
import cn.edu.cuit.icloud.dao.AdminDao;
import cn.edu.cuit.icloud.dto.UserDTO;
import cn.edu.cuit.icloud.pojo.User;
import cn.edu.cuit.icloud.service.LoginService;
import cn.edu.cuit.icloud.service.UserService;

/**
 * TODO
 * @date: 2020年3月10日
 * @author: flfan
 */
@Role(type=RoleEnum.ADMIN)
public class AdminServiceImpl implements UserService,LoginService {
	
	private Logger logger = Logger.getLogger(AdminServiceImpl.class);
	
	private AdminDao userDao = new AdminDao();
	
	@Override
	public User login(UserDTO user) {
		logger.info("管理员登录");
		return userDao.login(user.getUsername(), user.getPassword(), user.getRole());
	}

	@Override
	public User findUserById(int userId) {
		// TODO Auto-generated method stub
		return userDao.findUserById(userId);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	@Override
	public int deleteUserById(int userId) {
		// TODO Auto-generated method stub
		return userDao.deleteUserById(userId);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	

}
