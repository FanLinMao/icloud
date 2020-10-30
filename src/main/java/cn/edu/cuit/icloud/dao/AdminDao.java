package cn.edu.cuit.icloud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import cn.edu.cuit.icloud.vo.IsoVO;
import cn.edu.cuit.icloud.vo.RoomVO;
import cn.edu.cuit.icloud.vo.SoftVO;
import cn.edu.cuit.icloud.vo.TaskVO;

/**
 * TODO
 * @date: 2020年3月11日
 * @author: flfan
 */
public class AdminDao extends GenericDao{
	
	/**
	 * 添加任务
	 * @param vo
	 * @return
	 */
	public int addTask(TaskVO vo) {
		String sql = "insert into schedule(taskId,frequence,cycle,time,action,status,job_name,job_groupname,trigger_name,trigger_groupname) values(null,?,?,?,?,?,?,?,?,?)";
		List<Object> obj = new ArrayList<Object>();
		if(null != vo) {
			obj.add(vo.getFrequence());
			obj.add(vo.getCycle());
			obj.add(vo.getTime());
			obj.add(vo.getAction());
			obj.add(vo.getStatus());
			obj.add(vo.getJobName());
			obj.add(vo.getJobGroupName());
			obj.add(vo.getTriggerName());
			obj.add(vo.getTriggerGroupName());
		}
		int res = getJdbc().doUpdate(sql, obj);
		getJdbc().close();
		return res;
	}
	/**
	 * 批量删除任务
	 * @param taskIds
	 * @return
	 */
	public int deleteTasks(String taskIds) {
		String sql = "delete from schedule where taskId in("+taskIds+")";
		int res = getJdbc().doUpdate(sql, new Object[]{});
		getJdbc().close();
		return res;
		
	}
	/**
	 * 查找所有任务
	 * @return
	 */
	public List<TaskVO> findAllTasks() {
		String sql = "select taskId,frequence,cycle,time,action,status,job_name,job_groupname,trigger_name,trigger_groupname from schedule";
		ResultSet rs = getJdbc().doQuery(sql, new Object[] {});
		List<TaskVO> tasks = new ArrayList<TaskVO>();
		TaskVO task = null;
		try {
			while(rs.next()) {
				task = new TaskVO();
				task.setTaskId(rs.getInt(1));
				task.setFrequence(rs.getString(2));
				task.setCycle(rs.getString(3));
				task.setTime(rs.getString(4));
				task.setAction(rs.getInt(5)+"");
				task.setStatus(rs.getInt(6));
				task.setJobName(rs.getString(7));
				task.setJobGroupName(rs.getString(8));
				task.setTriggerName(rs.getString(9));
				task.setTriggerGroupName(rs.getString(10));
				tasks.add(task);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getJdbc().close();
		}
		return tasks;
	}
	
	public TaskVO findTaskByTaskId(int taskId) {
		String sql = "select taskId,frequence,cycle,time,action,status,job_name,job_groupname,trigger_name,trigger_groupname from schedule where taskId = ?";
		ResultSet rs = getJdbc().doQuery(sql, new Object[] {taskId});
		TaskVO task = null;
		try {
			while(rs.next()) {
				task = new TaskVO();
				task.setTaskId(rs.getInt(1));
				task.setFrequence(rs.getString(2));
				task.setCycle(rs.getString(3));
				task.setTime(rs.getString(4));
				task.setAction(rs.getInt(5)+"");
				task.setStatus(rs.getInt(6));
				task.setJobName(rs.getString(7));
				task.setJobGroupName(rs.getString(8));
				task.setTriggerName(rs.getString(9));
				task.setTriggerGroupName(rs.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getJdbc().close();
		}
		return task;
	}
	
	public int updateTask(TaskVO vo) {
		StringBuilder sql = new StringBuilder("update schedule set ");
		List<Object> params = new ArrayList<Object>();
		if(StringUtils.isNotEmpty(vo.getFrequence())) {
			sql.append("frequence = ?,");
			params.add(vo.getFrequence());
		}
		if(StringUtils.isNotEmpty(vo.getCycle())) {
			sql.append("cycle = ?,");
			params.add(vo.getCycle());
		}
		if(StringUtils.isNotEmpty(vo.getTime())) {
			sql.append("time = ?,");
			params.add(vo.getTime());
		}
		if(StringUtils.isNotEmpty(vo.getAction())) {
			sql.append("action = ?,");
			params.add(vo.getAction());
		}
		if(!Objects.isNull(vo.getStatus())) {
			sql.append("status = ?,");
			params.add(vo.getStatus());
		}
		sql.replace(sql.lastIndexOf(","), sql.length(), " ");
		sql.append("where ");
		if(!Objects.isNull(vo.getTaskId())) {
			sql.append("taskId = ?");
			params.add(vo.getTaskId());
		}
		int res = getJdbc().doUpdate(sql.toString(), params);
		getJdbc().close();
		return res;
	}
	public int updateStatus(int taskId,int status) {
		String sql = "update schedule set status = ? where taskId = ?";
		int res = getJdbc().doUpdate(sql, new Object[] {status,taskId});
		getJdbc().close();
		return res;
	}
	
	public List<TaskVO> findTasksByIds(String taskIds) {
		String sql = "select taskId,frequence,cycle,time,action,status,job_name,job_groupname,trigger_name,trigger_groupname from schedule where taskId in("+ taskIds +")";
		ResultSet rs = getJdbc().doQuery(sql, null);
		List<TaskVO> list = new ArrayList<TaskVO>();
		TaskVO task = new TaskVO();
		try {
			while(rs.next()) {
				task.setTaskId(rs.getInt(1));
				task.setFrequence(rs.getString(2));
				task.setCycle(rs.getString(3));
				task.setTime(rs.getString(4));
				task.setAction(rs.getInt(5)+"");
				task.setStatus(rs.getInt(6));
				task.setJobName(rs.getString(7));
				task.setJobGroupName(rs.getString(8));
				task.setTriggerName(rs.getString(9));
				task.setTriggerGroupName(rs.getString(10));
				list.add(task);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getJdbc().close();
		}
		return list;
	}
	
	public IsoVO findIsoById(int isoId) {
		String sql = "select id,iso_name,ostype,ossize,creator,create_date,src from iso where id=?";
		ResultSet rs = getJdbc().doQuery(sql, new Object[] {isoId});
		IsoVO vo = null;
		try {
			while(rs.next()) {
				vo = new IsoVO();
				vo.setId(rs.getInt(1));
				vo.setIsoName(rs.getString(2));
				vo.setOsType(rs.getString(3));
				vo.setOsSize(rs.getLong(4));
				vo.setCreator(rs.getString(5));
				vo.setCreateDate(rs.getString(6));
				vo.setSrc(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getJdbc().close();
		}
		return vo;
	}
	
	public List<IsoVO> listIsos() {
		String sql = "select id,iso_name,ostype,ossize,creator,create_date,src from iso";
		ResultSet rs = getJdbc().doQuery(sql, null);
		ArrayList<IsoVO> list = new ArrayList<IsoVO>();
		IsoVO vo = null;
		try {
			while(rs.next()) {
				vo = new IsoVO();
				vo.setId(rs.getInt(1));
				vo.setIsoName(rs.getString(2));
				vo.setOsType(rs.getString(3));
				vo.setOsSize(rs.getLong(4));
				vo.setCreator(rs.getString(5));
				vo.setCreateDate(rs.getString(6));
				vo.setSrc(rs.getString(7));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getJdbc().close();
		}
		return list;
	}

	
	public int updateIso(IsoVO vo) {
		int res = 0;
		if(!Objects.isNull(vo)) {
			String sql = "update iso set iso_name = ?,ostype = ?,creator = ?,create_date = ? where id = ?";
			res = getJdbc().doUpdate(sql, new Object[] {vo.getIsoName(),vo.getOsType()
													,vo.getCreator()
													,vo.getCreateDate()
													,vo.getId()});
			getJdbc().close();
		}
		return res;
	}

	
	public int deleteIsoById(Integer isoId) {
		if(Objects.isNull(isoId)) {
			return 0;
		}
		String sql = "delete from iso where id = ?";
		int res = getJdbc().doUpdate(sql, new Object[] {isoId});
		getJdbc().close();
		return res;
	}
	
	public List<String> findResources(){
		String sql = "select src from iso;";
		ResultSet rs = getJdbc().doQuery(sql, null);
		ArrayList<String> list = new ArrayList<String>();
		try {
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getJdbc().close();
		}
		return list;
	}
	
	public SoftVO findSoftById(int softId){
		String sql = "select soft_id,soft_name,size,uploader,upload_date,remark,src from soft where soft_id=?";
		ResultSet rs = getJdbc().doQuery(sql, new Object[] {softId});
		SoftVO vo = null;
		try {
			while(rs.next()) {
				vo = new SoftVO();
				vo.setSoftId(rs.getInt(1));
				vo.setSoftName(rs.getString(2));
				vo.setSize(rs.getLong(3));
				vo.setUploader(rs.getString(4));
				vo.setUploadDate(rs.getString(5));
				vo.setMark(rs.getString(6));
				vo.setResource(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getJdbc().close();
		}
		return vo;
	}
	
	public List<SoftVO> findSofts(){
		String sql = "select soft_id,soft_name,size,uploader,upload_date,remark,src from soft";
		ResultSet rs = getJdbc().doQuery(sql, null);
		SoftVO vo = null;
		ArrayList<SoftVO> list = new ArrayList<SoftVO>();
		try {
			while(rs.next()) {
				vo = new SoftVO();
				vo.setSoftId(rs.getInt(1));
				vo.setSoftName(rs.getString(2));
				vo.setSize(rs.getLong(3));
				vo.setUploader(rs.getString(4));
				vo.setUploadDate(rs.getString(5));
				vo.setMark(rs.getString(6));
				vo.setResource(rs.getString(7));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getJdbc().close();
		}
		return list;
	}
	
	public int updateSoft(SoftVO vo) {
		int res = 0;
		if(!Objects.isNull(vo)) {
			String sql = "update soft set soft_name = ?,size = ?,uploader = ?,upload_date = ?,remark = ?, src = ? where soft_id = ?";
			res = getJdbc().doUpdate(sql, new Object[] {vo.getSoftName(),vo.getSize()
													,vo.getUploader()
													,vo.getUploadDate()
													,vo.getMark()
													,vo.getResource()
													,vo.getSoftId()});
			getJdbc().close();
		}
		return res;
	}

	
	public int deleteSoftById(Integer softId) {
		if(Objects.isNull(softId)) {
			return 0;
		}
		String sql = "delete from soft where soft_id = ?";
		int res = getJdbc().doUpdate(sql, new Object[] {softId});
		getJdbc().close();
		return res;
	}
	
	public List<RoomVO> findRooms(){
		String sql = "select id,room,equipment,course,user_count from room";
		ResultSet rs = getJdbc().doQuery(sql, null);
		RoomVO vo = null;
		ArrayList<RoomVO> list = new ArrayList<RoomVO>();
		try {
			while(rs.next()) {
				vo = new RoomVO();
				vo.setId(rs.getInt(1));
				vo.setRoom(rs.getString(2));
				vo.setEquipment(rs.getString(3));
				vo.setCourse(rs.getString(4));
				vo.setUserCount(rs.getInt(5));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getJdbc().close();
		}
		return list;
	}
	
	public int updateRoom(RoomVO vo) {
		int res = 0;
		if(!Objects.isNull(vo)) {
			String sql = "update room set room = ?,equipment = ?,course = ?,user_count = ? where id = ?";
			res = getJdbc().doUpdate(sql, new Object[] {vo.getRoom(),
															vo.getEquipment(),
															vo.getCourse(),
															vo.getUserCount(),
															vo.getId()});
			getJdbc().close();
		}
		return res;
	}

	
	public int deleteRoomsByIds(String ids) {
		if(Objects.isNull(ids)) {
			return 0;
		}
		String sql = "delete from room where id in("+ids+")";
		int res = getJdbc().doUpdate(sql, new Object[] {});
		getJdbc().close();
		return res;
	}
	
	public int insertRoom(RoomVO vo) {
		if(Objects.isNull(vo)) {
			return 0;
		}
		if(StringUtils.isEmpty(vo.getRoom()) && StringUtils.isEmpty(vo.getEquipment()) 
				&& StringUtils.isEmpty(vo.getCourse())
				&& Objects.isNull(vo.getUserCount()) ) {
			return 0;
		}
		StringBuilder sb = new StringBuilder("insert into room(id,room,equipment,course,user_count) ");
		ArrayList<Object> params = new ArrayList<Object>();
		sb.append("values(0");
		if(StringUtils.isNotEmpty(vo.getRoom())) {
			sb.append(",?");
			params.add(vo.getRoom());
			
		}
		if(StringUtils.isNotEmpty(vo.getEquipment())) {
			sb.append(",?");
			params.add(vo.getEquipment());
			
		}
		if(StringUtils.isNotEmpty(vo.getCourse())) {
			sb.append(",?");
			params.add(vo.getCourse());
			
		}
		if(!Objects.isNull(vo.getUserCount())) {
			sb.append(",?");
			params.add(vo.getUserCount());
			
		}
		sb.append(")");
		
		int res = getJdbc().doUpdate(sb.toString(), params);
		getJdbc().close();
		return res;
	}
}
