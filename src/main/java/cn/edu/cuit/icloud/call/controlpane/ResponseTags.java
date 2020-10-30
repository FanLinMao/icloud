/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.controlpane;

import cn.edu.cuit.icloud.annotation.ResultTags;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@ResultTags(Cmd.LIST_CAPACITY)
public class ResponseTags {
	private String capacitytotal;    //the total capacity available
	private String capacityused;    //the capacity currently in use
	private String clusterid;    //the Cluster ID
	private String clustername;    //the Cluster name
	private String percentused;    //the percentage of capacity currently in use
	private String podid;    //the Pod ID
	private String podname;    //the Pod name
	private String type;    //the capacity type
	private String zoneid;    //the Zone ID
	private String zonename;    //the Zone name
	public String getCapacitytotal() {
		return capacitytotal;
	}
	public void setCapacitytotal(String capacitytotal) {
		this.capacitytotal = capacitytotal;
	}
	public String getCapacityused() {
		return capacityused;
	}
	public void setCapacityused(String capacityused) {
		this.capacityused = capacityused;
	}
	public String getClusterid() {
		return clusterid;
	}
	public void setClusterid(String clusterid) {
		this.clusterid = clusterid;
	}
	public String getClustername() {
		return clustername;
	}
	public void setClustername(String clustername) {
		this.clustername = clustername;
	}
	public String getPercentused() {
		return percentused;
	}
	public void setPercentused(String percentused) {
		this.percentused = percentused;
	}
	public String getPodid() {
		return podid;
	}
	public void setPodid(String podid) {
		this.podid = podid;
	}
	public String getPodname() {
		return podname;
	}
	public void setPodname(String podname) {
		this.podname = podname;
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
	public String getZonename() {
		return zonename;
	}
	public void setZonename(String zonename) {
		this.zonename = zonename;
	}

	
	
}
