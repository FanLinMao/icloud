package cn.edu.cuit.icloud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.cuit.icloud.common.DBCon;
import cn.edu.cuit.icloud.vo.AccountVO;

/**
 * TODO
 * @date: 2020Äê3ÔÂ17ÈÕ
 * @author: flfan
 */
public class AccountDao extends GenericDao{
	
	
	public List<AccountVO> findAllAccount(){
		List<AccountVO> accountList = new ArrayList<>();
		String sql = "select u.user_id,u.username,r.role_name, r.permission, u.enable from sys_user u, role r where u.role = r.role_num";
		ResultSet rs = getJdbc().doQuery(sql, null);
		try {
			while(rs.next()){
				AccountVO accountVO = new AccountVO();
				accountVO.setUserId(rs.getInt(1));
				accountVO.setUser(rs.getString(2));
				accountVO.setRole(rs.getString(3));
				accountVO.setPermission(rs.getString(4));
				accountVO.setStatus(rs.getInt(5));
				accountList.add(accountVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountList;
	}
}
