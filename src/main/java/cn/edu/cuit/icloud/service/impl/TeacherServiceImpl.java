package cn.edu.cuit.icloud.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import cn.edu.cuit.icloud.annotation.Role;
import cn.edu.cuit.icloud.constant.RoleEnum;
import cn.edu.cuit.icloud.dao.TeacherDao;
import cn.edu.cuit.icloud.dto.UserDTO;
import cn.edu.cuit.icloud.pojo.Event;
import cn.edu.cuit.icloud.pojo.User;
import cn.edu.cuit.icloud.service.LoginService;
import cn.edu.cuit.icloud.service.UserService;
import cn.edu.cuit.icloud.vo.ArrangeVO;
import cn.edu.cuit.icloud.vo.EventVO;

/**
 * TODO
 * @date: 2020年3月10日
 * @author: flfan
 */
@Role(type=RoleEnum.TEACHER)
public class TeacherServiceImpl implements UserService,LoginService {

	static Logger logger = Logger.getLogger(TeacherServiceImpl.class);
	
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
		logger.info("教师登录");
		return teacherDao.login(user.getUsername(), user.getPassword(), user.getRole());
	}

	public boolean addEvent(EventVO eventVo){
		Event e = new Event();
		if(null != eventVo){
			e.setEventId(eventVo.getEventId());
			if(StringUtils.isEmpty(eventVo.getEventId())){
				e.setEventId(UUID.randomUUID().toString()); 
			}
			e.setTitle(eventVo.getEvent());
			e.setStart(eventVo.getStartTime());
			e.setEnd(eventVo.getEndTime());
			e.setUrl(eventVo.getUrl());
			e.setGroupId(eventVo.getGroupId());
			e.setUser(eventVo.getUser());
			return teacherDao.addEvent(e) > 0;
		}
		return false;
		
	}
	
	public List<Event> getAllEvents(){
		List<Event> allEvents = teacherDao.findAllEvent();
		
		return allEvents;
	}
	
	public List<ArrangeVO> getAllArranges(){
		List<ArrangeVO> allArranges = teacherDao.findAllArranges();
		return allArranges;
	}
	
	public boolean addArrange(ArrangeVO arrangeVO){
		return teacherDao.addArrange(arrangeVO) > 0;
	}
	
}
