package cn.edu.cuit.icloud.action.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

import cn.edu.cuit.icloud.constant.Result;
import cn.edu.cuit.icloud.dto.MessageDTO;
import cn.edu.cuit.icloud.service.impl.AdminServiceImpl;
import cn.edu.cuit.icloud.utils.UrlUtil;
import cn.edu.cuit.icloud.vo.IsoVO;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月11日
 */
@WebServlet("/iso")
public class IsoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static Properties props = null;
	static{
		props = new Properties();
		try {
			props.load(IsoServlet.class.getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static Logger logger = Logger.getLogger(IsoServlet.class);
	
	private AdminServiceImpl adminService = null;
	
	public IsoServlet() {
		adminService = new AdminServiceImpl();
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
	    MessageDTO dto = new MessageDTO();
	    Gson gson = new Gson();
	    String action = req.getParameter("action");
	    if("list".equals(action)) {
	    	List<IsoVO> isos = adminService.listIsos();
	    	dto.setCode(Result.SUCCESS.getCode());
	    	dto.setCount(isos.size());
	    	dto.setData(gson.toJson(isos));
	    	dto.setMsg("查询所有ISO成功！");
	    	logger.info("查询所有ISO成功！");
	    }else if("del".equals(action)) {
	    	String id = req.getParameter("ids");
	    	String isoName = req.getParameter("filename");
	    	Object uploadPath = props.getOrDefault("upload_path", "c:/upload/");
	    	File file = new File(uploadPath+isoName);
	    	if(file.exists()) {
	    		file.delete();
	    	}
	    	boolean success = adminService.deleteIsoById(Integer.valueOf(id));
	    	if(!success) {
	    		dto.setCode(Result.FAILURE.getCode());
		    	dto.setCount(0);
		    	dto.setMsg("删除失败！");
		    	logger.info("删除失败！");
	    	}else {
	    		dto.setCode(Result.SUCCESS.getCode());
	    		dto.setCount(1);
	    		dto.setMsg("删除成功！");
	    		logger.info("删除成功！");
	    	}
	    }else if("edit".equals(action)) {
	    	String parameters = req.getParameter("parmeters");
	    	IsoVO vo = gson.fromJson(parameters, IsoVO.class);
	    	IsoVO old_iso = adminService.findIsoById(vo.getId());
	    	Object uploadPath = props.getOrDefault("upload_path", "c:/upload/");
	    	File srcFile = new File(uploadPath+old_iso.getIsoName());
	    	File destFile = new File(uploadPath+vo.getIsoName());
	    	if(srcFile.exists()) {
	    		srcFile.renameTo(destFile);
	    	}
	    	boolean success = adminService.updateIso(vo);
	    	if(!success) {
	    		dto.setCode(Result.FAILURE.getCode());
		    	dto.setCount(0);
		    	dto.setMsg("修改失败！");
		    	logger.info("修改失败！");
	    	}else {
	    		dto.setCode(Result.SUCCESS.getCode());
	    		dto.setCount(1);
	    		dto.setMsg("修改成功！");
	    		logger.info("修改成功！");
	    	}
	    }
	    
	    resp.getWriter().write(dto.toString());
	}
	
}
