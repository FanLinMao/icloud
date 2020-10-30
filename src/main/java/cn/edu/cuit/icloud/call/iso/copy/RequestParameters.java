/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.iso.copy;

import cn.edu.cuit.icloud.annotation.Command;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command(Cmd.COPY_ISO)
public class RequestParameters {
	/**Required: TRUE**/
	private String id;    //Template ID.
	/**Required: TRUE**/
	private String destzoneid;    //ID of the zone the template is being copied to.
	private String sourcezoneid;    //ID of the zone the template is currently hosted on. If not specified and template is cross-zone, then we will sync this template to region wide image store
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDestzoneid() {
		return destzoneid;
	}
	public void setDestzoneid(String destzoneid) {
		this.destzoneid = destzoneid;
	}
	public String getSourcezoneid() {
		return sourcezoneid;
	}
	public void setSourcezoneid(String sourcezoneid) {
		this.sourcezoneid = sourcezoneid;
	}


}
