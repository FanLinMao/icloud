/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.template.delete;

import cn.edu.cuit.icloud.annotation.ResultTags;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@ResultTags("deleteTemplate")
public class ResponseTags {
	
	private String displaytext;    //any text associated with the success or failure
	private String success;    //true if operation is executed successfully
	/**
	 * @return the displaytext
	 */
	public String getDisplaytext() {
		return displaytext;
	}
	/**
	 * @param displaytext the displaytext to set
	 */
	public void setDisplaytext(String displaytext) {
		this.displaytext = displaytext;
	}
	/**
	 * @return the success
	 */
	public String getSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(String success) {
		this.success = success;
	}


}
