/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.ip.range.list;

import cn.edu.cuit.icloud.annotation.Command;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command(Cmd.LIST_IP_RANGE)
public class RequestParameters {
	private String id;    //optional parameter. Storaget network IP range uuid, if specicied, using it to search the range.
	private String keyword;    //List by keyword
	private String page;    //
	private String pagesize;    //
	private String podid;    //optional parameter. Pod uuid, if specicied and range uuid is absent, using it to search the range.
	private String zoneid;    //optional parameter. Zone uuid, if specicied and both pod uuid and range uuid are absent, using it to search the range.
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
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
	public String getPodid() {
		return podid;
	}
	public void setPodid(String podid) {
		this.podid = podid;
	}
	public String getZoneid() {
		return zoneid;
	}
	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}

	
}
