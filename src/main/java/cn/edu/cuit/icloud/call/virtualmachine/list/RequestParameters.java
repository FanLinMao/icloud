/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.virtualmachine.list;

import cn.edu.cuit.icloud.annotation.Command;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command(Cmd.LIST_VIRTUALMACHINES)
public class RequestParameters {
	private String account;    //list resources by account. Must be used with the domainId parameter.
	private String affinitygroupid;    //list vms by affinity group
	private String details;    //comma separated list of host details requested, value can be a list of [all, group, nics, stats, secgrp, tmpl, servoff, iso, volume, min, affgrp]. If no parameter is passed in, the details will be defaulted to all
	private String domainid;    //list only resources belonging to the domain specified
	private String forvirtualnetwork;    //list by network type; true if need to list vms using Virtual Network, false otherwise
	private String groupid;    //the group ID
	private String hostid;    //the host ID
	private String hypervisor;    //the target hypervisor for the template
	private String id;    //the ID of the virtual machine
	private String isoid;    //list vms by iso
	private String isrecursive;    //defaults to false, but if true, lists all resources from the parent specified by the domainId till leaves.
	private String keyword;    //List by keyword
	private String listall;    //If set to false, list only resources belonging to the command's caller; if set to true - list resources that the caller is authorized to see. Default value is false
	private String name;    //name of the virtual machine
	private String networkid;    //list by network id
	private String page;    //
	private String pagesize;    //
	private String podid;    //the pod ID
	private String projectid;    //list objects by project
	private String state;    //state of the virtual machine
	private String storageid;    //the storage ID where vm's volumes belong to
	private String tags;    //List resources by tags (key/value pairs)
	private String templateid;    //list vms by template
	private String vpcid;    //list vms by vpc
	private String zoneid;    //the availability zone ID
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAffinitygroupid() {
		return affinitygroupid;
	}
	public void setAffinitygroupid(String affinitygroupid) {
		this.affinitygroupid = affinitygroupid;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getDomainid() {
		return domainid;
	}
	public void setDomainid(String domainid) {
		this.domainid = domainid;
	}
	public String getForvirtualnetwork() {
		return forvirtualnetwork;
	}
	public void setForvirtualnetwork(String forvirtualnetwork) {
		this.forvirtualnetwork = forvirtualnetwork;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public String getHostid() {
		return hostid;
	}
	public void setHostid(String hostid) {
		this.hostid = hostid;
	}
	public String getHypervisor() {
		return hypervisor;
	}
	public void setHypervisor(String hypervisor) {
		this.hypervisor = hypervisor;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIsoid() {
		return isoid;
	}
	public void setIsoid(String isoid) {
		this.isoid = isoid;
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
	public String getListall() {
		return listall;
	}
	public void setListall(String listall) {
		this.listall = listall;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNetworkid() {
		return networkid;
	}
	public void setNetworkid(String networkid) {
		this.networkid = networkid;
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
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStorageid() {
		return storageid;
	}
	public void setStorageid(String storageid) {
		this.storageid = storageid;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getTemplateid() {
		return templateid;
	}
	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}
	public String getVpcid() {
		return vpcid;
	}
	public void setVpcid(String vpcid) {
		this.vpcid = vpcid;
	}
	public String getZoneid() {
		return zoneid;
	}
	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}

}
