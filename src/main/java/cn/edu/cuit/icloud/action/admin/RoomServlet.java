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
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cn.edu.cuit.icloud.call.template.create.ResponseTags;
import cn.edu.cuit.icloud.constant.Cmd;
import cn.edu.cuit.icloud.constant.Result;
import cn.edu.cuit.icloud.dto.MessageDTO;
import cn.edu.cuit.icloud.exception.BaseException;
import cn.edu.cuit.icloud.service.CallService;
import cn.edu.cuit.icloud.service.impl.AdminServiceImpl;
import cn.edu.cuit.icloud.service.impl.CallServiceImpl;
import cn.edu.cuit.icloud.vo.RoomVO;
import cn.edu.cuit.icloud.vo.TemplateVO;
import cn.edu.cuit.icloud.vo.UserVO;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月9日
 */
@WebServlet("/room")
public class RoomServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	static Logger logger = Logger.getLogger(RoomServlet.class);
	
	private AdminServiceImpl adminService = null;
	
	public RoomServlet() {
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
		if("list".equals(command)) {
			List<RoomVO> listRooms = adminService.listRooms();
			if(null != listRooms && !listRooms.isEmpty()) {
				dto.setCode(Result.SUCCESS.getCode());
				dto.setMsg(Result.SUCCESS.getMsg());
				dto.setCount(listRooms.size());
				dto.setData(gson.toJson(listRooms));
			}else {
				dto.setCode(Result.FAILURE.getCode());
				dto.setMsg(Result.FAILURE.getMsg());
				dto.setCount(0);
			}
			
		}else if("add".equals(command)) {
			JsonObject json = new JsonParser().parse(parameters).getAsJsonObject();
			RoomVO vo = new RoomVO();
			vo.setRoom(json.get("room").getAsString());
			vo.setEquipment(json.get("equipment").getAsString());
			vo.setCourse(json.get("course").getAsString());
			vo.setUserCount(json.get("userCount").getAsInt());
			
			if(adminService.addRoom(vo)) {
				dto.setCode(Result.SUCCESS.getCode());
				dto.setMsg("录入机房成功！");
				dto.setCount(1);
				dto.setData(gson.toJson(vo));
				logger.info("录入机房成功！");
			}else {
				dto.setCode(Result.FAILURE.getCode());
				dto.setMsg("录入机房失败！");
				dto.setCount(0);
				dto.setData(null);
				logger.info("录入机房失败！");
			}
			
		}else if("edit".equals(command)) {
			JsonObject json = new JsonParser().parse(parameters).getAsJsonObject();
			RoomVO vo = new RoomVO();
			vo.setId(json.get("id").getAsInt());
			vo.setRoom(json.get("room").getAsString());
			vo.setEquipment(json.get("equipment").getAsString());
			vo.setCourse(json.get("course").getAsString());
			vo.setUserCount(json.get("userCount").getAsInt());
			if(adminService.updateRoom(vo)) {
				dto.setCode(Result.SUCCESS.getCode());
				dto.setMsg("修改机房成功！");
				dto.setCount(1);
				dto.setData(gson.toJson(vo));
				logger.info("修改机房成功！");
			}else {
				dto.setCode(Result.FAILURE.getCode());
				dto.setMsg("修改机房失败！");
				dto.setCount(0);
				dto.setData(null);
				logger.info("修改机房失败！");
			}
		}else if("del".equals(command)) {
			String ids = req.getParameter("ids");
			if(adminService.deleteRoomsByIds(ids)) {
				dto.setCode(Result.SUCCESS.getCode());
				dto.setMsg("删除机房成功！");
				dto.setCount(1);
				dto.setData(gson.toJson(ids));
				logger.info("删除机房成功！");
			}else {
				dto.setCode(Result.FAILURE.getCode());
				dto.setMsg("删除机房失败！");
				dto.setCount(0);
				dto.setData(null);
				logger.info("删除机房失败！");
			}
		}
		
		
		resp.getWriter().write(dto.toString());
	}
	
}
