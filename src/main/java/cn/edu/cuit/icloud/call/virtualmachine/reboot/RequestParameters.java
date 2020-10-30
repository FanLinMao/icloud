/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.virtualmachine.reboot;

import cn.edu.cuit.icloud.annotation.Command;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command(Cmd.REBOOT_VIRTUALMACHINE)
public class RequestParameters {
	/**Required: TRUE**/
	private String id;    //The ID of the virtual machine

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}	
