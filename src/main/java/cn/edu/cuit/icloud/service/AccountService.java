package cn.edu.cuit.icloud.service;

import java.util.List;

import cn.edu.cuit.icloud.pojo.User;
import cn.edu.cuit.icloud.vo.AccountVO;

/**
 * TODO
 * @date: 2020Äê3ÔÂ17ÈÕ
 * @author: flfan
 */
public interface AccountService {
	
	public List<AccountVO> getAllAccount();
	
	public boolean updateAccountIsEnableById(int userId, int status);
	
	public boolean registerUser(User user);
	
	public boolean batchDelUser(String ids);
	
	public boolean updateAccount(User user);
}
