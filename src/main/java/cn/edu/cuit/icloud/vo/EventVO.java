package cn.edu.cuit.icloud.vo;

import cn.edu.cuit.icloud.pojo.User;

/**
 * 常用的事件模型
 * @date: 2020年3月25日
 * @author: flfan
 */
public class EventVO {
	//事件id
	private String eventId;
	//组id，用于指定不同事件的统一性
	private String groupId;
	//事件标题
	private String event;
	//事件开始时间
	private String startTime;
	//事件结束时间
	private String endTime;
	//点击事件跳转的url
	private String url;
	
	private User user;
	
	
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "EventVO [eventId=" + eventId + ", groupId=" + groupId + ", event=" + event + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", url=" + url + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
