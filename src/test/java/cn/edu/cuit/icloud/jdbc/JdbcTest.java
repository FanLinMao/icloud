package cn.edu.cuit.icloud.jdbc;

import java.sql.ResultSet;
import org.junit.Test;
import cn.edu.cuit.icloud.common.DBCon;

/**
 * TODO
 * @date: 2020年3月8日
 * @author: Flemming
 */
public class JdbcTest {
	
	@Test
	public void testJdbcQuery() throws Exception{
		String sql = "select * from users;";
		DBCon db = new DBCon();
		ResultSet res = db.doQuery(sql, null);
		while(res.next()){
			System.out.println("username:"+res.getString(2)+",password:"+res.getString(3));
		}
		db.close();
		
	}
	
	@Test
	public void testJdbcUpdate(){
		String sql = "update users set username=? where id=?;";
		DBCon db = new DBCon();
		int status = db.doUpdate(sql, new Object[]{"FanLinmao",1});
		if(status != 0){
			System.out.println("修改用户名成功！");
		}
		db.close();
	}
	
}
