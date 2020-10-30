package cn.edu.cuit.icloud.action.admin;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import cn.edu.cuit.icloud.constant.Result;
import cn.edu.cuit.icloud.dto.MessageDTO;
import cn.edu.cuit.icloud.scheduler.BootUp;
import cn.edu.cuit.icloud.scheduler.ShutDown;
import cn.edu.cuit.icloud.scheduler.TaskManager;
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
		TaskVO task = adminService.findTaskById(taskId);
		if(adminService.updateStatus(taskId, status)) {
			dto.setData(null);
			dto.setCode(Result.SUCCESS.getCode());
			dto.setCount(1);
			if(null != task) {
				String cron = "";
				String[] split = task.getTime().split(":");
				String action = task.getAction();
				if("daily".equals(task.getFrequence())) {
					//生成cron表达式
					cron = split[2]+" "+split[1]+" "+split[0]+" "+"*"+" "+"*"+" "+"?";
				}else {
					String cycle = task.getCycle();
					cron = split[2]+" "+split[1]+" "+split[0]+" "+"?"+" "+"*"+" "+cycle;
				}
				//操作定时任务
				if(status == 1) {
					TaskManager.addJob(task.getJobName(), task.getJobGroupName(), task.getTriggerName(), task.getTriggerGroupName(), action, cron);
				}else {
					TaskManager.removeJob(task.getJobName(), task.getJobGroupName(), task.getTriggerName(), task.getTriggerGroupName());
				}
			}
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
			String cron = "";
			String[] split = time.split(":");
			TaskVO task = new TaskVO();
			String jobName = UUID.randomUUID().toString();
			String triggerName = UUID.randomUUID().toString();
			String jobGroupName = "";
			String triggerGroupName = "";
			if("1".equals(action)) {
				jobGroupName = "openJobGroup";
				triggerGroupName = "openTriggerGroup";
			}else {
				jobGroupName = "closeJobGroup";
				triggerGroupName = "closeTriggerGroup";
			}
			task.setTime(time);
			task.setAction(action);
			task.setStatus(Integer.valueOf(status));
			task.setJobName(jobName);
			task.setJobGroupName(jobGroupName);
			task.setTriggerName(triggerName);
			task.setTriggerGroupName(triggerGroupName);
			if("daily".equals(frequence)) {
				task.setFrequence(frequence);
				//生成cron表达式
				cron = split[2]+" "+split[1]+" "+split[0]+" "+"*"+" "+"*"+" "+"?";
			}else {
				task.setFrequence(frequence);
				task.setCycle(cycle);
				cron = split[2]+" "+split[1]+" "+split[0]+" "+"?"+" "+"*"+" "+cycle;
			}
			if(adminService.addTask(task)) {
				dto.setData(null);
				dto.setCode(Result.SUCCESS.getCode());
				dto.setCount(1);
				//获取状态，添加定时任务
				if(Integer.valueOf(status) == 1) {
					TaskManager.addJob(jobName, jobGroupName, triggerName, triggerGroupName, action, cron);
				}
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
			List<TaskVO> tasks = adminService.findTasksByIds(taskIds);
			if(null != tasks && !tasks.isEmpty()) {
				tasks.stream().parallel().forEach(s->{
					TaskManager.removeJob(s.getJobName(), s.getJobGroupName(), s.getTriggerName(), s.getTriggerGroupName());
				});
			}
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
			String jobName = req.getParameter("jobName");
			String jobGroupName = req.getParameter("jobGroupName");
			String triggerName = req.getParameter("triggerName");
			String triggerGroupName = req.getParameter("triggerGroupName");
			String cron = "";
			String[] split = time.split(":");
			TaskVO task = new TaskVO();
			task.setTime(time);
			task.setAction(action);
			task.setStatus(Integer.valueOf(status));
			task.setTaskId(Integer.valueOf(taskId));
			if("daily".equals(frequence)) {
				task.setFrequence(frequence);
				task.setCycle(" ");
				//生成cron表达式
				cron = split[2]+" "+split[1]+" "+split[0]+" "+"*"+" "+"*"+" "+"?";
			}else {
				task.setFrequence(frequence);
				task.setCycle(cycle);
				cron = split[2]+" "+split[1]+" "+split[0]+" "+"?"+" "+"*"+" "+cycle;
			}
			if(adminService.editTask(task)) {
				dto.setData(null);
				dto.setCode(Result.SUCCESS.getCode());
				dto.setCount(1);
				if(Integer.valueOf(status) == 1) {
					TaskManager.modifyJobTime(jobName, jobGroupName, triggerName, triggerGroupName, cron);
				}
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
	
	private String getWeek(String date){
		LocalDate parse = LocalDate.parse(date);
		DayOfWeek dayOfWeek = parse.getDayOfWeek();
		String name = dayOfWeek.name();
		return name;
	}
	
}
