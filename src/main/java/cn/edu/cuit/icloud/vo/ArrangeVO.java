package cn.edu.cuit.icloud.vo;


/**
 * TODO
 * @date: 2020Äê3ÔÂ26ÈÕ
 * @author: flfan
 */
public class ArrangeVO{
	
	private String eventId;
	
	private String college;
	
	private String clazz;
	
	private String date;
	
	private String address;
	
	private String teacher;
	
	private String course;
	
	private String template;
	
	private String eventTitle;
	
	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	
	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	@Override
	public String toString() {
		return "ArrangeVO [eventId=" + eventId + ", college=" + college + ", clazz=" + clazz + ", date=" + date
				+ ", address=" + address + ", teacher=" + teacher + ", course=" + course + ", template=" + template
				+ ", eventTitle=" + eventTitle + "]";
	}

	

	
	
	
}
