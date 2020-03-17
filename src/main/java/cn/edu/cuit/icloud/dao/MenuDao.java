package cn.edu.cuit.icloud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.cuit.icloud.common.DBCon;
import cn.edu.cuit.icloud.pojo.Menu;

/**
 * TODO
 * @date: 2020Äê3ÔÂ15ÈÕ
 * @author: flfan
 */
public class MenuDao {
	
	private DBCon dbc = new DBCon();
	
	public List<Menu> findMenuByRole(int role){		
		String sql = "select m.menu_seq,m.menu_title,m.menu_icon,m.menu_href from menu m where menu_seq in (select rm.menu_id from sys_user u, role_menu rm where u.role = rm.role_id and u.role=?)";
		List<Menu> menuList = new ArrayList<>();
		ResultSet rs = dbc.doQuery(sql, new Object[]{role});
		try {
			while(rs.next()){
				Menu menu = new Menu();
				menu.setMenuSeq(Integer.valueOf(rs.getObject(1)+""));
				menu.setMenuTitle(rs.getObject(2)+"");
				menu.setMenuIcon(rs.getObject(3)+"");
				menu.setMenuHref(rs.getObject(4)+"");
				menuList.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbc.close();
		}
		return menuList;
	}
	
	public int findMenuIsFold(int role){
		int res = 0;
		String sql = "select r.is_fold from role r where r.role_num = ?";
		ResultSet rs = dbc.doQuery(sql, new Object[]{role});
		try {
			while(rs.next()){
				res = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			dbc.close();
		}
		return res;
	}
	
}
