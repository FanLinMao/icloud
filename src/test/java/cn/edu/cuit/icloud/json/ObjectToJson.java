package cn.edu.cuit.icloud.json;

import org.junit.Test;

import com.google.gson.Gson;

import cn.edu.cuit.icloud.constant.Result;
import cn.edu.cuit.icloud.dto.MessageDTO;

/**
 * TODO
 * @date: 2020Äê3ÔÂ17ÈÕ
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
	}
	
}
