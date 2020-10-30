package cn.edu.cuit.icloud.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import cn.edu.cuit.icloud.common.DBCon;
import cn.edu.cuit.icloud.service.UploadService;
import cn.edu.cuit.icloud.vo.IsoVO;
import cn.edu.cuit.icloud.vo.SoftVO;

/**
 * TODO
 * @author: Think
 * @since: 2020Äê5ÔÂ10ÈÕ
 */
public class UploadServiceImpl implements UploadService{

	private DBCon dbc = new DBCon();
	/* (non-Javadoc)
	 * @see cn.edu.cuit.icloud.service.UploadService#insertIsoInfo(cn.edu.cuit.icloud.vo.IsoVO)
	 */
	@Override
	public boolean insertIsoInfo(IsoVO isoInfo) {
		int res = 0;
		if(!Objects.isNull(isoInfo)) {
			String sql = "insert into iso(id,iso_name,ostype,ossize,creator,create_date,src) values(0,?,?,?,?,?,?)";
			res = dbc.doUpdate(sql, new Object[] {isoInfo.getIsoName(),isoInfo.getOsType()
													,isoInfo.getOsSize()
													,isoInfo.getCreator()
													,isoInfo.getCreateDate()
													,isoInfo.getSrc()});
			dbc.close();
		}
		return res>0;
	}
	/* (non-Javadoc)
	 * @see cn.edu.cuit.icloud.service.UploadService#insertSoftInfo(cn.edu.cuit.icloud.vo.SoftVO)
	 */
	@Override
	public boolean insertSoftInfo(SoftVO softVo) {
		int res = 0;
		if(!Objects.isNull(softVo)) {
			String sql = "insert into soft(soft_id,soft_name,size,uploader,upload_date,remark,src) values(0,?,?,?,?,?,?)";
			res = dbc.doUpdate(sql, new Object[] {softVo.getSoftName(),
														softVo.getSize(),
														softVo.getUploader(),
														softVo.getUploadDate(),
														softVo.getMark(),
														softVo.getResource()});
			dbc.close();
		}
		return res>0;
	}

	

}
