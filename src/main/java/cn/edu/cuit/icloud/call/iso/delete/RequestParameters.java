/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.iso.delete;

import cn.edu.cuit.icloud.annotation.Command;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command(Cmd.DELETE_ISO)
public class RequestParameters {
	/**Required: TRUE**/
	private String id;    //the ID of the ISO file
	private String zoneid;    //the ID of the zone of the ISO file. If not specified, the ISO will be deleted from all the zones
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZoneid() {
		return zoneid;
	}
	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}

}
