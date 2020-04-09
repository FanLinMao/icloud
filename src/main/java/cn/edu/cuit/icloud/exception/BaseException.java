package cn.edu.cuit.icloud.exception;


/**
 * TODO
 * @date: 2020Äê4ÔÂ2ÈÕ
 * @author: flfan
 */
public class BaseException extends RuntimeException{
	
	private String code;
	
	private String msg;
	
	public BaseException(String code, String msg){
		super(code+", "+msg);
		this.code = code;
		this.msg = msg;
	}

	public BaseException(String msg){
		super(msg);
		this.code = "500";
		this.msg = msg;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
