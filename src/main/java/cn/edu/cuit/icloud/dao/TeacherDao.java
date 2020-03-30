package cn.edu.cuit.icloud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;

import cn.edu.cuit.icloud.pojo.Event;
import cn.edu.cuit.icloud.pojo.User;
import cn.edu.cuit.icloud.vo.ArrangeVO;
import cn.edu.cuit.icloud.vo.EventVO;

/**
 * TODO
 * @date: 2020年3月11日
 * @author: flfan
 */
public class TeacherDao extends GenericDao {
	
	
	
	/**
	 * 资源预约：请求所有事件
	 * @return
	 */
	public List<Event> findAllEvent(){
		
		List<Event> list = new ArrayList<Event>();
		String sql = "select e.id, e.event_id, e.groupId, e.is_allDay, e.startTime, e.endTime, e.title, e.url, e.classNames, e.editable, e.startEditable, e.durationEditable, e.resourceEditable, e.rendering, e.overlap, e.`constraint`, e.backgroundColor, e.borderColor, e.textColor, e.extendedProps, e.source, u.user_id, u.username, u.role, u.phone, u.email, u.wechat, u.enable from t_event e, sys_user u where e.user_id = u.user_id";
		ResultSet rs = getJdbc().doQuery(sql, new Object[]{});
		Gson gson = new Gson();
		try {
			while(rs.next()){
				Event e = new Event();
				e.setId(rs.getInt(1));
				e.setEventId(rs.getString(2));
				e.setGroupId(rs.getString(3));
				if(rs.getString(4) == "Y"){
					e.setAllDay(true);
				}else{
					e.setAllDay(false);
				}
				e.setStart(rs.getString(5));
				e.setEnd(rs.getString(6));
				e.setTitle(rs.getString(7));
				e.setUrl(rs.getString(8));
				if(!StringUtils.isEmpty(rs.getString(9))){
					e.setClassNames(rs.getString(9).split(","));
				}else{
					e.setClassNames(null);
				}
				if(rs.getString(10) == "Y"){
					e.setEditable(true);
				}else{
					e.setEditable(false);
				}
				if(rs.getString(11) == "Y"){
					e.setStartEditable(true);
				}else{
					e.setStartEditable(false);
				}
				if(rs.getString(12) == "Y"){
					e.setDurationEditable(true);
				}else{
					e.setDurationEditable(false);
				}
				if(rs.getString(13) == "Y"){
					e.setResourceEditable(true);
				}else{
					e.setResourceEditable(false);
				}
				e.setRendering(rs.getString(14));
				if(rs.getString(15) == "Y"){
					e.setOverlap(true);
				}else{
					e.setOverlap(false);
				}
				e.setConstraint(rs.getString(16));
				e.setBackgroundColor(rs.getString(17));
				e.setBorderColor(rs.getString(18));
				e.setTextColor(rs.getString(19));
				e.setExtendedProps(rs.getString(20));
				if(!StringUtils.isEmpty(rs.getString(21))){
					e.setSource(gson.fromJson(rs.getString(21), Event.class));
				}else{
					e.setSource(null);
				}
				User user = new User.Builder()
						.setUserId(rs.getInt(22))
						.setUsername(rs.getString(23))
						.setRole(rs.getInt(24))
						.setPhone(rs.getString(25))
						.setEmail(rs.getString(26))
						.setWechat(rs.getString(27))
						.setEnable(rs.getInt(28))
						.setPassword(UUID.randomUUID().toString())
						.builder();
				e.setUser(user);
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
		return list;
		
	}
	
	
	/**
	 * 资源预约：添加事件
	 * @param event
	 * @return
	 */
	public int addEvent(Event event){
		StringBuffer sql = new StringBuffer("insert into t_event(");
		List<Object> params = new ArrayList<Object>();
		if(StringUtils.isNotEmpty(event.getEventId())){
			sql.append("event_id, ");
			params.add(event.getEventId());
		}
		if(StringUtils.isNotEmpty(event.getGroupId())){
			sql.append("groupId, ");
			params.add(event.getGroupId());
		}
		if(!Objects.isNull(event.isAllDay())){
			sql.append(" is_allDay,");
			params.add(event.isAllDay());
		}
		if(StringUtils.isNotEmpty(event.getStart())){
			sql.append(" startTime,");
			params.add(event.getStart());
		}
		if(StringUtils.isNotEmpty(event.getEnd())){
			sql.append(" endTime,");
			params.add(event.getEnd());
		}
		if(StringUtils.isNotEmpty(event.getTitle())){
			sql.append(" title,");
			params.add(event.getTitle());
		}
		if(StringUtils.isNotEmpty(event.getUrl())){
			sql.append(" url,");
			params.add(event.getUrl());
		}
		if(!Objects.isNull(event.getClassNames())){
			sql.append(" classNames,");
			params.add(event.getClassNames());
		}
		if(!Objects.isNull(event.isEditable())){
			sql.append(" editable,");
			params.add(event.isEditable());
		}
		if(!Objects.isNull(event.isStartEditable())){
			sql.append(" startEditable,");
			params.add(event.isStartEditable());
		}
		if(!Objects.isNull(event.isDurationEditable())){
			sql.append(" durationEditable,");
			params.add(event.isDurationEditable());
		}
		if(!Objects.isNull(event.isResourceEditable())){
			sql.append(" resourceEditable,");
			params.add(event.isResourceEditable());
		}
		if(StringUtils.isNotEmpty(event.getRendering())){
			sql.append(" rendering,");
			params.add(event.getRendering());
		}
		if(!Objects.isNull(event.isOverlap())){
			sql.append(" overlap,");
			params.add(event.isOverlap());
		}
		if(StringUtils.isNotEmpty(event.getConstraint())){
			sql.append(" `constraint`,");
			params.add(event.getConstraint());
		}
		if(StringUtils.isNotEmpty(event.getBackgroundColor())){
			sql.append(" backgroundColor,");
			params.add(event.getBackgroundColor());
		}
		if(StringUtils.isNotEmpty(event.getBorderColor())){
			sql.append(" borderColor,");
			params.add(event.getBorderColor());
		}
		if(StringUtils.isNotEmpty(event.getTextColor())){
			sql.append(" textColor,");
			params.add(event.getTextColor());
		}
		if(StringUtils.isNotEmpty(event.getExtendedProps())){
			sql.append(" extendedProps,");
			params.add(event.getExtendedProps());
		}
		if(!Objects.isNull(event.getSource())){
			sql.append(" source,");
			Gson gson = new Gson();
			params.add(gson.toJson(event.getSource()));
		}
		if(!Objects.isNull(event.getUser())){
			sql.append(" user_id,");
			params.add(event.getUser().getUserId());
		}
		sql.replace(sql.lastIndexOf(","), sql.length(), ")");
		sql.append(" values(");
		for (int i = 0; i < params.size(); i++) {
			if(i == (params.size()-1))
				sql.append("?)");
			else
				sql.append("?,");
		}
		int status = getJdbc().doUpdate(sql.toString(), params);
		getJdbc().close();
		return status;
		
	}
	
	/**
	 * 上机安排：查询所有
	 * @return
	 */
	public List<ArrangeVO> findAllArranges(){
		String sql = "select a.event_id,a.college,a.clazz,a.date,a.address,a.teacher,a.course,a.template,e.title from arrange a, t_event e where a.event_id = e.event_id";
		List<ArrangeVO> list = new ArrayList<ArrangeVO>();
		ResultSet rs = getJdbc().doQuery(sql, new Object[]{});
		try {
			while (rs.next()) {
				ArrangeVO vo = new ArrangeVO();
				vo.setEventId(rs.getString(1));
				vo.setCollege(rs.getString(2));
				vo.setClazz(rs.getString(3));
				vo.setDate(rs.getString(4));
				vo.setAddress(rs.getString(5));
				vo.setTeacher(rs.getString(6));
				vo.setCourse(rs.getString(7));
				vo.setTemplate(rs.getString(8));
				vo.setEventTitle(rs.getString(9));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 上机安排：添加
	 * @param arrangeVO
	 * @return
	 */
	public int addArrange(ArrangeVO arrangeVO){
		StringBuilder sql = new StringBuilder("insert into arrange(");
		List<Object> params = new ArrayList<Object>();
		if(StringUtils.isNotEmpty(arrangeVO.getCollege())){
			sql.append(" event_id,");
			params.add(arrangeVO.getEventId());
		}
		if(StringUtils.isNotEmpty(arrangeVO.getCollege())){
			sql.append(" college,");
			params.add(arrangeVO.getCollege());
		}
		if(StringUtils.isNotEmpty(arrangeVO.getClazz())){
			sql.append(" clazz,");
			params.add(arrangeVO.getClazz());
		}
		if(StringUtils.isNotEmpty(arrangeVO.getDate())){
			sql.append(" date,");
			params.add(arrangeVO.getDate());
		}
		if(StringUtils.isNotEmpty(arrangeVO.getAddress())){
			sql.append(" address,");
			params.add(arrangeVO.getAddress());
		}
		if(StringUtils.isNotEmpty(arrangeVO.getTeacher())){
			sql.append(" teacher,");
			params.add(arrangeVO.getTeacher());
		}
		if(StringUtils.isNotEmpty(arrangeVO.getCourse())){
			sql.append(" course,");
			params.add(arrangeVO.getCourse());
		}
		if(StringUtils.isNotEmpty(arrangeVO.getTemplate())){
			sql.append(" template,");
			params.add(arrangeVO.getTemplate());
		}
		
		sql.replace(sql.lastIndexOf(","), sql.length(), ")");
		sql.append(" values(");
		for (int i = 0; i < params.size(); i++) {
			if(i == (params.size()-1))
				sql.append("?)");
			else
				sql.append("?,");
		}
		int status = getJdbc().doUpdate(sql.toString(), params);
		getJdbc().close();
		return status;
	}

}
