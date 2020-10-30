package cn.edu.cuit.icloud.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import cn.edu.cuit.icloud.annotation.Role;
import cn.edu.cuit.icloud.constant.ActionEnum;
import cn.edu.cuit.icloud.constant.FrequenceEnum;
import cn.edu.cuit.icloud.constant.RoleEnum;
import cn.edu.cuit.icloud.constant.WeekEnum;
import cn.edu.cuit.icloud.dao.AdminDao;
import cn.edu.cuit.icloud.dto.MessageDTO;
import cn.edu.cuit.icloud.dto.UserDTO;
import cn.edu.cuit.icloud.pojo.User;
import cn.edu.cuit.icloud.service.LoginService;
import cn.edu.cuit.icloud.service.UserService;
import cn.edu.cuit.icloud.vo.IsoVO;
import cn.edu.cuit.icloud.vo.RoomVO;
import cn.edu.cuit.icloud.vo.SoftVO;
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
	public TaskVO findTaskById(int taskId) {
		return userDao.findTaskByTaskId(taskId);
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
	public List<TaskVO> findTasksByIds(String taskIds) {
		return userDao.findTasksByIds(taskIds);
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
	
	//===========ISO管理start============
	public IsoVO findIsoById(int id) {
		return userDao.findIsoById(id);
	}
	public List<IsoVO> listIsos() {
		return userDao.listIsos();
	}
	public boolean updateIso(IsoVO vo) {
		return userDao.updateIso(vo)>0;
	}

	
	public boolean deleteIsoById(Integer isoId) {
		
		return userDao.deleteIsoById(isoId)>0;
	}
	
	public List<String> getIsoUrls(){
		return userDao.findResources();
	}
	//===========ISO管理end============
	
	//===========soft管理start============
	public SoftVO findSoftById(int id) {
		return userDao.findSoftById(id);
	}
	public List<SoftVO> listSofts(){
		return userDao.findSofts();
	}
	
	public boolean updateSoft(SoftVO vo) {
		
		return userDao.updateSoft(vo)>0;
	}
	public boolean deleteSoft(Integer softId) {
		return userDao.deleteSoftById(softId)>0;
	}
	//===========soft管理end============
	
	
	//===========机房管理start============
	public List<RoomVO> listRooms(){
		return userDao.findRooms();
	}
	
	public boolean updateRoom(RoomVO vo) {
		return userDao.updateRoom(vo)>0;
	}
	public boolean deleteRoomsByIds(String ids) {
		return userDao.deleteRoomsByIds(ids)>0;
	}
	public boolean addRoom(RoomVO vo) {
		return userDao.insertRoom(vo)>0;
	}
	//===========机房管理end============

	/* (non-Javadoc)
	 * @see cn.edu.cuit.icloud.service.LoginService#loginCheck(cn.edu.cuit.icloud.dto.UserDTO)
	 */
	@Override
	public MessageDTO loginCheck(UserDTO user) {
		return userDao.loginCheck(user.getUsername(), user.getPassword(), user.getRole());
	}
	
}
