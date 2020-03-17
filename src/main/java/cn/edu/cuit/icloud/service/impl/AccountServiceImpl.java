package cn.edu.cuit.icloud.service.impl;

import java.util.List;

import cn.edu.cuit.icloud.dao.AccountDao;
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
		if(list.size() ==0 || list.isEmpty()){
			return null;
		}
		return list;
	}

}
