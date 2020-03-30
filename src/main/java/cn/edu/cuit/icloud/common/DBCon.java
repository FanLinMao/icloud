package cn.edu.cuit.icloud.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 数据库连接类
 * @date: 2020年3月8日
 * @author: Flemming
 */
public class DBCon {
	private Logger logger = Logger.getLogger(DBCon.class);
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private static Properties ps = null;
	static{
		ps = new Properties();
		//获取db文件
		try {
			ps.load(DBCon.class.getResourceAsStream("/db.properties"));
		} catch (FileNotFoundException e) {
			//db.properties文件找不到
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//加载驱动
		try {
			Class.forName(ps.getProperty("jdbc.driver"));
		} catch (ClassNotFoundException e) {
			//加载数据库驱动失败
			e.printStackTrace();
		}
	}
	private Connection getConnection(){
		try {
			conn =  DriverManager.getConnection(ps.getProperty("jdbc.url"), ps.getProperty("jdbc.user"), ps.getProperty("jdbc.password"));
		} catch (SQLException e) {
			//获取数据库连接失败异常
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 查询
	 * @param sql
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("null")
	public ResultSet doQuery(String sql, Object[] obj){
		ResultSet result = null;
		conn = this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			if(null != obj){
				for (int i = 0; i < obj.length; i++) {
					pstmt.setObject(i+1, obj[i]);
				}
			}
			result = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("sql执行异常："+e.getMessage());
			return null;
		}
		logger.info("查询操作："+sql);
		return result;
	}
	/**
	 * 更新操作
	 * @param sql  sql语句
	 * @param obj  预编译参数
	 * @return
	 */
	@SuppressWarnings("null")
	public int doUpdate(String sql, Object[] obj){
		int result = 0;
		conn = this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			if(null != obj){
				for (int i = 0; i < obj.length; i++) {
					pstmt.setObject(i+1, obj[i]);
				}
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("sql执行异常："+e.getMessage());
			return 0;
		}
		logger.info("更新操作："+sql);
		return result;
	}
	
	@SuppressWarnings("null")
	public int doUpdate(String sql, List<Object> list){
		int result = 0;
		conn = this.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			if(null != list && !list.isEmpty() && list.size() !=0){
				for (int i = 0; i < list.size(); i++) {
					pstmt.setObject(i+1, list.get(i));
				}
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("sql执行异常："+e.getMessage());
			return 0;
		}
		logger.info("更新操作："+sql);
		return result;
	}
	
	/**
	 * 关闭资源
	 */
	public void close(){
		try {
			if(null != pstmt){
				pstmt.close();
			}
			if(null != conn){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
