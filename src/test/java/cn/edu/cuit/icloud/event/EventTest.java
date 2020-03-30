package cn.edu.cuit.icloud.event;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.gson.Gson;

import cn.edu.cuit.icloud.constant.Result;
import cn.edu.cuit.icloud.dto.MessageDTO;
import cn.edu.cuit.icloud.pojo.Event;
import cn.edu.cuit.icloud.service.impl.TeacherServiceImpl;
import cn.edu.cuit.icloud.vo.EventVO;

/**
 * TODO
 * @date: 2020年3月26日
 * @author: flfan
 */
public class EventTest {
	
	@Test
	public void testListEvent(){
		TeacherServiceImpl teacherService = new TeacherServiceImpl();
		MessageDTO dto = new MessageDTO();
		Gson gson = new Gson();
		List<Event> allEvents = teacherService.getAllEvents();
		if(null != allEvents){
			dto.setData(allEvents);
			dto.setCode(Result.SUCCESS.getCode());
			dto.setCount(allEvents.size());
			dto.setMsg("加载事件完成！");
		}else{
			dto.setCode(Result.FAILURE.getCode());
			dto.setCount(0);
			dto.setMsg("加载事件失败！");
		}
		String json = gson.toJson(dto);
		System.out.println(json);
	}
	@Test
	public void testAddEvent(){
		TeacherServiceImpl teacherService = new TeacherServiceImpl();
		MessageDTO dto = new MessageDTO();
		Gson gson = new Gson();
		EventVO eventVO = new EventVO();
		eventVO.setEvent("conference");
		eventVO.setStartTime("2020-03-27T00:00:00");
		eventVO.setEndTime("2020-03-28T00:00:00");
		boolean isSuccess = teacherService.addEvent(eventVO);
		if(isSuccess){
			dto.setCode(Result.SUCCESS.getCode());
			dto.setMsg("添加事件成功！");
			dto.setCount(1);
		}else{
			dto.setCode(Result.FAILURE.getCode());
			dto.setMsg("添加事件失败！");
			dto.setCount(0);
		}
		String json = gson.toJson(dto);
		System.out.println(json);
		
		
		
		
	}
	
	@Test
	public void testEventVO(){
		
		EventVO eventVO = new EventVO();
		
		System.out.println(eventVO);
		
		
		
		
	}
}
