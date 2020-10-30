/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.template.update;

import cn.edu.cuit.icloud.annotation.Command;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command("updateTemplate")
public class RequestParameters {
	/**Required: TRUE**/
	private String id;    //the ID of the image file
	private String bootable;    //true if image is bootable, false otherwise
	private String displaytext;    //the display text of the image
	private String format;    //the format for the image
	private String isdynamicallyscalable;    //true if template/ISO contains XS/VMWare tools inorder to support dynamic scaling of VM cpu/memory
	private String isrouting;    //true if the template type is routing i.e., if template is used to deploy router
	private String name;    //the name of the image file
	private String ostypeid;    //the ID of the OS type that best represents the OS of this image.
	private String passwordenabled;    //true if the image supports the password reset feature; default is false
	private String sortkey;    //sort key of the template, integer
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
	 * @return the sortkey
	 */
	public String getSortkey() {
		return sortkey;
	}
	/**
	 * @param sortkey the sortkey to set
	 */
	public void setSortkey(String sortkey) {
		this.sortkey = sortkey;
	}

}
