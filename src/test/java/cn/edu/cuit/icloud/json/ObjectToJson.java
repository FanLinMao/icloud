package cn.edu.cuit.icloud.json;

import java.time.LocalDateTime;

import org.junit.Test;

import com.google.gson.Gson;

import cn.edu.cuit.icloud.constant.Result;
import cn.edu.cuit.icloud.dto.MessageDTO;
import cn.edu.cuit.icloud.vo.TaskVO;

/**
 * TODO
 * @date: 2020年3月17日
 * @author: flfan
 */
public class ObjectToJson {
	
	@Test
	public void testObjectToJson(){
		Gson gson = new Gson();
		MessageDTO dto = new MessageDTO();
		dto.setCode(Result.FAILURE.getCode());
		dto.setCount(0);
		dto.setMsg(Result.FAILURE.getMsg());
		String json = gson.toJson(dto);
		System.out.println(json);
		System.out.println(dto.toString());
		TaskVO taskVO = new TaskVO();
		taskVO.setAction("关机");
		taskVO.setFrequence("每天");
		taskVO.setStatus(1);
		taskVO.setTaskId(1);
		taskVO.setTime(LocalDateTime.now().toString());
		System.out.println(new Gson().toJson(taskVO));
	}
	
}
