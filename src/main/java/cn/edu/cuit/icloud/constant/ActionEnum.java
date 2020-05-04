/**
 * TODO
 * @author: Think
 * @since: 2020年4月28日
 */
package cn.edu.cuit.icloud.constant;

/**
 * TODO
 * @author: Think
 * @since: 2020年4月28日
 */
public enum ActionEnum {
	
	SHUTDOWN("0","关机"),
	BOOTUP("1","开机");
	
	private String status;
	private String desp;
	ActionEnum(String status, String desp){
		this.desp = desp;
		this.status = status;
	}
	
	public static String getDesp(String status) {
		ActionEnum[] values = values();
		for (ActionEnum actionEnum : values) {
			if(actionEnum.status().equals(status)) {
				return actionEnum.desp();
			}
		}
		return null;
	}
	
	public String status() {
		return this.status;
	}
	public String desp() {
		return this.desp;
	}
}
