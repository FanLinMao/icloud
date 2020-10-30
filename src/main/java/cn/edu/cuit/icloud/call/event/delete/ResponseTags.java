/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.event.delete;

import cn.edu.cuit.icloud.annotation.ResultTags;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@ResultTags(Cmd.DELETE_EVENTS)
public class ResponseTags {
	
	
	private String displaytext;    //any text associated with the success or failure
	private String success;    //true if operation is executed successfully
	public String getDisplaytext() {
		return displaytext;
	}
	public void setDisplaytext(String displaytext) {
		this.displaytext = displaytext;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	
	
	

}
