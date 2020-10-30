package cn.edu.cuit.icloud.vo;

/**
 * TODO
 * @author: Think
 * @since: 2020Äê5ÔÂ11ÈÕ
 */
public class VirtualMachineVO {
	
	private Integer vmId;
	private String vmName;
	private String status;
	private String osType;
	private String storage;
	private String cpu;
	private String disk;
	private String createDate;
	public Integer getVmId() {
		return vmId;
	}
	public void setVmId(Integer vmId) {
		this.vmId = vmId;
	}
	public String getVmName() {
		return vmName;
	}
	public void setVmName(String vmName) {
		this.vmName = vmName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOsType() {
		return osType;
	}
	public void setOsType(String osType) {
		this.osType = osType;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getDisk() {
		return disk;
	}
	public void setDisk(String disk) {
		this.disk = disk;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	
}
