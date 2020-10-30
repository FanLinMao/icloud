package cn.edu.cuit.icloud.action.teacher;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

import cn.edu.cuit.icloud.constant.Result;
import cn.edu.cuit.icloud.dto.MessageDTO;
import cn.edu.cuit.icloud.service.impl.TeacherServiceImpl;
import cn.edu.cuit.icloud.vo.ArrangeVO;

/**
 * TODO
 * @date: 2020年3月26日
 * @author: flfan
 */
@WebServlet("/arrange")
public class ArrangeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	static Logger logger = Logger.getLogger(ArrangeServlet.class);
	
	TeacherServiceImpl teacherService = null;
	
	public ArrangeServlet(){
		teacherService = new TeacherServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		String action = req.getParameter("action");
		MessageDTO dto = new MessageDTO();
		Gson gson = new Gson();
		if("list".equals(action)){
			List<ArrangeVO> allArranges = teacherService.getAllArranges();
			if(null != allArranges && !allArranges.isEmpty()){
				dto.setData(allArranges);
				dto.setCode(Result.SUCCESS.getCode());
				dto.setCount(allArranges.size());
				dto.setMsg("上机安排信息");
				logger.info("加载上机安排事件完成！");
			}else{
				dto.setCode(Result.FAILURE.getCode());
				dto.setCount(0);
				dto.setMsg("获取上机安排信息失败！");
				logger.info("加载上机安排事件失败！");
			}
		}else if("del".equals(action)){
			
		}else if("sure".equals(action)){
			
		}else if("search".equals(action)){
			String teacher = req.getParameter("teacher").trim();
			String course = req.getParameter("course").trim();
			List<ArrangeVO> allArranges = teacherService.getAllArranges();
			List<ArrangeVO> afterFilter = null;
			if(null != allArranges && !allArranges.isEmpty()){
				afterFilter = allArranges;
				if(StringUtils.isNotEmpty(teacher) && !StringUtils.isNotEmpty(course)) {
					afterFilter = allArranges.stream().filter(s->{
						return teacher.equals(s.getTeacher());
					}).collect(Collectors.toList());
				}
				if(!StringUtils.isNotEmpty(teacher) && StringUtils.isNotEmpty(course)) {
					afterFilter = allArranges.stream().filter(s->{
						return course.toLowerCase().equals(s.getCourse().toLowerCase()) || s.getCourse().toLowerCase().contains(course.toLowerCase());
					}).collect(Collectors.toList());
				}
				if(StringUtils.isNotEmpty(teacher) && StringUtils.isNotEmpty(course)) {
					afterFilter = allArranges.stream().filter(s->{
						return teacher.equals(s.getTeacher()) && (course.toLowerCase().equals(s.getCourse().toLowerCase()) || s.getCourse().toLowerCase().contains(course.toLowerCase()));
					}).collect(Collectors.toList());
				}
				dto.setData(afterFilter);
				dto.setCode(Result.SUCCESS.getCode());
				dto.setCount(allArranges.size());
				dto.setMsg("上机安排信息");
				logger.info("加载上机安排事件完成！");
			}else{
				dto.setCode(Result.FAILURE.getCode());
				dto.setCount(0);
				dto.setMsg("获取上机安排信息失败！");
				logger.info("加载上机安排事件失败！");
			}
		}
		
		String json = gson.toJson(dto);
		resp.getWriter().write(json);
	}
	
}
