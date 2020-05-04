package cn.edu.cuit.icloud.constant;

/**
 * TODO
 * @author: Think
 * @since: 2020年4月28日
 */
public enum WeekEnum {
	
	Sunday("SUN","周日"),
	Monday("MON","周一"),
	Tuesday("TUE","周二"),
	Wednesday("WED","周三"),
	Thursday("THU","周四"),
	Friday("FRI","周五"),
	Saturday("SAT","周六");
	
	private String key;
	private String desp;
	
	WeekEnum(String key, String desp) {
		this.key = key;
		this.desp = desp;
	}
	
	public static String getDesp(String key) {
		WeekEnum[] values = values();
		for (WeekEnum weekEnum : values) {
			if(weekEnum.key().equals(key)) {
				return weekEnum.desp();
			}
		}
		return null;
	}
	
	
	public String key() {
		return this.key;
	}
	
	public String desp() {
		return this.desp;
	}
}
