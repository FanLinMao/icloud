/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.ip.range.delete;

import cn.edu.cuit.icloud.annotation.Command;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command(Cmd.DELETE_IP_RANGE)
public class RequestParameters {
	//required
	private String id;    //the uuid of the storage network ip range

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
