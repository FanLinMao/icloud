/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.virtualmachine.start;

import cn.edu.cuit.icloud.annotation.Command;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command(Cmd.START_VIRTUALMACHINE)
public class RequestParameters {
	/**Required: TRUE**/
	private String id;    //The ID of the virtual machine
	private String hostid;    //destination Host ID to deploy the VM to - parameter available for root admin only
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHostid() {
		return hostid;
	}
	public void setHostid(String hostid) {
		this.hostid = hostid;
	}

}
