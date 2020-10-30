/**

 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.iso.update;

import cn.edu.cuit.icloud.annotation.Command;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command(Cmd.UPDATE_ISO)
public class RequestParameters {
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBootable() {
		return bootable;
	}
	public void setBootable(String bootable) {
		this.bootable = bootable;
	}
	public String getDisplaytext() {
		return displaytext;
	}
	public void setDisplaytext(String displaytext) {
		this.displaytext = displaytext;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getIsdynamicallyscalable() {
		return isdynamicallyscalable;
	}
	public void setIsdynamicallyscalable(String isdynamicallyscalable) {
		this.isdynamicallyscalable = isdynamicallyscalable;
	}
	public String getIsrouting() {
		return isrouting;
	}
	public void setIsrouting(String isrouting) {
		this.isrouting = isrouting;
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
	public String getPasswordenabled() {
		return passwordenabled;
	}
	public void setPasswordenabled(String passwordenabled) {
		this.passwordenabled = passwordenabled;
	}
	public String getSortkey() {
		return sortkey;
	}
	public void setSortkey(String sortkey) {
		this.sortkey = sortkey;
	}

}
