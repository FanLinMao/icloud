package cn.edu.cuit.icloud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import cn.edu.cuit.icloud.common.DBCon;
import cn.edu.cuit.icloud.pojo.User;

/**
 * TODO
 * @date: 2020年3月11日
 * @author: flfan
 */
public abstract class GenericDao {
	
	private DBCon dbc = new DBCon();
	
	public User findUserById(int userId){
		String sql = "select user_id,username,password,role,phone,email,wechat,enable from sys_user where user_id=?";
		ResultSet rs = dbc.doQuery(sql, new Object[]{userId});
		User user = new User.Builder().builder();
		try {
			while(rs.next()){
				user.setUserId(Integer.valueOf(rs.getObject(1)+""));
				user.setUsername(rs.getObject(2)+"");
				user.setPassword(rs.getObject(3)+"");
				user.setRole(Integer.valueOf(rs.getObject(4)+""));
				user.setPhone(rs.getObject(5)+"");
				user.setEmail(rs.getObject(6)+"");
				user.setWechat(rs.getObject(7)+"");
				user.setEnable(Integer.valueOf(rs.getObject(8)+""));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbc.close();
		}
		return user;
	}
	public int deleteUserById(int userId){
		String sql = "delete sys_user where user_id=?";
		int status = dbc.doUpdate(sql, new Object[]{userId});
		dbc.close();
		return status;
	}
	public int addUser(User user){
		String sql = "insert into sys_user(username,password,role,phone,email,wechat,enable) values(?,?,?,?,?,?,?)";
		int status = dbc.doUpdate(sql, new Object[]{user.getUsername(),user.getPassword(),
											user.getRole(),user.getPhone(),user.getEmail(),
											user.getWechat(),user.getEnable()});
		dbc.close();
		return status;
	}
	public int updateUser(User user){
		StringBuffer sql = new StringBuffer("update sys_user set");
		List<Object> params = new ArrayList<Object>();
		try{
			if(Objects.isNull(user.getUserId())){
				return 0;
			}
		}catch(Exception e){
			System.out.println("【更新账户】：请设置userId");
			return 0;
		}
		if(!Objects.isNull(user.getUsername())){
			sql.append(" username=?,");
			params.add(user.getUsername());
		}
		//密码不填则默认
		if(!Objects.isNull(user.getPassword()) && !"".equals(user.getPassword())){
			sql.append(" password=?,");
			params.add(user.getPassword());
		}
		if(!Objects.isNull(user.getRole())){
			sql.append(" role=?,");
			params.add(user.getRole());
		}
		if(!Objects.isNull(user.getPhone())){
			sql.append(" phone=?,");
			params.add(user.getPhone());
		}
		if(!Objects.isNull(user.getEmail())){
			sql.append(" email=?,");
			params.add(user.getEmail());
		}
		if(!Objects.isNull(user.getWechat())){
			sql.append(" wechat=?,");
			params.add(user.getWechat());
		}
		if(!Objects.isNull(user.getEnable())){
			sql.append(" enable=?,");
			params.add(user.getEnable());
		}
		sql.replace(sql.lastIndexOf(","), sql.length(), "");
		sql.append(" where user_id=?");
		params.add(user.getUserId());
		int status = dbc.doUpdate(sql.toString(), params);
		dbc.close();
		return status;
	}
	public User login(String username, String password, int role){
		String sql = "select user_id,username,password,role,phone,email,wechat,enable from sys_user where username=? and password=? and role=?";
		ResultSet rs = dbc.doQuery(sql, new Object[]{username,password,role});
		User user = new User.Builder().builder();
		try {
			while(rs.next()){
				user.setUserId(Integer.valueOf(rs.getObject(1)+""));
				user.setUsername(rs.getObject(2)+"");
				user.setPassword(rs.getObject(3)+"");
				user.setRole(Integer.valueOf(rs.getObject(4)+""));
				user.setPhone(rs.getObject(5)+"");
				user.setEmail(rs.getObject(6)+"");
				user.setWechat(rs.getObject(7)+"");
				user.setEnable(Integer.valueOf(rs.getObject(8)+""));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbc.close();
		}
		return user;
	}
	
	public DBCon getJdbc(){
		return this.dbc;
	}
	
}
