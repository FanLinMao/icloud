package cn.edu.cuit.icloud.vo;

/**
 * TODO
 * @author: Think
 * @since: 2020年4月26日
 */
public class TaskVO {
	
	/**
	 * 任务ID
	 */
	private Integer taskId;
	/**
	 * 频率
	 */
	private String frequence;
	/**
	 * 周期
	 */
	private String cycle;
	/**
	 * 时间
	 */
	private String time;
	/**
	 * 行为
	 */
	private String action;
	/**
	 * 状态
	 */
	private Integer status;
	
	/**
	 * @return the taskId
	 */
	public int getTaskId() {
		return taskId;
	}
	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	/**
	 * @return the frequence
	 */
	public String getFrequence() {
		return frequence;
	}
	/**
	 * @param frequence the frequence to set
	 */
	public void setFrequence(String frequence) {
		this.frequence = frequence;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * @return the cycle
	 */
	public String getCycle() {
		return cycle;
	}
	/**
	 * @param cycle the cycle to set
	 */
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	
	
	
}
