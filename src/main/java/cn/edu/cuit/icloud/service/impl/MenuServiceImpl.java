package cn.edu.cuit.icloud.service.impl;

import java.util.List;

import cn.edu.cuit.icloud.dao.MenuDao;
import cn.edu.cuit.icloud.pojo.Menu;
import cn.edu.cuit.icloud.service.MenuService;

/**
 * TODO
 * @date: 2020Äê3ÔÂ16ÈÕ
 * @author: flfan
 */
public class MenuServiceImpl implements MenuService {

	private MenuDao menuDao = new MenuDao();
	
	@Override
	public List<Menu> findMenuByRole(int role) {
		
		return menuDao.findMenuByRole(role);
	}

	@Override
	public boolean IsMenuFold(int role) {
		boolean flag = true;
		int isFold = menuDao.findMenuIsFold(role);
		if(isFold == 0){
			flag = false;
		}
		
		return flag;
	}

}
