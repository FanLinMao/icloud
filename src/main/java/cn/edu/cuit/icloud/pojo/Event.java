package cn.edu.cuit.icloud.pojo;

import java.util.Arrays;

/**
 * TODO
 * @date: 2020Äê3ÔÂ23ÈÕ
 * @author: flfan
 */
public class Event {
	
	private Integer id;
	private String eventId;
	private String groupId;
	private Boolean allDay;
	private String start;
	private String end;
	private String title;
	private String url;
	private String[] classNames;
	private Boolean editable;
	private Boolean startEditable;
	private Boolean durationEditable;
	private Boolean resourceEditable;
	private String rendering;
	private Boolean overlap;
	private String constraint;
	private String backgroundColor;
	private String borderColor;
	private String textColor;
	private String extendedProps;
	private Event source;
	private User user;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Boolean isAllDay() {
		return allDay;
	}
	public void setAllDay(Boolean allDay) {
		this.allDay = allDay;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String[] getClassNames() {
		return classNames;
	}
	public void setClassNames(String[] classNames) {
		this.classNames = classNames;
	}
	public Boolean isEditable() {
		return editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	public Boolean isStartEditable() {
		return startEditable;
	}
	public void setStartEditable(Boolean startEditable) {
		this.startEditable = startEditable;
	}
	public Boolean isDurationEditable() {
		return durationEditable;
	}
	public void setDurationEditable(Boolean durationEditable) {
		this.durationEditable = durationEditable;
	}
	public Boolean isResourceEditable() {
		return resourceEditable;
	}
	public void setResourceEditable(Boolean resourceEditable) {
		this.resourceEditable = resourceEditable;
	}
	public String getRendering() {
		return rendering;
	}
	public void setRendering(String rendering) {
		this.rendering = rendering;
	}
	public Boolean isOverlap() {
		return overlap;
	}
	public void setOverlap(Boolean overlap) {
		this.overlap = overlap;
	}
	public String getConstraint() {
		return constraint;
	}
	public void setConstraint(String constraint) {
		this.constraint = constraint;
	}
	public String getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public String getBorderColor() {
		return borderColor;
	}
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}
	public String getTextColor() {
		return textColor;
	}
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	public String getExtendedProps() {
		return extendedProps;
	}
	public void setExtendedProps(String extendedProps) {
		this.extendedProps = extendedProps;
	}
	public Event getSource() {
		return source;
	}
	public void setSource(Event source) {
		this.source = source;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", eventId=" + eventId + ", groupId=" + groupId + ", allDay=" + allDay + ", start="
				+ start + ", end=" + end + ", title=" + title + ", url=" + url + ", classNames="
				+ Arrays.toString(classNames) + ", editable=" + editable + ", startEditable=" + startEditable
				+ ", durationEditable=" + durationEditable + ", resourceEditable=" + resourceEditable + ", rendering="
				+ rendering + ", overlap=" + overlap + ", constraint=" + constraint + ", backgroundColor="
				+ backgroundColor + ", borderColor=" + borderColor + ", textColor=" + textColor + ", extendedProps="
				+ extendedProps + ", source=" + source + ", user=" + user + "]";
	}

	
	
	
}
