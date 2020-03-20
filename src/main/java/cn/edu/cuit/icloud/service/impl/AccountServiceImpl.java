package cn.edu.cuit.icloud.service.impl;

import java.util.List;

import cn.edu.cuit.icloud.dao.AccountDao;
import cn.edu.cuit.icloud.pojo.User;
import cn.edu.cuit.icloud.service.AccountService;
import cn.edu.cuit.icloud.vo.AccountVO;

/**
 * TODO
 * @date: 2020Äê3ÔÂ17ÈÕ
 * @author: flfan
 */
public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao = new AccountDao();
	
	@Override
	public List<AccountVO> getAllAccount() {
		List<AccountVO> list = accountDao.findAllAccount();
		return list;
	}

	@Override
	public boolean updateAccountIsEnableById(int userId, int status) {
		boolean isSuccess = false;
		int res = accountDao.updateAccountStatus(userId, status);
		if(res>0){
			isSuccess = true;
		}
		return isSuccess;
	}

	@Override
	public boolean registerUser(User user) {
		boolean isSuccess = false;
		int res = accountDao.addUser(user);
		if(res > 0){
			isSuccess = true;
		}
		return isSuccess;
	}

	@Override
	public boolean batchDelUser(String ids) {
		boolean isSuccess = false;
		int res = accountDao.batchDeleteUserByIds(ids);
		if(res>0){
			isSuccess = true;
		}
		return isSuccess;
	}

	@Override
	public boolean updateAccount(User user) {
		boolean success = false;
		int res = accountDao.updateUser(user);
		if(res>0){
			success = true;
		}
		return success;
	}

}
