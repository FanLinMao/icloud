package cn.edu.cuit.icloud.vo;

import java.util.List;

import cn.edu.cuit.icloud.pojo.Menu;
import cn.edu.cuit.icloud.pojo.User;

/**
 * TODO
 * @date: 2020Äê3ÔÂ15ÈÕ
 * @author: flfan
 */
public class UserVO{
	
	private User user;
	
	private List<Menu> menuList;
	
	private boolean fold;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public boolean isFold() {
		return fold;
	}

	public void setFold(boolean fold) {
		this.fold = fold;
	}

	

	
	
}
