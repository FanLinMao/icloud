package cn.edu.cuit.icloud.call;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.reflections.Reflections;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cn.edu.cuit.icloud.annotation.Command;
import cn.edu.cuit.icloud.annotation.ResultTags;
import cn.edu.cuit.icloud.call.iso.list.ResponseTags;
import cn.edu.cuit.icloud.call.iso.register.RequestParameters;
import cn.edu.cuit.icloud.constant.Cmd;
import cn.edu.cuit.icloud.constant.Result;
import cn.edu.cuit.icloud.dto.MessageDTO;
import cn.edu.cuit.icloud.scheduler.BootUp;
import cn.edu.cuit.icloud.utils.HttpClientUtil;
import cn.edu.cuit.icloud.utils.UrlUtil;

/**
 * TODO
 * @author: Think
 * @since: 2020Äê5ÔÂ5ÈÕ
 */
public class RefelctionTest {
	
	@Test
	public void testScanAnotation() throws IllegalArgumentException, IllegalAccessException {
		String pkg = "cn.edu.cuit.icloud.call.*";
		Reflections reflections = new Reflections(pkg);
		Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(Command.class);
		for (Class<?> clazz : typesAnnotatedWith) {
			Command command = clazz.getAnnotation(Command.class);
			System.out.println(command.value());
			
		}
	}
	
	@Test
	public void testReflectGetAttribute() throws IllegalArgumentException, IllegalAccessException {
		String pkg = "cn.edu.cuit.icloud.call.*";
		RequestParameters params = new RequestParameters();
		
		Gson gson = new Gson();
		String json = gson.toJson(params);
		Reflections reflections = new Reflections(pkg);
		Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(Command.class);
		for (Class<?> clazz : typesAnnotatedWith) {
			Command command = clazz.getAnnotation(Command.class);
			if(Cmd.LIST_TEMPLATES.equals(command.value())) {
				Object fromJson = gson.fromJson(json, clazz);
				Field[] declaredFields = clazz.getDeclaredFields();
				for (Field field : declaredFields) {
					field.setAccessible(true);
					Object obj = field.get(fromJson);
					if(obj != null)
					System.out.println(field.getName()+"->"+obj);
					
				}
			}
			
			
		}
	}
	
	@Test
	public void testReflectRequestCommand() throws IllegalArgumentException, IllegalAccessException {
		String pkg = "cn.edu.cuit.icloud.call.*";
		RequestParameters params = new RequestParameters();
		
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		Gson gson = new Gson();
		MessageDTO dto = new MessageDTO();
		String json = gson.toJson(params);
		Reflections reflections = new Reflections(pkg);
		Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(Command.class);
		for (Class<?> clazz : typesAnnotatedWith) {
			Command command = clazz.getAnnotation(Command.class);
			if(Cmd.LIST_ISOS.equals(command.value())) {
				Object fromJson = gson.fromJson(json, clazz);
				Field[] declaredFields = clazz.getDeclaredFields();
				for (Field field : declaredFields) {
					field.setAccessible(true);
					Object obj = field.get(fromJson);
					if(obj != null) {
						hashMap.put(field.getName(), obj);
					}
				}
				hashMap.put("command", Cmd.LIST_ISOS);
				break;
			}
		}
		Set<Class<?>> resultTagsAnnotations = reflections.getTypesAnnotatedWith(ResultTags.class);
		for (Class<?> clazz : resultTagsAnnotations) {
			ResultTags resultTags = clazz.getAnnotation(ResultTags.class);
			if(Cmd.LIST_ISOS.equals(resultTags.value())) {
				String httpRequestUrl = UrlUtil.createUrl(hashMap);
				HttpClientUtil httpClient = HttpClientUtil.getInstance();
				String reponseContent = httpClient.sendHttpGet(httpRequestUrl);
				System.out.println(reponseContent);
				//System.out.println(reponseContent);
				//Object data = gson.fromJson(reponseContent, clazz);
			}
		}
		
	}
	
	@Test
	public void testCreateTemplate() throws Exception {
		
		String json = call("listEvents",null);
		JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
		JsonObject subObj = obj.get("listeventsresponse").getAsJsonObject();
		JsonArray result = subObj.get("event").getAsJsonArray();
		List<cn.edu.cuit.icloud.call.event.list.ResponseTags> list = new ArrayList<cn.edu.cuit.icloud.call.event.list.ResponseTags>();
		Gson gson = new Gson();
		result.forEach(o->{
			cn.edu.cuit.icloud.call.event.list.ResponseTags res = gson.fromJson(o, cn.edu.cuit.icloud.call.event.list.ResponseTags.class);
			list.add(res);
			
		});
		list.forEach(s->{
			System.out.println(s.getId()+"->"+s.getLevel());
		});
		
	}
	
	private String call(String command, String jsonRequestParameters) throws Exception {
		String pkg = "cn.edu.cuit.icloud.call.*";
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		Gson gson = new Gson();
		Reflections reflections = new Reflections(pkg);
		Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(Command.class);
		for (Class<?> clazz : typesAnnotatedWith) {
			Command cmdAnno = clazz.getAnnotation(Command.class);
			if(command.equals(cmdAnno.value())) {
				Object fromJson = gson.fromJson(jsonRequestParameters, clazz);
				if(null != fromJson) {
					Field[] declaredFields = clazz.getDeclaredFields();
					for (Field field : declaredFields) {
						field.setAccessible(true);
						Object obj = field.get(fromJson);
						if(obj != null) {
							hashMap.put(field.getName(), obj);
						}
					}
				}
				hashMap.put("command", command);
				break;
			}
		}
		Set<Class<?>> resultTagsAnnotations = reflections.getTypesAnnotatedWith(ResultTags.class);
		for (Class<?> clazz : resultTagsAnnotations) {
			ResultTags resultTags = clazz.getAnnotation(ResultTags.class);
			if(command.equals(resultTags.value())) {
				String httpRequestUrl = UrlUtil.createUrl(hashMap);
				HttpClientUtil httpClient = HttpClientUtil.getInstance();
				String reponseContent = httpClient.sendHttpGet(httpRequestUrl);
				
				return reponseContent;
			}
		}
		return null;
	}
	
	@Test
	public void testJsonType() {
		Gson gson = new Gson();
		Object fromJson = gson.fromJson("", BootUp.class);
		System.out.println(fromJson);
	}
	
}
