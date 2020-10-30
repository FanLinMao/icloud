package cn.edu.cuit.icloud.action.admin;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
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
import cn.edu.cuit.icloud.vo.TemplateVO;
import cn.edu.cuit.icloud.vo.UserVO;

/**
 * 管理员 事件管理
 * @author: Think
 * @since: 2020年5月9日
 */
@WebServlet("/events")
public class EventServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	static Logger logger = Logger.getLogger(EventServlet.class);
	
	private CallService callService = null;
	
	private AdminServiceImpl adminService = null;
	
	public EventServlet() {
		adminService = new AdminServiceImpl();
		callService = new CallServiceImpl();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		String parameter = req.getParameter("action");
		MessageDTO dto = new MessageDTO();
		Gson gson = new Gson();
		resp.getWriter().write(dto.toString());*/
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
		try {
			if(Cmd.LIST_EVENTS.equals(command)) {
				String json = callService.callCommand2(command, parameters);
				JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
				JsonObject subObj = obj.get("listeventsresponse").getAsJsonObject();
				JsonArray result = subObj.get("event").getAsJsonArray();
				List<cn.edu.cuit.icloud.call.event.list.ResponseTags> list = new ArrayList<cn.edu.cuit.icloud.call.event.list.ResponseTags>();
				result.forEach(o->{
					cn.edu.cuit.icloud.call.event.list.ResponseTags res = gson.fromJson(o, cn.edu.cuit.icloud.call.event.list.ResponseTags.class);
					list.add(res);
					
				});
				if(null != list) {
					//前端的消息
					dto.setCode(Result.SUCCESS.getCode());
					dto.setMsg(Result.SUCCESS.getMsg());
					dto.setCount(list.size());
					dto.setData(gson.toJson(list));
				}else {
					dto.setCode(Result.SERVER_INTERNAL.getCode());
					dto.setMsg(Result.SERVER_INTERNAL.getMsg());
					dto.setCount(0);
				}
				 
				
			}else if(Cmd.LIST_EVENT_TYPES.equals(command)) {
				Object result = callService.callCommand(command, parameters);
				if(null != result) {
					cn.edu.cuit.icloud.call.event.listtype.ResponseTags tags = (cn.edu.cuit.icloud.call.event.listtype.ResponseTags)result;
					//前端的消息
					dto.setCode(Result.SUCCESS.getCode());
					dto.setMsg(Result.SUCCESS.getMsg());
					dto.setCount(0);
				}else {
					dto.setCode(Result.SERVER_INTERNAL.getCode());
					dto.setMsg(Result.SERVER_INTERNAL.getMsg());
					dto.setCount(0);
				}
				
			}else if(Cmd.DELETE_EVENTS.equals(command)) {
				Object result = callService.callCommand(command, parameters);
				if(null != result) {
					cn.edu.cuit.icloud.call.event.delete.ResponseTags tags = (cn.edu.cuit.icloud.call.event.delete.ResponseTags)result;
					//前端的消息
					dto.setCode(Result.SUCCESS.getCode());
					dto.setMsg(Result.SUCCESS.getMsg());
					dto.setCount(0);
				}else {
					dto.setCode(Result.SERVER_INTERNAL.getCode());
					dto.setMsg(Result.SERVER_INTERNAL.getMsg());
					dto.setCount(0);
				}
			}else if(Cmd.ARCHIVE_EVENTS.equals(command)) {
				Object result = callService.callCommand(command, parameters);
				if(null != result) {
					cn.edu.cuit.icloud.call.event.archive.ResponseTags tags = (cn.edu.cuit.icloud.call.event.archive.ResponseTags)result;
					//前端的消息
					dto.setCode(Result.SUCCESS.getCode());
					dto.setMsg(Result.SUCCESS.getMsg());
					dto.setCount(0);
				}else {
					dto.setCode(Result.SERVER_INTERNAL.getCode());
					dto.setMsg(Result.SERVER_INTERNAL.getMsg());
					dto.setCount(0);
				}
			}else if("search".equals(command)) {
				
				String start = req.getParameter("start");
				String end = req.getParameter("end");
				//先查询到所有事件数据
				String json = callService.callCommand2(Cmd.LIST_EVENTS, parameters);
				JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
				JsonObject subObj = obj.get("listeventsresponse").getAsJsonObject();
				JsonArray result = subObj.get("event").getAsJsonArray();
				List<cn.edu.cuit.icloud.call.event.list.ResponseTags> list = new ArrayList<cn.edu.cuit.icloud.call.event.list.ResponseTags>();
				result.forEach(o->{
					cn.edu.cuit.icloud.call.event.list.ResponseTags res = gson.fromJson(o, cn.edu.cuit.icloud.call.event.list.ResponseTags.class);
					list.add(res);
					
				});
				if(null != list) {
					if(StringUtils.isNotEmpty(start) && StringUtils.isNotEmpty(end)) {
						//筛选数据
						List<cn.edu.cuit.icloud.call.event.list.ResponseTags> collect = list.stream().filter(o->{
							String created = o.getCreated().substring(0, 10);
							LocalDate time = LocalDate.parse(created);
							LocalDate s = LocalDate.parse(start);
							LocalDate e = LocalDate.parse(start);
							
							return (time.isAfter(s)||time.isEqual(s)) && (time.isEqual(e)||time.isBefore(e)) ;
						}).collect(Collectors.toList());
						
						dto.setCount(collect.size());
						dto.setData(gson.toJson(collect));
					}else {
						dto.setCount(list.size());
						dto.setData(gson.toJson(list));
					}
					dto.setCode(Result.SUCCESS.getCode());
					dto.setMsg(Result.SUCCESS.getMsg());
				}else {
					dto.setCode(Result.SERVER_INTERNAL.getCode());
					dto.setMsg(Result.SERVER_INTERNAL.getMsg());
					dto.setCount(0);
				}
			}
		
		}catch (Exception e) {
			logger.error(command+"："+e.getMessage());
			dto.setCode(Result.SERVER_INTERNAL.getCode());
			dto.setMsg(Result.SERVER_INTERNAL.getMsg());
			dto.setCount(0);
		}
		
		resp.getWriter().write(dto.toString());
	}
	
}
