/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.template.delete;

import cn.edu.cuit.icloud.annotation.Command;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command("deleteTemplate")
public class RequestParameters {
	/**Required: TRUE**/
	private String id;    //the ID of the template
	private String zoneid;    //the ID of zone of the template
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the zoneid
	 */
	public String getZoneid() {
		return zoneid;
	}
	/**
	 * @param zoneid the zoneid to set
	 */
	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}
	
}
