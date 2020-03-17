package cn.edu.cuit.icloud.service;

import java.util.List;

import cn.edu.cuit.icloud.pojo.Menu;

/**
 * TODO
 * @date: 2020Äê3ÔÂ16ÈÕ
 * @author: flfan
 */
public interface MenuService {
	
	public List<Menu> findMenuByRole(int role);
	
	public boolean IsMenuFold(int role);

}
