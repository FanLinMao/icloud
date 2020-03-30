package cn.edu.cuit.icloud.action.teacher;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import cn.edu.cuit.icloud.constant.Result;
import cn.edu.cuit.icloud.dto.MessageDTO;
import cn.edu.cuit.icloud.pojo.Event;
import cn.edu.cuit.icloud.pojo.User;
import cn.edu.cuit.icloud.service.impl.TeacherServiceImpl;
import cn.edu.cuit.icloud.vo.ArrangeVO;
import cn.edu.cuit.icloud.vo.EventVO;
import cn.edu.cuit.icloud.vo.UserVO;

/**
 * 预约资源：事件dateGridView
 * @date: 2020年3月23日
 * @author: flfan
 */
@WebServlet("/event")
public class EventsServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(EventsServlet.class);
	
	private TeacherServiceImpl teacherService = null;
	
	public EventsServlet(){
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
		if("addEvent".equals(action)){
			String form1 = req.getParameter("form1");
			String form2 = req.getParameter("form2");
			String form3 = req.getParameter("form3");
			String uuid = UUID.randomUUID().toString();
			EventVO eventVO = gson.fromJson(form1, EventVO.class);
			eventVO.setEventId(uuid);
			ArrangeVO arrage = gson.fromJson(form2, ArrangeVO.class);
			ArrangeVO arrage2 = gson.fromJson(form3, ArrangeVO.class);
			String d1 = eventVO.getStartTime().split("T")[0];
			String d2 = eventVO.getEndTime().split("T")[0];
			if(d1.equals(d2)){
				arrage.setDate(eventVO.getStartTime()+"--"+eventVO.getEndTime().split("T")[1]);
			}else{
				arrage.setDate(eventVO.getStartTime()+"--"+eventVO.getEndTime());
			}
			arrage.setEventId(uuid);
			arrage.setTeacher(arrage2.getTeacher());
			arrage.setCourse(arrage2.getCourse());
			arrage.setTemplate(arrage2.getTemplate());
			//需要添加user信息
			UserVO user = (UserVO)req.getSession().getAttribute("vo");
			eventVO.setUser(user.getUser());
			boolean addEventSuccess = teacherService.addEvent(eventVO);
			boolean addArrangeSuccesss = teacherService.addArrange(arrage);
			if(addEventSuccess && addArrangeSuccesss){
				dto.setCode(Result.SUCCESS.getCode());
				dto.setMsg("添加事件成功！");
				dto.setCount(1);
				logger.info("添加事件成功！");
			}else{
				dto.setCode(Result.FAILURE.getCode());
				dto.setMsg("添加事件失败！");
				dto.setCount(0);
				logger.info("添加事件失败！");
			}
			/*String title = req.getParameter("event");
			String start = req.getParameter("startTime");
			String end = req.getParameter("endTime");
			
			EventVO eventVO = new EventVO();
			eventVO.setTitle(title);
			eventVO.setStart(start);
			eventVO.setEnd(end);
			boolean isSuccess = teacherService.addEvent(eventVO);
			if(isSuccess){
				dto.setCode(Result.SUCCESS.getCode());
				dto.setMsg("添加事件成功！");
				dto.setCount(1);
				logger.info("添加事件成功！");
			}else{
				dto.setCode(Result.FAILURE.getCode());
				dto.setMsg("添加事件失败！");
				dto.setCount(0);
				logger.info("添加事件失败！");
			}*/
		}else if("removeEvent".equals(action)){
			
		}else if("listEvent".equals(action)){
			List<Event> allEvents = teacherService.getAllEvents();
			if(null != allEvents){
				dto.setData(allEvents);
				dto.setCode(Result.SUCCESS.getCode());
				dto.setCount(allEvents.size());
				dto.setMsg("加载事件完成！");
				logger.info("加载事件完成！");
			}else{
				dto.setCode(Result.FAILURE.getCode());
				dto.setCount(0);
				dto.setMsg("加载事件失败！");
				logger.info("加载事件失败！");
			}
		}
		
		String json = gson.toJson(dto);
		resp.getWriter().write(json);
	}

}
