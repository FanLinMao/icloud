package cn.edu.cuit.icloud.constant;


/**
 * 角色信息
 * @date: 2020年3月11日
 * @author: flfan
 */
public enum RoleEnum {
	
	ADMIN(1,"管理员"),
	TEACHER(2,"教师"),
	STUDENT(3,"学生");
	
	
	private int code;
	private String role;
	
	RoleEnum(int code, String role){
		this.code = code;
		this.role = role;
	}

	public int getCode() {
		return code;
	}

	public String getRole() {
		return role;
	}
	
}
