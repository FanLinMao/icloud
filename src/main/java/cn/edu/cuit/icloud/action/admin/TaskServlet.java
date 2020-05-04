package cn.edu.cuit.icloud.action.admin;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import cn.edu.cuit.icloud.constant.Result;
import cn.edu.cuit.icloud.dto.MessageDTO;
import cn.edu.cuit.icloud.service.impl.AdminServiceImpl;
import cn.edu.cuit.icloud.vo.TaskVO;

/**
 * TODO
 * @author: Think
 * @since: 2020年4月26日
 */
@WebServlet("/task")
public class TaskServlet extends HttpServlet{
	
	static Logger logger = Logger.getLogger(TaskServlet.class);
	private static final long serialVersionUID = 1L;
	private AdminServiceImpl adminService = null;
	public TaskServlet() {
		adminService = new AdminServiceImpl();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json;charset=utf-8");
		MessageDTO dto = new MessageDTO();
		//开关监听
		int taskId = Integer.valueOf(req.getParameter("taskId"));
		int status = Integer.valueOf(req.getParameter("status"));
		if(adminService.updateStatus(taskId, status)) {
			dto.setData(null);
			dto.setCode(Result.SUCCESS.getCode());
			dto.setCount(1);
			dto.setMsg("操作成功");
			logger.info("修改状态成功！");
		}else {
			dto.setData(null);
			dto.setCode(Result.FAILURE.getCode());
			dto.setCount(1);
			dto.setMsg("操作失败");
			logger.info("修改状态失败！");
		}
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
		MessageDTO dto = new MessageDTO();
		String op = req.getParameter("op");
		if("list".equals(op)) {
			Gson gson = new Gson();
			List<TaskVO> tasks = adminService.findAllTasks();
			dto.setData(gson.toJson(tasks));
			dto.setCode(Result.SUCCESS.getCode());
			dto.setCount(1);
			dto.setMsg("查询所有定时任务成功！");
			logger.info("查询所有定时任务成功！");
			
		}else if("add".equals(op)) {
			String frequence = req.getParameter("frequence");
			String cycle = req.getParameter("cycle");
			String time = req.getParameter("time");
			String action = req.getParameter("action");
			String status = req.getParameter("status");
			TaskVO task = new TaskVO();
			if("daily".equals(frequence)) {
				task.setFrequence(frequence);
				task.setTime(time);
				task.setAction(action);
				task.setStatus(Integer.valueOf(status));
			}else {
				task.setFrequence(frequence);
				task.setCycle(cycle);
				task.setTime(time);
				task.setAction(action);
				task.setStatus(Integer.valueOf(status));
			}
			if(adminService.addTask(task)) {
				dto.setData(null);
				dto.setCode(Result.SUCCESS.getCode());
				dto.setCount(1);
				dto.setMsg("添加定时任务成功！");
				logger.info("添加定时任务成功！");
			} else {
				dto.setData(null);
				dto.setCode(Result.FAILURE.getCode());
				dto.setCount(1);
				dto.setMsg("添加定时任务失败！");
				logger.info("添加定时任务失败！");
			}
			
		}else if("del".equals(op)) {
			String taskIds = req.getParameter("ids");
			String[] ids = taskIds.split(",");
			if(adminService.batchDeleteTask(taskIds)) {
				dto.setData(null);
				dto.setCode(Result.SUCCESS.getCode());
				dto.setCount(ids.length);
				dto.setMsg("删除定时任务成功！");
				logger.info("删除定时任务成功！");
			}else {
				dto.setData(null);
				dto.setCode(Result.FAILURE.getCode());
				dto.setCount(ids.length);
				dto.setMsg("删除定时任务失败！");
				logger.info("删除定时任务失败！");
			}
		}else if("edit".equals(op)) {
			String taskId = req.getParameter("taskId");
			String frequence = req.getParameter("frequence");
			String cycle = req.getParameter("cycle");
			String time = req.getParameter("time");
			String action = req.getParameter("action");
			String status = req.getParameter("status");
			TaskVO task = new TaskVO();
			if("daily".equals(frequence)) {
				task.setTaskId(Integer.valueOf(taskId));
				task.setFrequence(frequence);
				task.setTime(time);
				task.setAction(action);
				task.setStatus(Integer.valueOf(status));
			}else {
				task.setTaskId(Integer.valueOf(taskId));
				task.setFrequence(frequence);
				task.setCycle(cycle);
				task.setTime(time);
				task.setAction(action);
				task.setStatus(Integer.valueOf(status));
			}
			if(adminService.editTask(task)) {
				dto.setData(null);
				dto.setCode(Result.SUCCESS.getCode());
				dto.setCount(1);
				dto.setMsg("修改定时任务成功！");
				logger.info("修改定时任务成功！");
			} else {
				dto.setData(null);
				dto.setCode(Result.FAILURE.getCode());
				dto.setCount(1);
				dto.setMsg("修改定时任务失败！");
				logger.info("修改定时任务失败！");
			}
		}
		resp.getWriter().write(dto.toString());
	}
	
}
