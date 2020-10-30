/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.iso.register;

import cn.edu.cuit.icloud.annotation.ResultTags;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@ResultTags(Cmd.REGISTER_ISO)
public class ResponseTags {
	private String id;    //the template ID
	private String account;    //the account name to which the template belongs
	private String accountid;    //the account id to which the template belongs
	private String bootable;    //true if the ISO is bootable, false otherwise
	private String checksum;    //checksum of the template
	private String created;    //the date this template was created
	private String crossZones;    //true if the template is managed across all Zones, false otherwise
	private String details;    //additional key/value details tied with template
	private String displaytext;    //the template display text
	private String domain;    //the name of the domain to which the template belongs
	private String domainid;    //the ID of the domain to which the template belongs
	private String format;    //the format of the template.
	private String hostid;    //the ID of the secondary storage host for the template
	private String hostname;    //the name of the secondary storage host for the template
	private String hypervisor;    //the hypervisor on which the template runs
	private String isdynamicallyscalable;    //true if template contains XS/VMWare tools inorder to support dynamic scaling of VM cpu/memory
	private String isextractable;    //true if the template is extractable, false otherwise
	private String isfeatured;    //true if this template is a featured template, false otherwise
	private String ispublic;    //true if this template is a public template, false otherwise
	private String isready;    //true if the template is ready to be deployed from, false otherwise.
	private String name;    //the template name
	private String ostypeid;    //the ID of the OS type for this template.
	private String ostypename;    //the name of the OS type for this template.
	private String passwordenabled;    //true if the reset password feature is enabled, false otherwise
	private String project;    //the project name of the template
	private String projectid;    //the project id of the template
	private String removed;    //the date this template was removed
	private String size;    //the size of the template
	private String sourcetemplateid;    //the template ID of the parent template if present
	private String sshkeyenabled;    //true if template is sshkey enabled, false otherwise
	private String status;    //the status of the template
	private String templatetag;    //the tag of this template
	private String templatetype;    //the type of the template
	private String zoneid;    //the ID of the zone for this template
	private String zonename;    //the name of the zone for this template
	private String tags;    //the list of resource tags associated with tempate
//	private String account;    //the account associated with the tag
//	private String customer;    //customer associated with the tag
//	private String domain;    //the domain associated with the tag
//	private String domainid;    //the ID of the domain associated with the tag
//	private String key;    //tag key name
//	private String project;    //the project name where tag belongs to
//	private String projectid;    //the project id the tag belongs to
//	private String resourceid;    //id of the resource
//	private String resourcetype;    //resource type
//	private String value;    //tag value
	private String jobid;    //the ID of the latest async job acting on this object
	private String jobstatus;    //the current status of the latest async job acting on this object
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getBootable() {
		return bootable;
	}
	public void setBootable(String bootable) {
		this.bootable = bootable;
	}
	public String getChecksum() {
		return checksum;
	}
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getCrossZones() {
		return crossZones;
	}
	public void setCrossZones(String crossZones) {
		this.crossZones = crossZones;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getDisplaytext() {
		return displaytext;
	}
	public void setDisplaytext(String displaytext) {
		this.displaytext = displaytext;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getDomainid() {
		return domainid;
	}
	public void setDomainid(String domainid) {
		this.domainid = domainid;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getHostid() {
		return hostid;
	}
	public void setHostid(String hostid) {
		this.hostid = hostid;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getHypervisor() {
		return hypervisor;
	}
	public void setHypervisor(String hypervisor) {
		this.hypervisor = hypervisor;
	}
	public String getIsdynamicallyscalable() {
		return isdynamicallyscalable;
	}
	public void setIsdynamicallyscalable(String isdynamicallyscalable) {
		this.isdynamicallyscalable = isdynamicallyscalable;
	}
	public String getIsextractable() {
		return isextractable;
	}
	public void setIsextractable(String isextractable) {
		this.isextractable = isextractable;
	}
	public String getIsfeatured() {
		return isfeatured;
	}
	public void setIsfeatured(String isfeatured) {
		this.isfeatured = isfeatured;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOstypeid() {
		return ostypeid;
	}
	public void setOstypeid(String ostypeid) {
		this.ostypeid = ostypeid;
	}
	public String getOstypename() {
		return ostypename;
	}
	public void setOstypename(String ostypename) {
		this.ostypename = ostypename;
	}
	public String getPasswordenabled() {
		return passwordenabled;
	}
	public void setPasswordenabled(String passwordenabled) {
		this.passwordenabled = passwordenabled;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public String getRemoved() {
		return removed;
	}
	public void setRemoved(String removed) {
		this.removed = removed;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSourcetemplateid() {
		return sourcetemplateid;
	}
	public void setSourcetemplateid(String sourcetemplateid) {
		this.sourcetemplateid = sourcetemplateid;
	}
	public String getSshkeyenabled() {
		return sshkeyenabled;
	}
	public void setSshkeyenabled(String sshkeyenabled) {
		this.sshkeyenabled = sshkeyenabled;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTemplatetag() {
		return templatetag;
	}
	public void setTemplatetag(String templatetag) {
		this.templatetag = templatetag;
	}
	public String getTemplatetype() {
		return templatetype;
	}
	public void setTemplatetype(String templatetype) {
		this.templatetype = templatetype;
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
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public String getJobstatus() {
		return jobstatus;
	}
	public void setJobstatus(String jobstatus) {
		this.jobstatus = jobstatus;
	}

}
