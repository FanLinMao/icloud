/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.iso.list;

import cn.edu.cuit.icloud.annotation.Command;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command(Cmd.LIST_ISOS)
public class RequestParameters {
	private String account;    //list resources by account. Must be used with the domainId parameter.
	private String bootable;    //true if the ISO is bootable, false otherwise
	private String domainid;    //list only resources belonging to the domain specified
	private String hypervisor;    //the hypervisor for which to restrict the search
	private String id;    //list ISO by id
	private String isofilter;    //possible values are "featured", "self", "selfexecutable","sharedexecutable","executable", and "community". * featured : templates that have been marked as featured and public. * self : templates that have been registered or created by the calling user. * selfexecutable : same as self, but only returns templates that can be used to deploy a new VM. * sharedexecutable : templates ready to be deployed that have been granted to the calling user by another user. * executable : templates that are owned by the calling user, or public templates, that can be used to deploy a VM. * community : templates that have been marked as public but not featured. * all : all templates (only usable by admins).
	private String ispublic;    //true if the ISO is publicly available to all users, false otherwise.
	private String isready;    //true if this ISO is ready to be deployed
	private String isrecursive;    //defaults to false, but if true, lists all resources from the parent specified by the domainId till leaves.
	private String keyword;    //List by keyword
	private String listall;    //If set to false, list only resources belonging to the command's caller; if set to true - list resources that the caller is authorized to see. Default value is false
	private String name;    //list all isos by name
	private String page;    //
	private String pagesize;    //
	private String projectid;    //list objects by project
	private String showremoved;    //show removed ISOs as well
	private String tags;    //List resources by tags (key/value pairs)
	private String zoneid;    //the ID of the zone
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getBootable() {
		return bootable;
	}
	public void setBootable(String bootable) {
		this.bootable = bootable;
	}
	public String getDomainid() {
		return domainid;
	}
	public void setDomainid(String domainid) {
		this.domainid = domainid;
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
	public String getIsofilter() {
		return isofilter;
	}
	public void setIsofilter(String isofilter) {
		this.isofilter = isofilter;
	}
	public String getIspublic() {
		return ispublic;
	}
	public void setIspublic(String ispublic) {
		this.ispublic = ispublic;
	}
	public String getIsready() {
		return isready;
	}
	public void setIsready(String isready) {
		this.isready = isready;
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
	public String getShowremoved() {
		return showremoved;
	}
	public void setShowremoved(String showremoved) {
		this.showremoved = showremoved;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getZoneid() {
		return zoneid;
	}
	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}

}
