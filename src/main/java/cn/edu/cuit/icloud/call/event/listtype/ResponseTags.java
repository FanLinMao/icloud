/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.event.listtype;

import cn.edu.cuit.icloud.annotation.ResultTags;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@ResultTags(Cmd.LIST_EVENT_TYPES)
public class ResponseTags {
	private String name;    //Event Type

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
