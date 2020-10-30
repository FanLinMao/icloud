/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.template.list;

import cn.edu.cuit.icloud.annotation.Command;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command("listTemplates")
public class RequestParameters {
	/**Required: TRUE**/
	private String templatefilter;    //possible values are "featured", "self", "selfexecutable","sharedexecutable","executable", and "community". * featured : templates that have been marked as featured and public. * self : templates that have been registered or created by the calling user. * selfexecutable : same as self, but only returns templates that can be used to deploy a new VM. * sharedexecutable : templates ready to be deployed that have been granted to the calling user by another user. * executable : templates that are owned by the calling user, or public templates, that can be used to deploy a VM. * community : templates that have been marked as public but not featured. * all : all templates (only usable by admins).
	private String account;    //list resources by account. Must be used with the domainId parameter.
	private String domainid;    //list only resources belonging to the domain specified
	private String hypervisor;    //the hypervisor for which to restrict the search
	private String id;    //the template ID
	private String isrecursive;    //defaults to false, but if true, lists all resources from the parent specified by the domainId till leaves.
	private String keyword;    //List by keyword
	private String listall;    //If set to false, list only resources belonging to the command's caller; if set to true - list resources that the caller is authorized to see. Default value is false
	private String name;    //the template name
	private String page;    //
	private String pagesize;    //
	private String projectid;    //list objects by project
	private String showremoved;    //show removed templates as well
	private String tags;    //List resources by tags (key/value pairs)
	private String zoneid;    //list templates by zoneId
	/**
	 * @return the templatefilter
	 */
	public String getTemplatefilter() {
		return templatefilter;
	}
	/**
	 * @param templatefilter the templatefilter to set
	 */
	public void setTemplatefilter(String templatefilter) {
		this.templatefilter = templatefilter;
	}
	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * @return the domainid
	 */
	public String getDomainid() {
		return domainid;
	}
	/**
	 * @param domainid the domainid to set
	 */
	public void setDomainid(String domainid) {
		this.domainid = domainid;
	}
	/**
	 * @return the hypervisor
	 */
	public String getHypervisor() {
		return hypervisor;
	}
	/**
	 * @param hypervisor the hypervisor to set
	 */
	public void setHypervisor(String hypervisor) {
		this.hypervisor = hypervisor;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the isrecursive
	 */
	public String getIsrecursive() {
		return isrecursive;
	}
	/**
	 * @param isrecursive the isrecursive to set
	 */
	public void setIsrecursive(String isrecursive) {
		this.isrecursive = isrecursive;
	}
	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}
	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	/**
	 * @return the listall
	 */
	public String getListall() {
		return listall;
	}
	/**
	 * @param listall the listall to set
	 */
	public void setListall(String listall) {
		this.listall = listall;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the page
	 */
	public String getPage() {
		return page;
	}
	/**
	 * @param page the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}
	/**
	 * @return the pagesize
	 */
	public String getPagesize() {
		return pagesize;
	}
	/**
	 * @param pagesize the pagesize to set
	 */
	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}
	/**
	 * @return the projectid
	 */
	public String getProjectid() {
		return projectid;
	}
	/**
	 * @param projectid the projectid to set
	 */
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	/**
	 * @return the showremoved
	 */
	public String getShowremoved() {
		return showremoved;
	}
	/**
	 * @param showremoved the showremoved to set
	 */
	public void setShowremoved(String showremoved) {
		this.showremoved = showremoved;
	}
	/**
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}
	/**
	 * @return the zoneid
	 */
	public String getZoneid() {
		return zoneid;
	}
	/**
	 * @param zoneid the zoneid to set
	 */
	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}

}
