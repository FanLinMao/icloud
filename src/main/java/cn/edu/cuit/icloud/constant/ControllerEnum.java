package cn.edu.cuit.icloud.constant;


/**
 * TODO
 * @author: Think
 * @since: 2020年5月19日
 */
public enum ControllerEnum {
	
	CAPACITY_TYPE_MEMORY ( 0,"内存占用"),
	CAPACITY_TYPE_CPU ( 1,"CPU占用"),
	CAPACITY_TYPE_STORAGE ( 2,"主存储占用"),
	CAPACITY_TYPE_STORAGE_ALLOCATED ( 3,"管理类IP"),
	CAPACITY_TYPE_VIRTUAL_NETWORK_PUBLIC_IP ( 4,""), 
	CAPACITY_TYPE_PRIVATE_IP ( 5,"私有IP占用"),
	CAPACITY_TYPE_SECONDARY_STORAGE ( 6,"二级存储占用"),
	CAPACITY_TYPE_VLAN ( 7,""),
	CAPACITY_TYPE_DIRECT_ATTACHED_PUBLIC_IP ( 8,"共享IP占用"),
	CAPACITY_TYPE_LOCAL_STORAGE ( 9,"本地存储");
			
	private int code;
	
	private String description;
	
	private ControllerEnum(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	
	
	public static String getDescription(int type) {
		ControllerEnum[] values = values();
		for (ControllerEnum controllerEnum : values) {
			if(controllerEnum.getCode() == type) {
				return controllerEnum.getDescription();
			}
		}
		return null;
	}



	public int getCode() {
		return code;
	}



	public String getDescription() {
		return description;
	}
			
}
