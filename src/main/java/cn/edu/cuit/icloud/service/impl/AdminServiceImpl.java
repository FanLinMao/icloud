package cn.edu.cuit.icloud.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import cn.edu.cuit.icloud.annotation.Role;
import cn.edu.cuit.icloud.constant.ActionEnum;
import cn.edu.cuit.icloud.constant.FrequenceEnum;
import cn.edu.cuit.icloud.constant.RoleEnum;
import cn.edu.cuit.icloud.constant.WeekEnum;
import cn.edu.cuit.icloud.dao.AdminDao;
import cn.edu.cuit.icloud.dto.UserDTO;
import cn.edu.cuit.icloud.pojo.User;
import cn.edu.cuit.icloud.service.LoginService;
import cn.edu.cuit.icloud.service.UserService;
import cn.edu.cuit.icloud.vo.TaskVO;

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
	//==========定时管理start=============
	public boolean addTask(TaskVO vo) {
		//add QuartzJob
		return userDao.addTask(vo)>0;
		
	}
	public List<TaskVO> findAllTasks(){
		List<TaskVO> tasks = userDao.findAllTasks();
		tasks.stream().map(obj->{
			obj.setAction(ActionEnum.getDesp(obj.getAction()));
			obj.setFrequence(FrequenceEnum.getDesp(obj.getFrequence()));
			obj.setCycle(WeekEnum.getDesp(obj.getCycle()));
			return obj;
		}).collect(Collectors.toList());
		return tasks;
	}
	public boolean batchDeleteTask(String taskIds) {
		return userDao.deleteTasks(taskIds)>0;
		
	}
	public boolean editTask(TaskVO task) {
		
		return userDao.updateTask(task)>0;
		
	}
	/**
	 * 更新任务开关状态
	 * @param taskId
	 * @param status
	 * @return
	 */
	public boolean updateStatus(int taskId, int status) {
		return userDao.updateStatus(taskId, status)>0;
	}
	//==========定时管理end===============
}
