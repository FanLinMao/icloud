/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.virtualmachine.destroy;

import cn.edu.cuit.icloud.annotation.Command;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command(Cmd.DESTROY_VIRTUALMACHINE)
public class RequestParameters {
	/**Required: TRUE**/
	private String id;    //The ID of the virtual machine
	private String expunge;    //If true is passed, the vm is expunged immediately. False by default. Parameter can be passed to the call by ROOT/Domain admin only
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getExpunge() {
		return expunge;
	}
	public void setExpunge(String expunge) {
		this.expunge = expunge;
	}

	
}
