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
public enum FrequenceEnum {
	
	WEEKLY("weekly","每周"),
	DAILY("daily","每天");
	
	private String status;
	private String desp;
	FrequenceEnum(String status, String desp){
		this.desp = desp;
		this.status = status;
	}
	
	public static String getDesp(String status) {
		FrequenceEnum[] values = values();
		for (FrequenceEnum actionEnum : values) {
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
