/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.controlpane;

import cn.edu.cuit.icloud.annotation.Command;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command(Cmd.LIST_CAPACITY)
public class RequestParameters {
	
	private String clusterid;    //lists capacity by the Cluster ID
	private String fetchlatest;    //recalculate capacities and fetch the latest
	private String keyword;    //List by keyword
	private String page;    //
	private String pagesize;    //
	private String podid;    //lists capacity by the Pod ID
	private String sortby;    //Sort the results. Available values: Usage
	private String type;    //lists capacity by type* CAPACITY_TYPE_MEMORY = 0* CAPACITY_TYPE_CPU = 1* CAPACITY_TYPE_STORAGE = 2* CAPACITY_TYPE_STORAGE_ALLOCATED = 3* CAPACITY_TYPE_VIRTUAL_NETWORK_PUBLIC_IP = 4* CAPACITY_TYPE_PRIVATE_IP = 5* CAPACITY_TYPE_SECONDARY_STORAGE = 6* CAPACITY_TYPE_VLAN = 7* CAPACITY_TYPE_DIRECT_ATTACHED_PUBLIC_IP = 8* CAPACITY_TYPE_LOCAL_STORAGE = 9.
	private String zoneid;    //lists capacity by the Zone ID
	public String getClusterid() {
		return clusterid;
	}
	public void setClusterid(String clusterid) {
		this.clusterid = clusterid;
	}
	public String getFetchlatest() {
		return fetchlatest;
	}
	public void setFetchlatest(String fetchlatest) {
		this.fetchlatest = fetchlatest;
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
	public String getSortby() {
		return sortby;
	}
	public void setSortby(String sortby) {
		this.sortby = sortby;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getZoneid() {
		return zoneid;
	}
	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}
	
	
}
