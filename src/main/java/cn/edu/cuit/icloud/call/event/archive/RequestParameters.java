/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
package cn.edu.cuit.icloud.call.event.archive;

import cn.edu.cuit.icloud.annotation.Command;
import cn.edu.cuit.icloud.constant.Cmd;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月4日
 */
@Command(Cmd.ARCHIVE_EVENTS)
public class RequestParameters {
	
	private String enddate;    //end date range to archive events (including) this date (use format "yyyy-MM-dd" or the new format "yyyy-MM-ddThh:mm:ss")
	private String ids;    //the IDs of the events
	private String startdate;    //start date range to archive events (including) this date (use format "yyyy-MM-dd" or the new format "yyyy-MM-ddThh:mm:ss")
	private String type;    //archive by event type
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
