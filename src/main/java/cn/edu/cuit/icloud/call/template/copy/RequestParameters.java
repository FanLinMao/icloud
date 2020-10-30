/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.template.copy;

import cn.edu.cuit.icloud.annotation.Command;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command("copyTemplate")
public class RequestParameters {
	
	/**Required: TRUE**/
	private String id;    //Template ID.
	/**Required: TRUE**/
	private String destzoneid;    //ID of the zone the template is being copied to.
	
	private String sourcezoneid;    //ID of the zone the template is currently hosted on. If not specified and template is cross-zone, then we will sync this template to region wide image store

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
	 * @return the destzoneid
	 */
	public String getDestzoneid() {
		return destzoneid;
	}

	/**
	 * @param destzoneid the destzoneid to set
	 */
	public void setDestzoneid(String destzoneid) {
		this.destzoneid = destzoneid;
	}

	/**
	 * @return the sourcezoneid
	 */
	public String getSourcezoneid() {
		return sourcezoneid;
	}

	/**
	 * @param sourcezoneid the sourcezoneid to set
	 */
	public void setSourcezoneid(String sourcezoneid) {
		this.sourcezoneid = sourcezoneid;
	}

	
}
