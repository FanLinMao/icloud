/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.iso.attach;

import cn.edu.cuit.icloud.annotation.Command;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command(Cmd.ATTACH_ISO)
public class RequestParameters {
	/**Required: TRUE**/
	private String id;    //the ID of the ISO file
	/**Required: TRUE**/
	private String virtualmachineid;    //the ID of the virtual machine
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVirtualmachineid() {
		return virtualmachineid;
	}
	public void setVirtualmachineid(String virtualmachineid) {
		this.virtualmachineid = virtualmachineid;
	}

}
