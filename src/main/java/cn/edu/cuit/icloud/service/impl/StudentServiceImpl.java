package cn.edu.cuit.icloud.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import cn.edu.cuit.icloud.annotation.Role;
import cn.edu.cuit.icloud.constant.RoleEnum;
import cn.edu.cuit.icloud.dao.StudentDao;
import cn.edu.cuit.icloud.dto.UserDTO;
import cn.edu.cuit.icloud.pojo.User;
import cn.edu.cuit.icloud.service.LoginService;
import cn.edu.cuit.icloud.service.UserService;

/**
 * TODO
 * @date: 2020Äê3ÔÂ10ÈÕ
 * @author: flfan
 */
@Role(type=RoleEnum.STUDENT)
public class StudentServiceImpl implements UserService,LoginService {

	private Logger logger = Logger.getLogger(StudentServiceImpl.class);
	
	private StudentDao stuDao = new StudentDao();
	
	@Override
	public User findUserById(int userId) {
		
		return stuDao.findUserById(userId);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addUser(User user) {
		
		return stuDao.addUser(user);
	}

	@Override
	public int deleteUserById(int userId) {
		// TODO Auto-generated method stub
		return stuDao.deleteUserById(userId);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return stuDao.updateUser(user);
	}

	@Override
	public User login(UserDTO user) {
		
		return stuDao.login(user.getUsername(), user.getPassword(), user.getRole());
	}

}
