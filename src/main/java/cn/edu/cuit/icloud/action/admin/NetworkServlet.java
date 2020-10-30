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

import cn.edu.cuit.icloud.call.template.create.ResponseTags;
import cn.edu.cuit.icloud.constant.Cmd;
import cn.edu.cuit.icloud.constant.Result;
import cn.edu.cuit.icloud.dto.MessageDTO;
import cn.edu.cuit.icloud.exception.BaseException;
import cn.edu.cuit.icloud.service.CallService;
import cn.edu.cuit.icloud.service.impl.AdminServiceImpl;
import cn.edu.cuit.icloud.service.impl.CallServiceImpl;
import cn.edu.cuit.icloud.vo.TemplateVO;
import cn.edu.cuit.icloud.vo.UserVO;

/**
 * TODO
 * @author: Think
 * @since: 2020Äê5ÔÂ9ÈÕ
 */
@WebServlet("/ip")
public class NetworkServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	static Logger logger = Logger.getLogger(NetworkServlet.class);
	
	private CallService callService = null;
	
	private AdminServiceImpl adminService = null;
	
	public NetworkServlet() {
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
		
		resp.getWriter().write(dto.toString());
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
		try {
			if(Cmd.CREATE_IP_RANGE.equals(command)) {
				Object result = callService.callCommand(command, parameters);
				if(null != result) {
					cn.edu.cuit.icloud.call.ip.range.create.ResponseTags tags = (cn.edu.cuit.icloud.call.ip.range.create.ResponseTags)result;
					dto.setCode(Result.SUCCESS.getCode());
					dto.setMsg(Result.SUCCESS.getMsg());
					dto.setCount(0);
				}else {
					dto.setCode(Result.SERVER_INTERNAL.getCode());
					dto.setMsg(Result.SERVER_INTERNAL.getMsg());
					dto.setCount(0);
				}
			}else if(Cmd.CREATE_NETWORK.equals(command)) {
				Object result = callService.callCommand(command, parameters);
				if(null != result) {
					cn.edu.cuit.icloud.call.ip.network.ResponseTags tags = (cn.edu.cuit.icloud.call.ip.network.ResponseTags)result;
					dto.setCode(Result.SUCCESS.getCode());
					dto.setMsg(Result.SUCCESS.getMsg());
					dto.setCount(0);
				}else {
					dto.setCode(Result.SERVER_INTERNAL.getCode());
					dto.setMsg(Result.SERVER_INTERNAL.getMsg());
					dto.setCount(0);
				}
			}else if(Cmd.DELETE_IP_RANGE.equals(command)) {
				Object result = callService.callCommand(command, parameters);
				if(null != result) {
					cn.edu.cuit.icloud.call.ip.range.delete.ResponseTags tags = (cn.edu.cuit.icloud.call.ip.range.delete.ResponseTags)result;
					dto.setCode(Result.SUCCESS.getCode());
					dto.setMsg(Result.SUCCESS.getMsg());
					dto.setCount(0);
				}else {
					dto.setCode(Result.SERVER_INTERNAL.getCode());
					dto.setMsg(Result.SERVER_INTERNAL.getMsg());
					dto.setCount(0);
				}
			}else if(Cmd.LIST_IP_RANGE.equals(command)) {
				Object result = callService.callCommand(command, parameters);
				if(null != result) {
					cn.edu.cuit.icloud.call.ip.range.list.ResponseTags tags = (cn.edu.cuit.icloud.call.ip.range.list.ResponseTags)result;
					dto.setCode(Result.SUCCESS.getCode());
					dto.setMsg(Result.SUCCESS.getMsg());
					dto.setCount(0);
				}else {
					dto.setCode(Result.SERVER_INTERNAL.getCode());
					dto.setMsg(Result.SERVER_INTERNAL.getMsg());
					dto.setCount(0);
				}
			}else if(Cmd.UPDATE_IP_RANGE.equals(command)) {
				Object result = callService.callCommand(command, parameters);
				if(null != result) {
					cn.edu.cuit.icloud.call.ip.range.update.ResponseTags tags = (cn.edu.cuit.icloud.call.ip.range.update.ResponseTags)result;
					dto.setCode(Result.SUCCESS.getCode());
					dto.setMsg(Result.SUCCESS.getMsg());
					dto.setCount(0);
				}else {
					dto.setCode(Result.SERVER_INTERNAL.getCode());
					dto.setMsg(Result.SERVER_INTERNAL.getMsg());
					dto.setCount(0);
				}
			}
		
		} catch (Exception e) {
			logger.error(command+"£º"+e.getMessage());
			dto.setCode(Result.SERVER_INTERNAL.getCode());
			dto.setMsg(Result.SERVER_INTERNAL.getMsg());
			dto.setCount(0);
		}
		
		
		resp.getWriter().write(dto.toString());
	}
	
}
