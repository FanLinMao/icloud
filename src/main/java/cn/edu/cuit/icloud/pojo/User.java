package cn.edu.cuit.icloud.pojo;

/**
 * TODO
 * @date: 2020年2月10日
 * @author: Flemming
 */
public class User {
	
	private Integer userId;
	
	private String username;
	
	private String password;
	
	private Integer role;
	
	private String phone;
	
	private String email;
	
	private String wechat;
	
	private Integer enable;
	
	private User(){
		
	}
	
	private User(Integer userId, String username, String password, 
			Integer role, String phone, String email, String wechat,
			Integer enable) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.phone = phone;
		this.email = email;
		this.wechat = wechat;
		this.enable = enable;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}


	public static class Builder{
		
		private Integer userId;
		
		private String username;
		
		private String password;
		
		private Integer role;
		
		private String phone;
		
		private String email;
		
		private String wechat;
		
		private Integer enable = 1;//默认可用

		public Builder setUserId(Integer userId) {
			this.userId = userId;
			return this;
		}

		public Builder setUsername(String username) {
			this.username = username;
			return this;
		}

		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}

		public Builder setRole(Integer role) {
			this.role = role;
			return this;
		}

		public Builder setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder setWechat(String wechat) {
			this.wechat = wechat;
			return this;
		}

		public Builder setEnable(Integer enable) {
			this.enable = enable;
			return this;
		}

		public User builder(){
			return new User(userId, username, password, role, phone, email, wechat,
					enable);
		}
		
		
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", phone=" + phone + ", email=" + email + ", wechat=" + wechat + ", enable=" + enable + "]";
	}
	
	
	
}
