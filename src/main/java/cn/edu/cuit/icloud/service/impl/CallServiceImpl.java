package cn.edu.cuit.icloud.service.impl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.reflections.Reflections;

import com.google.gson.Gson;

import cn.edu.cuit.icloud.annotation.Command;
import cn.edu.cuit.icloud.annotation.ResultTags;
import cn.edu.cuit.icloud.common.DBCon;
import cn.edu.cuit.icloud.service.CallService;
import cn.edu.cuit.icloud.utils.HttpClientUtil;
import cn.edu.cuit.icloud.utils.UrlUtil;

/**
 * TODO
 * @author: Think
 * @since: 2020Äê5ÔÂ9ÈÕ
 */
public class CallServiceImpl implements CallService {

	static Logger logger = Logger.getLogger(CallServiceImpl.class);
	
	@Override
	public Object callCommand(String command, String jsonRequestParameters) throws Exception {
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
				logger.info("CloudStack API Request ==>>"+httpRequestUrl);
				HttpClientUtil httpClient = HttpClientUtil.getInstance();
				String reponseContent = httpClient.sendHttpGet(httpRequestUrl);
				logger.info("CloudStack API Response ==>>"+reponseContent);
				Object result = gson.fromJson(reponseContent, clazz);
				return result;
			}
		}
		return null;
	}

	@Override
	public boolean insertDB(String sql, Object[] params) {
		DBCon dbc = new DBCon();
		int status = 0;
		if(StringUtils.isNotEmpty(sql)) {
			status = dbc.doUpdate(sql, params);
		}
		dbc.close();
		return status>0;
	}

	
	@Override
	public String callCommand2(String command, String jsonRequestParameters) throws Exception {
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
				logger.info("CloudStack API Request ==>>"+httpRequestUrl);
				HttpClientUtil httpClient = HttpClientUtil.getInstance();
				String reponseContent = httpClient.sendHttpGet(httpRequestUrl);
				logger.info("CloudStack API Response ==>>"+reponseContent);
				return reponseContent;
			}
		}
		return null;
	}

}
