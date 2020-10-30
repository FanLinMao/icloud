package cn.edu.cuit.icloud.action.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;



import cn.edu.cuit.icloud.constant.Cmd;
import cn.edu.cuit.icloud.constant.Result;
import cn.edu.cuit.icloud.dto.MessageDTO;
import cn.edu.cuit.icloud.exception.BaseException;
import cn.edu.cuit.icloud.service.CallService;
import cn.edu.cuit.icloud.service.impl.AdminServiceImpl;
import cn.edu.cuit.icloud.service.impl.CallServiceImpl;
import cn.edu.cuit.icloud.vo.TemplateVO;
import cn.edu.cuit.icloud.vo.UserVO;
import cn.edu.cuit.icloud.vo.VirtualMachineVO;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月9日
 */
@WebServlet("/vm")
public class VirtualMachineServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	static Logger logger = Logger.getLogger(VirtualMachineServlet.class);
	
	private CallService callService = null;
	
	private AdminServiceImpl adminService = null;
	
	public VirtualMachineServlet() {
		adminService = new AdminServiceImpl();
		callService = new CallServiceImpl();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		String parameter = req.getParameter("action");
		MessageDTO dto = new MessageDTO();
		Gson gson = new Gson();
		
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
		VirtualMachineVO vo = new VirtualMachineVO();
		Gson gson = new Gson();
		try {
			
			if(Cmd.LIST_VIRTUALMACHINES.equals(command)) {
				Object callCommand = callService.callCommand(command, parameters);
				if(null != callCommand) {
					cn.edu.cuit.icloud.call.virtualmachine.start.ResponseTags resultTags = (cn.edu.cuit.icloud.call.virtualmachine.start.ResponseTags)callCommand;
					dto.setCode(Result.SUCCESS.getCode());
					dto.setCount(1);
					dto.setMsg("查询成功！");
				}else {
					dto.setCode(Result.SUCCESS.getCode());
					dto.setCount(1);
					dto.setMsg("查询失败！");
				}
			}else if(Cmd.START_VIRTUALMACHINE.equals(command)) {
				Object callCommand = callService.callCommand(command, parameters);
				if(null != callCommand) {
					cn.edu.cuit.icloud.call.virtualmachine.start.ResponseTags resultTags = (cn.edu.cuit.icloud.call.virtualmachine.start.ResponseTags)callCommand;
					dto.setCode(Result.SUCCESS.getCode());
					dto.setCount(1);
					dto.setMsg("开机成功！");
				}else {
					dto.setCode(Result.SUCCESS.getCode());
					dto.setCount(1);
					dto.setMsg("开机失败！");
				}
			}else if(Cmd.STOP_VIRTUALMACHINE.equals(command)) {
				Object callCommand = callService.callCommand(command, parameters);
				if(null != callCommand) {
					cn.edu.cuit.icloud.call.virtualmachine.stop.ResponseTags resultTags = (cn.edu.cuit.icloud.call.virtualmachine.stop.ResponseTags)callCommand;
					dto.setCode(Result.SUCCESS.getCode());
					dto.setCount(1);
					dto.setMsg("关机成功！");
				}else {
					dto.setCode(Result.SUCCESS.getCode());
					dto.setCount(1);
					dto.setMsg("关机失败！");
				}
			}else if(Cmd.DEPLOY_VIRTUALMACHINE.equals(command)) {
				Object callCommand = callService.callCommand(command, parameters);
				if(null != callCommand) {
					cn.edu.cuit.icloud.call.virtualmachine.deploy.ResponseTags resultTags = (cn.edu.cuit.icloud.call.virtualmachine.deploy.ResponseTags)callCommand;
					dto.setCode(Result.SUCCESS.getCode());
					dto.setCount(1);
					dto.setMsg("新建成功！");
				}else {
					dto.setCode(Result.SUCCESS.getCode());
					dto.setCount(1);
					dto.setMsg("新建失败！");
				}
			}else if(Cmd.DESTROY_VIRTUALMACHINE.equals(command)) {
				Object callCommand = callService.callCommand(command, parameters);
				if(null != callCommand) {
					cn.edu.cuit.icloud.call.virtualmachine.destroy.ResponseTags resultTags = (cn.edu.cuit.icloud.call.virtualmachine.destroy.ResponseTags)callCommand;
					dto.setCode(Result.SUCCESS.getCode());
					dto.setCount(1);
					dto.setMsg("销毁成功！");
				}else {
					dto.setCode(Result.SUCCESS.getCode());
					dto.setCount(1);
					dto.setMsg("销毁失败！");
				}
			}else if(Cmd.REBOOT_VIRTUALMACHINE.equals(command)) {
				Object callCommand = callService.callCommand(command, parameters);
				if(null != callCommand) {
					cn.edu.cuit.icloud.call.virtualmachine.reboot.ResponseTags resultTags = (cn.edu.cuit.icloud.call.virtualmachine.reboot.ResponseTags)callCommand;
					dto.setCode(Result.SUCCESS.getCode());
					dto.setCount(1);
					dto.setMsg("重启成功！");
				}else {
					dto.setCode(Result.SUCCESS.getCode());
					dto.setCount(1);
					dto.setMsg("重启失败！");
				}
			}
		
		}catch(Exception e) {
			logger.error(command+"："+e.getMessage());
			dto.setCode(Result.SERVER_INTERNAL.getCode());
			dto.setCount(0);
			dto.setMsg(Result.SERVER_INTERNAL.getMsg());
		}
		resp.getWriter().write(dto.toString());
	}
	
}
