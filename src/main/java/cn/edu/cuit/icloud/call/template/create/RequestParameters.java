/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.template.create;

import cn.edu.cuit.icloud.annotation.Command;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command("createTemplate")
public class RequestParameters {
	
	/**Required: TRUE**/
	private String displaytext;    //the display text of the template. This is usually used for display purposes.
	/**Required: TRUE**/
	private String name;    //the name of the template
	/**Required: TRUE**/
	private String ostypeid;    //the ID of the OS Type that best represents the OS of this template.
	private String bits;    //32 or 64 bit
	private String details;    //Template details in key/value pairs.
	private String isdynamicallyscalable;    //true if template contains XS/VMWare tools inorder to support dynamic scaling of VM cpu/memory
	private String isfeatured;    //true if this template is a featured template, false otherwise
	private String ispublic;    //true if this template is a public template, false otherwise
	private String passwordenabled;    //true if the template supports the password reset feature; default is false
	private String requireshvm;    //true if the template requres HVM, false otherwise
	private String snapshotid;    //the ID of the snapshot the template is being created from. Either this parameter, or volumeId has to be passed in
	private String templatetag;    //the tag for this template.
	private String url;    //Optional, only for baremetal hypervisor. The directory name where template stored on CIFS server
	private String virtualmachineid;    //Optional, VM ID. If this presents, it is going to create a baremetal template for VM this ID refers to. This is only for VM whose hypervisor type is BareMetal
	private String volumeid;    //the ID of the disk volume the template is being created from. Either this parameter, or snapshotId has to be passed in
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
	 * @return the snapshotid
	 */
	public String getSnapshotid() {
		return snapshotid;
	}
	/**
	 * @param snapshotid the snapshotid to set
	 */
	public void setSnapshotid(String snapshotid) {
		this.snapshotid = snapshotid;
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
	 * @return the virtualmachineid
	 */
	public String getVirtualmachineid() {
		return virtualmachineid;
	}
	/**
	 * @param virtualmachineid the virtualmachineid to set
	 */
	public void setVirtualmachineid(String virtualmachineid) {
		this.virtualmachineid = virtualmachineid;
	}
	/**
	 * @return the volumeid
	 */
	public String getVolumeid() {
		return volumeid;
	}
	/**
	 * @param volumeid the volumeid to set
	 */
	public void setVolumeid(String volumeid) {
		this.volumeid = volumeid;
	}

	
}
