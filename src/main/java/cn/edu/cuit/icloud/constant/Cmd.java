package cn.edu.cuit.icloud.constant;

/**
 * 调用CloudStack的命令
 * @author: Think
 * @since: 2020年5月5日
 */
public class Cmd {
	
	/**按需添加所需命令**/
	
	/**=================模板命令==================**/
	public static final String CREATE_TEMPLATE = "createTemplate";
	public static final String LIST_TEMPLATES = "listTemplates";
	public static final String DELETE_TEMPLATE = "deleteTemplate";
	public static final String UPDATE_TEMPLATE = "updateTemplate";
	public static final String REGISTER_TEMPLATE = "registerTemplate";
	public static final String COPY_TEMPLATE = "copyTemplate";
	/**=================模板命令==================**/
	
	
	/**=================虚拟机命令==================**/
	public static final String DEPLOY_VIRTUALMACHINE = "deployVirtualMachine";
	public static final String DESTROY_VIRTUALMACHINE = "destroyVirtualMachine";
	public static final String REBOOT_VIRTUALMACHINE = "rebootVirtualMachine";
	public static final String START_VIRTUALMACHINE = "startVirtualMachine";
	public static final String STOP_VIRTUALMACHINE = "stopVirtualMachine";
	public static final String RESET_PASSWORD_VIRTUALMACHINE = "resetPasswordForVirtualMachine";
	public static final String UPDATE_VIRTUALMACHINE = "updateVirtualMachine";
	public static final String LIST_VIRTUALMACHINES = "listVirtualMachines";
	/**=================虚拟机命令==================**/
	
	
	/**=================ISO命令==================**/
	public static final String REGISTER_ISO = "registerIso";
	public static final String ATTACH_ISO = "attachIso";
	public static final String DETACH_ISO = "detachIso";
	public static final String LIST_ISOS = "listIsos";
	public static final String UPDATE_ISO = "updateIso";
	public static final String COPY_ISO = "copyIso";
	public static final String DELETE_ISO = "deleteIso";
	/**=================ISO命令==================**/
	
	/**=================事件命令==================**/
	public static final String ARCHIVE_EVENTS = "archiveEvents";
	public static final String LIST_EVENT_TYPES = "listEventTypes";
	public static final String LIST_EVENTS = "listEvents";
	public static final String DELETE_EVENTS = "deleteEvents";
	/**=================事件命令==================**/
	
	
	/**=================IP管理命令================**/
	public static final String CREATE_IP_RANGE = "createStorageNetworkIpRange";
	public static final String DELETE_IP_RANGE = "deleteStorageNetworkIpRange";
	public static final String LIST_IP_RANGE = "listStorageNetworkIpRange";
	public static final String UPDATE_IP_RANGE = "updateStorageNetworkIpRange";
	public static final String CREATE_NETWORK = "createNetwork";
	/**=================IP管理命令================**/
	
	
	
	/**=================控制板命令=================**/
	public static final String LIST_CAPACITY = "listCapacity";
	/**=================控制板命令=================**/
	
	
	
}
