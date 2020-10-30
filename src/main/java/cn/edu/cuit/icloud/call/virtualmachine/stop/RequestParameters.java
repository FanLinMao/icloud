/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.virtualmachine.stop;

import cn.edu.cuit.icloud.annotation.Command;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command(Cmd.STOP_VIRTUALMACHINE)
public class RequestParameters {
	/**Required: TRUE**/
	private String id;    //The ID of the virtual machine
	private String forced;    //Force stop the VM (vm is marked as Stopped even when command fails to be send to the backend). The caller knows the VM is stopped.
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getForced() {
		return forced;
	}
	public void setForced(String forced) {
		this.forced = forced;
	}

}
