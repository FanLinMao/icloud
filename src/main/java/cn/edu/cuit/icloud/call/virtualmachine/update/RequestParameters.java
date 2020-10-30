/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.virtualmachine.update;

import cn.edu.cuit.icloud.annotation.Command;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command(Cmd.UPDATE_VIRTUALMACHINE)
public class RequestParameters {
	/**Required: TRUE**/
	private String id;    //The ID of the virtual machine
	private String displayname;    //user generated name
	private String displayvm;    //an optional field, whether to the display the vm to the end user or not.
	private String group;    //group of the virtual machine
	private String haenable;    //true if high-availability is enabled for the virtual machine, false otherwise
	private String isdynamicallyscalable;    //true if VM contains XS/VMWare tools inorder to support dynamic scaling of VM cpu/memory
	private String ostypeid;    //the ID of the OS type that best represents this VM.
	private String userdata;    //an optional binary data that can be sent to the virtual machine upon a successful deployment. This binary data must be base64 encoded before adding it to the request. Using HTTP GET (via querystring), you can send up to 2KB of data after base64 encoding. Using HTTP POST(via POST body), you can send up to 32K of data after base64 encoding.
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	public String getDisplayvm() {
		return displayvm;
	}
	public void setDisplayvm(String displayvm) {
		this.displayvm = displayvm;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getHaenable() {
		return haenable;
	}
	public void setHaenable(String haenable) {
		this.haenable = haenable;
	}
	public String getIsdynamicallyscalable() {
		return isdynamicallyscalable;
	}
	public void setIsdynamicallyscalable(String isdynamicallyscalable) {
		this.isdynamicallyscalable = isdynamicallyscalable;
	}
	public String getOstypeid() {
		return ostypeid;
	}
	public void setOstypeid(String ostypeid) {
		this.ostypeid = ostypeid;
	}
	public String getUserdata() {
		return userdata;
	}
	public void setUserdata(String userdata) {
		this.userdata = userdata;
	}

}
