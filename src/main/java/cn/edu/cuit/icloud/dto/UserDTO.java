package cn.edu.cuit.icloud.dto;


/**
 * TODO
 * @date: 2020Äê3ÔÂ11ÈÕ
 * @author: flfan
 */
public class UserDTO {
	
	private String username;
	
	private String password;
	
	private int role;
	
	public UserDTO(String username, String password, int role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public UserDTO() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
	
}
