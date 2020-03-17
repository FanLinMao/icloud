package cn.edu.cuit.icloud.vo;


/**
 * 管理员：账户管理
 * @date: 2020年3月17日
 * @author: flfan
 */
public class AccountVO {
	
	private int userId;
	
	private String user;
	
	private String role;
	
	private String permission;
	
	private int status;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	
	
	
}
