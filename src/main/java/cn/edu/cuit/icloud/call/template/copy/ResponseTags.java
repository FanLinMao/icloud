/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.template.copy;

import cn.edu.cuit.icloud.annotation.ResultTags;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@ResultTags("copyTemplate")
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
	 * @return the accountid
	 */
	public String getAccountid() {
		return accountid;
	}
	/**
	 * @param accountid the accountid to set
	 */
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	/**
	 * @return the bootable
	 */
	public String getBootable() {
		return bootable;
	}
	/**
	 * @param bootable the bootable to set
	 */
	public void setBootable(String bootable) {
		this.bootable = bootable;
	}
	/**
	 * @return the checksum
	 */
	public String getChecksum() {
		return checksum;
	}
	/**
	 * @param checksum the checksum to set
	 */
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	/**
	 * @return the created
	 */
	public String getCreated() {
		return created;
	}
	/**
	 * @param created the created to set
	 */
	public void setCreated(String created) {
		this.created = created;
	}
	/**
	 * @return the crossZones
	 */
	public String getCrossZones() {
		return crossZones;
	}
	/**
	 * @param crossZones the crossZones to set
	 */
	public void setCrossZones(String crossZones) {
		this.crossZones = crossZones;
	}
	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}
	/**
	 * @return the displaytext
	 */
	public String getDisplaytext() {
		return displaytext;
	}
	/**
	 * @param displaytext the displaytext to set
	 */
	public void setDisplaytext(String displaytext) {
		this.displaytext = displaytext;
	}
	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}
	/**
	 * @param domain the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
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
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}
	/**
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}
	/**
	 * @return the hostid
	 */
	public String getHostid() {
		return hostid;
	}
	/**
	 * @param hostid the hostid to set
	 */
	public void setHostid(String hostid) {
		this.hostid = hostid;
	}
	/**
	 * @return the hostname
	 */
	public String getHostname() {
		return hostname;
	}
	/**
	 * @param hostname the hostname to set
	 */
	public void setHostname(String hostname) {
		this.hostname = hostname;
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
	 * @return the isdynamicallyscalable
	 */
	public String getIsdynamicallyscalable() {
		return isdynamicallyscalable;
	}
	/**
	 * @param isdynamicallyscalable the isdynamicallyscalable to set
	 */
	public void setIsdynamicallyscalable(String isdynamicallyscalable) {
		this.isdynamicallyscalable = isdynamicallyscalable;
	}
	/**
	 * @return the isextractable
	 */
	public String getIsextractable() {
		return isextractable;
	}
	/**
	 * @param isextractable the isextractable to set
	 */
	public void setIsextractable(String isextractable) {
		this.isextractable = isextractable;
	}
	/**
	 * @return the isfeatured
	 */
	public String getIsfeatured() {
		return isfeatured;
	}
	/**
	 * @param isfeatured the isfeatured to set
	 */
	public void setIsfeatured(String isfeatured) {
		this.isfeatured = isfeatured;
	}
	/**
	 * @return the ispublic
	 */
	public String getIspublic() {
		return ispublic;
	}
	/**
	 * @param ispublic the ispublic to set
	 */
	public void setIspublic(String ispublic) {
		this.ispublic = ispublic;
	}
	/**
	 * @return the isready
	 */
	public String getIsready() {
		return isready;
	}
	/**
	 * @param isready the isready to set
	 */
	public void setIsready(String isready) {
		this.isready = isready;
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
	 * @return the ostypeid
	 */
	public String getOstypeid() {
		return ostypeid;
	}
	/**
	 * @param ostypeid the ostypeid to set
	 */
	public void setOstypeid(String ostypeid) {
		this.ostypeid = ostypeid;
	}
	/**
	 * @return the ostypename
	 */
	public String getOstypename() {
		return ostypename;
	}
	/**
	 * @param ostypename the ostypename to set
	 */
	public void setOstypename(String ostypename) {
		this.ostypename = ostypename;
	}
	/**
	 * @return the passwordenabled
	 */
	public String getPasswordenabled() {
		return passwordenabled;
	}
	/**
	 * @param passwordenabled the passwordenabled to set
	 */
	public void setPasswordenabled(String passwordenabled) {
		this.passwordenabled = passwordenabled;
	}
	/**
	 * @return the project
	 */
	public String getProject() {
		return project;
	}
	/**
	 * @param project the project to set
	 */
	public void setProject(String project) {
		this.project = project;
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
	 * @return the removed
	 */
	public String getRemoved() {
		return removed;
	}
	/**
	 * @param removed the removed to set
	 */
	public void setRemoved(String removed) {
		this.removed = removed;
	}
	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * @return the sourcetemplateid
	 */
	public String getSourcetemplateid() {
		return sourcetemplateid;
	}
	/**
	 * @param sourcetemplateid the sourcetemplateid to set
	 */
	public void setSourcetemplateid(String sourcetemplateid) {
		this.sourcetemplateid = sourcetemplateid;
	}
	/**
	 * @return the sshkeyenabled
	 */
	public String getSshkeyenabled() {
		return sshkeyenabled;
	}
	/**
	 * @param sshkeyenabled the sshkeyenabled to set
	 */
	public void setSshkeyenabled(String sshkeyenabled) {
		this.sshkeyenabled = sshkeyenabled;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the templatetag
	 */
	public String getTemplatetag() {
		return templatetag;
	}
	/**
	 * @param templatetag the templatetag to set
	 */
	public void setTemplatetag(String templatetag) {
		this.templatetag = templatetag;
	}
	/**
	 * @return the templatetype
	 */
	public String getTemplatetype() {
		return templatetype;
	}
	/**
	 * @param templatetype the templatetype to set
	 */
	public void setTemplatetype(String templatetype) {
		this.templatetype = templatetype;
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
	/**
	 * @return the zonename
	 */
	public String getZonename() {
		return zonename;
	}
	/**
	 * @param zonename the zonename to set
	 */
	public void setZonename(String zonename) {
		this.zonename = zonename;
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
	 * @return the jobid
	 */
	public String getJobid() {
		return jobid;
	}
	/**
	 * @param jobid the jobid to set
	 */
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	/**
	 * @return the jobstatus
	 */
	public String getJobstatus() {
		return jobstatus;
	}
	/**
	 * @param jobstatus the jobstatus to set
	 */
	public void setJobstatus(String jobstatus) {
		this.jobstatus = jobstatus;
	}


}
