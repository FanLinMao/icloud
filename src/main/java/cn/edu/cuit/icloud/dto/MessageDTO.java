package cn.edu.cuit.icloud.dto;


/**
 * 消息体
 * @date: 2020年3月16日
 * @author: flfan
 * @description: 用于前后端传输json数据的消息体
 */
public class MessageDTO {
	
	/**消息**/
	private String msg;
	
	/**状态码**/
	private int code;
	
	/**传输数据**/
	private Object data;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	

}
