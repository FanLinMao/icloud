/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.event.list;

import cn.edu.cuit.icloud.annotation.Command;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command(Cmd.LIST_EVENTS)
public class RequestParameters {
	
	private String account;    //list resources by account. Must be used with the domainId parameter.
	private String domainid;    //list only resources belonging to the domain specified
	private String duration;    //the duration of the event
	private String enddate;    //the end date range of the list you want to retrieve (use format "yyyy-MM-dd" or the new format "yyyy-MM-dd HH:mm:ss")
	private String entrytime;    //the time the event was entered
	private String id;    //the ID of the event
	private String isrecursive;    //defaults to false, but if true, lists all resources from the parent specified by the domainId till leaves.
	private String keyword;    //List by keyword
	private String level;    //the event level (INFO, WARN, ERROR)
	private String listall;    //If set to false, list only resources belonging to the command's caller; if set to true - list resources that the caller is authorized to see. Default value is false
	private String page;    //
	private String pagesize;    //
	private String projectid;    //list objects by project
	private String startdate;    //the start date range of the list you want to retrieve (use format "yyyy-MM-dd" or the new format "yyyy-MM-dd HH:mm:ss")
	private String type;    //the event type (see event types)
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getDomainid() {
		return domainid;
	}
	public void setDomainid(String domainid) {
		this.domainid = domainid;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getEntrytime() {
		return entrytime;
	}
	public void setEntrytime(String entrytime) {
		this.entrytime = entrytime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIsrecursive() {
		return isrecursive;
	}
	public void setIsrecursive(String isrecursive) {
		this.isrecursive = isrecursive;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getListall() {
		return listall;
	}
	public void setListall(String listall) {
		this.listall = listall;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getPagesize() {
		return pagesize;
	}
	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
