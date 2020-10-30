package cn.edu.cuit.icloud.vo;

import java.math.BigDecimal;

/**
 * TODO
 * @author: Think
 * @since: 2020Äê5ÔÂ10ÈÕ
 */
public class IsoVO {
	
	private Integer id;
	
	private String isoName;
	
	private String osType;
	
	private long osSize;
	
	private String creator;
	
	private String createDate;
	
	private String src;

	public String getIsoName() {
		return isoName;
	}

	public void setIsoName(String isoName) {
		this.isoName = isoName;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public long getOsSize() {
		return osSize;
	}

	public void setOsSize(long osSize) {
		this.osSize = osSize;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
	
	
	
}
