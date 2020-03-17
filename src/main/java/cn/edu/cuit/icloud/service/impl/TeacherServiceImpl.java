package cn.edu.cuit.icloud.service.impl;

import java.util.List;

import cn.edu.cuit.icloud.annotation.Role;
import cn.edu.cuit.icloud.constant.RoleEnum;
import cn.edu.cuit.icloud.dao.TeacherDao;
import cn.edu.cuit.icloud.dto.UserDTO;
import cn.edu.cuit.icloud.pojo.User;
import cn.edu.cuit.icloud.service.LoginService;
import cn.edu.cuit.icloud.service.UserService;

/**
 * TODO
 * @date: 2020Äê3ÔÂ10ÈÕ
 * @author: flfan
 */
@Role(type=RoleEnum.TEACHER)
public class TeacherServiceImpl implements UserService,LoginService {

	private TeacherDao teacherDao = new TeacherDao();
	
	@Override
	public User findUserById(int userId) {
		return teacherDao.findUserById(userId);
	}

	@Override
	public List<User> findAllUser() {
		return null;
	}

	@Override
	public int addUser(User user) {
		return teacherDao.addUser(user);
	}

	@Override
	public int deleteUserById(int userId) {
		return teacherDao.deleteUserById(userId);
	}

	@Override
	public int updateUser(User user) {
		return teacherDao.updateUser(user);
	}

	@Override
	public User login(UserDTO user) {
		return teacherDao.login(user.getUsername(), user.getPassword(), user.getRole());
	}

}
