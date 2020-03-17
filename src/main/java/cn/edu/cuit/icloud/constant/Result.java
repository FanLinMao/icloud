package cn.edu.cuit.icloud.constant;


/**
 * TODO
 * @date: 2020年3月16日
 * @author: flfan
 */
public enum Result {
	SUCCESS(200,"请求成功"),
	FAILURE(201,"请求失败"),
	NOT_FOUND_PAGE(404,"找不到页面"),
	SERVER_INTERNAL(500,"服务器内部错误");
	
	private String msg;
	
	private int code;
	
	Result(int code, String msg){
		this.code = code;
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public int getCode() {
		return code;
	}

	
	
}
