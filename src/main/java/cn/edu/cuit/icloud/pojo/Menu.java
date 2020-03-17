package cn.edu.cuit.icloud.pojo;


/**
 * TODO
 * @date: 2020Äê3ÔÂ15ÈÕ
 * @author: flfan
 */
public class Menu {
	
	private Integer menuId;
	
	private String menuTitle;
	
	private String menuIcon;
	
	private String menuHref;
	
	private Integer menuSeq;
	
	public Menu(){
		
	}
	
	public Menu(String menuTitle, String menuIcon, String menuHref, Integer menuSeq) {
		this.menuTitle = menuTitle;
		this.menuIcon = menuIcon;
		this.menuHref = menuHref;
		this.menuSeq = menuSeq;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuTitle() {
		return menuTitle;
	}

	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public String getMenuHref() {
		return menuHref;
	}

	public void setMenuHref(String menuHref) {
		this.menuHref = menuHref;
	}

	public Integer getMenuSeq() {
		return menuSeq;
	}

	public void setMenuSeq(Integer menuSeq) {
		this.menuSeq = menuSeq;
	}
	
	
	
}
