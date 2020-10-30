package cn.edu.cuit.icloud.constant;

/**
 * TODO
 * @author: Think
 * @since: 2020Äê5ÔÂ10ÈÕ
 */
public enum OStypeEnum {
	
	WINDOWS(1,"Windows 32bit"),
	UBANTU(2,"Ubantu 32bit"),
	CENTOS(3,"CentOS 32bit"),
	WINDOWS_64(4,"Windows 64bit"),
	UBANTU_64(5,"Ubantu 64bit"),
	CENTOS_64(6,"CentOS 64bit");
	
	
	private int code;
	
	private String type;
	
	private OStypeEnum(int code, String type) {
		this.code = code;
		this.type = type;
	}

	public int getCode() {
		return code;
	}

	public String getType() {
		return type;
	}
	
	public static String getOsType(String filename) {
		String type = "";
		String lowerCaseStr = filename.toLowerCase();
		if(lowerCaseStr.contains("centos") && lowerCaseStr.contains("64")) {
			type = OStypeEnum.CENTOS_64.getType();
		}else if(lowerCaseStr.contains("centos")) {
			type = OStypeEnum.CENTOS.getType();
		}else if(lowerCaseStr.contains("windows") && lowerCaseStr.contains("64")) {
			type = OStypeEnum.WINDOWS_64.getType();
		}else if(lowerCaseStr.contains("windows")) {
			type = OStypeEnum.WINDOWS.getType();
		}else if(lowerCaseStr.contains("ubantu") && lowerCaseStr.contains("64")) {
			type = OStypeEnum.UBANTU_64.getType();
		}else if(lowerCaseStr.contains("ubantu")) {
			type = OStypeEnum.UBANTU.getType();
		}
		
		return type;
	}
}
