/**

 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.iso.register;

import com.google.gson.annotations.JsonAdapter;

import cn.edu.cuit.icloud.adapter.BooleanAdapter;
import cn.edu.cuit.icloud.annotation.Command;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command(Cmd.REGISTER_ISO)
public class RequestParameters {
	//Required
	private String displaytext;    //the display text of the ISO. This is usually used for display purposes.
	private String name;    //the name of the ISO
	private String url;    //the URL to where the ISO is currently being hosted
	private String zoneid;    //the ID of the zone you wish to register the ISO to.
	
	//not required
	private String account;    //an optional account name. Must be used with domainId.
	@JsonAdapter(BooleanAdapter.class)
	private boolean bootable;    //true if this ISO is bootable. If not passed explicitly its assumed to be true
	private String checksum;    //the MD5 checksum value of this ISO
	private String domainid;    //an optional domainId. If the account parameter is used, domainId must also be used.
	private String imagestoreuuid;    //Image store uuid
	@JsonAdapter(BooleanAdapter.class)
	private boolean isdynamicallyscalable;    //true if iso contains XS/VMWare tools inorder to support dynamic scaling of VM cpu/memory
	@JsonAdapter(BooleanAdapter.class)
	private boolean isextractable;    //true if the iso or its derivatives are extractable; default is false
	@JsonAdapter(BooleanAdapter.class)
	private boolean isfeatured;    //true if you want this ISO to be featured
	@JsonAdapter(BooleanAdapter.class)
	private boolean ispublic;    //true if you want to register the ISO to be publicly available to all users, false otherwise.
	private String ostypeid;    //the ID of the OS Type that best represents the OS of this ISO. If the iso is bootable this parameter needs to be passed
	private String projectid;    //Register iso for the project
	
	
	public String getDisplaytext() {
		return displaytext;
	}
	public void setDisplaytext(String displaytext) {
		this.displaytext = displaytext;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getZoneid() {
		return zoneid;
	}
	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public boolean isBootable() {
		return bootable;
	}
	public void setBootable(boolean bootable) {
		this.bootable = bootable;
	}
	public String getChecksum() {
		return checksum;
	}
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	public String getDomainid() {
		return domainid;
	}
	public void setDomainid(String domainid) {
		this.domainid = domainid;
	}
	public String getImagestoreuuid() {
		return imagestoreuuid;
	}
	public void setImagestoreuuid(String imagestoreuuid) {
		this.imagestoreuuid = imagestoreuuid;
	}
	public boolean isIsdynamicallyscalable() {
		return isdynamicallyscalable;
	}
	public void setIsdynamicallyscalable(boolean isdynamicallyscalable) {
		this.isdynamicallyscalable = isdynamicallyscalable;
	}
	public boolean isIsextractable() {
		return isextractable;
	}
	public void setIsextractable(boolean isextractable) {
		this.isextractable = isextractable;
	}
	public boolean isIsfeatured() {
		return isfeatured;
	}
	public void setIsfeatured(boolean isfeatured) {
		this.isfeatured = isfeatured;
	}
	public boolean isIspublic() {
		return ispublic;
	}
	public void setIspublic(boolean ispublic) {
		this.ispublic = ispublic;
	}
	public String getOstypeid() {
		return ostypeid;
	}
	public void setOstypeid(String ostypeid) {
		this.ostypeid = ostypeid;
	}
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	@Override
	public String toString() {
		return "RequestParameters [displaytext=" + displaytext + ", name=" + name + ", url=" + url + ", zoneid="
				+ zoneid + ", account=" + account + ", bootable=" + bootable + ", checksum=" + checksum + ", domainid="
				+ domainid + ", imagestoreuuid=" + imagestoreuuid + ", isdynamicallyscalable=" + isdynamicallyscalable
				+ ", isextractable=" + isextractable + ", isfeatured=" + isfeatured + ", ispublic=" + ispublic
				+ ", ostypeid=" + ostypeid + ", projectid=" + projectid + "]";
	}


}
