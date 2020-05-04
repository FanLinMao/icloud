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
		String sql = "select u.user_id,u.username,u.password,r.role_name, r.permission, u.enable from sys_user u, role r where u.role = r.role_num";
		ResultSet rs = getJdbc().doQuery(sql, null);
		try {
			while(rs.next()){
				AccountVO accountVO = new AccountVO();
				accountVO.setUserId(rs.getInt(1));
				accountVO.setUser(rs.getString(2));
				accountVO.setPass(rs.getString(3));
				accountVO.setRole(rs.getString(4));
				accountVO.setPermission(rs.getString(5));
				accountVO.setStatus(rs.getInt(6));
				accountList.add(accountVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getJdbc().close();
		}
		return accountList;
	}
	
	public int updateAccountStatus(int userId, int status){
		String sql = "update sys_user u set u.enable= ? where user_id = ?";
		int res = getJdbc().doUpdate(sql, new Object[]{status,userId});
		getJdbc().close();
		return res;
	}
	
	public int batchDeleteUserByIds(String ids){
		String sql = "delete u from sys_user u where u.user_id in ("+ids+")";
		int res = getJdbc().doUpdate(sql, new Object[]{});
		getJdbc().close();
		return res;
	}
}
