package cn.edu.cuit.icloud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.cuit.icloud.common.DBCon;
import cn.edu.cuit.icloud.pojo.User;

/**
 * TODO
 * @date: 2020Äê3ÔÂ11ÈÕ
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
		String sql = "update sys_user set username=?,password=?,role=?,phone=?,email=?,wechat=?,enable=? where user_id=?";
		int status = dbc.doUpdate(sql, new Object[]{user.getUsername(),user.getPassword(),
											user.getRole(),user.getPhone(),user.getEmail(),
											user.getWechat(),user.getEnable(),user.getUserId()});
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
