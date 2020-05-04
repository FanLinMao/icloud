package cn.edu.cuit.icloud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

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
		String sql = "insert into schedule(taskId,frequence,cycle,time,action,status) values(null,?,?,?,?,?)";
		List<Object> obj = new ArrayList<Object>();
		if(null != vo) {
			obj.add(vo.getFrequence());
			obj.add(vo.getCycle());
			obj.add(vo.getTime());
			obj.add(vo.getAction());
			obj.add(vo.getStatus());
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
		String sql = "select taskId,frequence,cycle,time,action,status from schedule";
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
		String sql = "select taskId,frequence,cycle,time,action,status from schedule where taskId = ?";
		ResultSet rs = getJdbc().doQuery(sql, new Object[] {taskId});
		TaskVO task = new TaskVO();
		try {
			while(rs.next()) {
				task.setTaskId(rs.getInt(1));
				task.setFrequence(rs.getString(2));
				task.setCycle(rs.getString(3));
				task.setTime(rs.getString(4));
				task.setAction(rs.getInt(5)+"");
				task.setStatus(rs.getInt(6));
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
	
}
