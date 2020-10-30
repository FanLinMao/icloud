/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.template.register;

import cn.edu.cuit.icloud.annotation.Command;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command("registerTemplate")
public class RequestParameters {
	/**Required: TRUE**/
	private String displaytext;    //the display text of the template. This is usually used for display purposes.
	/**Required: TRUE**/
	private String format;    //the format for the template. Possible values include QCOW2, RAW, and VHD.
	/**Required: TRUE**/
	private String hypervisor;    //the target hypervisor for the template
	/**Required: TRUE**/
	private String name;    //the name of the template
	/**Required: TRUE**/
	private String ostypeid;    //the ID of the OS Type that best represents the OS of this template.
	/**Required: TRUE**/
	private String url;    //the URL of where the template is hosted. Possible URL include http:// and https://
	/**Required: TRUE**/
	private String zoneid;    //the ID of the zone the template is to be hosted on
	private String account;    //an optional accountName. Must be used with domainId.
	private String bits;    //32 or 64 bits support. 64 by default
	private String checksum;    //the MD5 checksum value of this template
	private String details;    //Template details in key/value pairs.
	private String domainid;    //an optional domainId. If the account parameter is used, domainId must also be used.
	private String isdynamicallyscalable;    //true if template contains XS/VMWare tools inorder to support dynamic scaling of VM cpu/memory
	private String isextractable;    //true if the template or its derivatives are extractable; default is false
	private String isfeatured;    //true if this template is a featured template, false otherwise
	private String ispublic;    //true if the template is available to all accounts; default is true
	private String isrouting;    //true if the template type is routing i.e., if template is used to deploy router
	private String passwordenabled;    //true if the template supports the password reset feature; default is false
	private String projectid;    //Register template for the project
	private String requireshvm;    //true if this template requires HVM
	private String sshkeyenabled;    //true if the template supports the sshkey upload feature; default is false
	private String templatetag;    //the tag for this template.
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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
	 * @return the bits
	 */
	public String getBits() {
		return bits;
	}
	/**
	 * @param bits the bits to set
	 */
	public void setBits(String bits) {
		this.bits = bits;
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
	 * @return the isrouting
	 */
	public String getIsrouting() {
		return isrouting;
	}
	/**
	 * @param isrouting the isrouting to set
	 */
	public void setIsrouting(String isrouting) {
		this.isrouting = isrouting;
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
	 * @return the requireshvm
	 */
	public String getRequireshvm() {
		return requireshvm;
	}
	/**
	 * @param requireshvm the requireshvm to set
	 */
	public void setRequireshvm(String requireshvm) {
		this.requireshvm = requireshvm;
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

}
