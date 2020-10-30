package cn.edu.cuit.icloud.action.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

import cn.edu.cuit.icloud.call.template.create.ResponseTags;
import cn.edu.cuit.icloud.constant.Cmd;
import cn.edu.cuit.icloud.constant.Result;
import cn.edu.cuit.icloud.dto.MessageDTO;
import cn.edu.cuit.icloud.exception.BaseException;
import cn.edu.cuit.icloud.service.CallService;
import cn.edu.cuit.icloud.service.impl.AdminServiceImpl;
import cn.edu.cuit.icloud.service.impl.CallServiceImpl;
import cn.edu.cuit.icloud.service.impl.TeacherServiceImpl;
import cn.edu.cuit.icloud.vo.IsoVO;
import cn.edu.cuit.icloud.vo.SoftVO;
import cn.edu.cuit.icloud.vo.TemplateVO;
import cn.edu.cuit.icloud.vo.UserVO;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月9日
 */
@WebServlet("/soft")
public class SoftwareServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	static Logger logger = Logger.getLogger(SoftwareServlet.class);
	
	private static Properties props = null;
	static{
		props = new Properties();
		try {
			props.load(IsoServlet.class.getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private AdminServiceImpl adminService = null;
	
	public SoftwareServlet() {
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
		String command = req.getParameter("action");//command
		String parameters = req.getParameter("parameters");
		MessageDTO dto = new MessageDTO();
		Gson gson = new Gson();
		if("del".equals(command)) {
			String ids = req.getParameter("ids");
			String softName = req.getParameter("filename");
			Object uploadPath = props.getOrDefault("upload_path", "c:/upload/");
	    	File file = new File(uploadPath+softName);
	    	if(file.exists()) {
	    		file.delete();
	    	}
			boolean success = adminService.deleteSoft(Integer.valueOf(ids));
			if(success) {
				dto.setCode(Result.SUCCESS.getCode());
		    	dto.setCount(1);
		    	dto.setMsg("删除成功！");
		    	logger.info("删除成功！");
			}else {
				dto.setCode(Result.FAILURE.getCode());
		    	dto.setCount(0);
		    	dto.setMsg("删除失败！");
		    	logger.info("删除失败！");
			}
		}else if("edit".equals(command)) {
			SoftVO vo = gson.fromJson(parameters, SoftVO.class);
			SoftVO old_soft = adminService.findSoftById(vo.getSoftId());
	    	Object uploadPath = props.getOrDefault("upload_path", "c:/upload/");
	    	File srcFile = new File(uploadPath+old_soft.getSoftName());
	    	File destFile = new File(uploadPath+vo.getSoftName());
	    	if(srcFile.exists()) {
	    		srcFile.renameTo(destFile);
	    	}
			boolean success = adminService.updateSoft(vo);
			if(success) {
				dto.setCode(Result.SUCCESS.getCode());
		    	dto.setCount(1);
		    	dto.setMsg("修改信息成功！");
		    	logger.info("修改信息成功！");
			}else {
				dto.setCode(Result.FAILURE.getCode());
		    	dto.setCount(0);
		    	dto.setMsg("修改信息失败！");
		    	logger.info("修改信息失败！");
			}
		}else if("list".equals(command)) {
			List<SoftVO> softs = adminService.listSofts();
	    	dto.setCode(Result.SUCCESS.getCode());
	    	dto.setCount(softs.size());
	    	dto.setData(gson.toJson(softs));
	    	dto.setMsg("查询所有软件成功！");
	    	logger.info("查询所有软件成功！");
		}
		
		resp.getWriter().write(dto.toString());
	}
	
}
