package cn.edu.cuit.icloud.service;

import java.util.List;

import cn.edu.cuit.icloud.vo.IsoVO;
import cn.edu.cuit.icloud.vo.SoftVO;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月10日
 */
public interface UploadService {
	//============上传iso入库=========
	public boolean insertIsoInfo(IsoVO isoInfo);
	//============上传iso入库=========
	
	//=========上传other入库======
	public boolean insertSoftInfo(SoftVO softVo);
	//=========上传other入库======
}
