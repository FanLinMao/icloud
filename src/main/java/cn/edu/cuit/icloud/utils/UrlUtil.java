package cn.edu.cuit.icloud.utils;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import cn.edu.cuit.icloud.exception.BaseException;

/**
 * CloudStack 请求URL工具
 * @date: 2020年4月2日
 * @author: flfan
 */
public class UrlUtil {
	private static Logger logger = Logger.getLogger(UrlUtil.class);
	private static Properties props = null;
	static{
		props = new Properties();
		try {
			props.load(UrlUtil.class.getResourceAsStream("/csapi.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private UrlUtil(){
		
	}
	
	/*public static String createUrl(String requestUrl,String parameterStr){
		
		return "";
	}*/
	
	public static String createUrl(Map<String,Object> params){
		return createUrl(props.getProperty("base_url")+props.getProperty("api_path"), params);
	}
	/**
	 * 生成完整的CS API URL
	 * @param requestUrl 完整基路径
	 * @param params 请求的参数
	 * @return
	 */
	public static String createUrl(String requestUrl, Map<String,Object> params){
		Objects.requireNonNull(params, "添加参数对象为空！");
		if(params.isEmpty()){
			throw new BaseException("10001","请求CloudStack API的参数为空！");
		}
		Map<String,Object> map = params;
		if(!(params instanceof java.util.SortedMap)){
			map = new TreeMap<String, Object>();
			map.putAll(params);
		}
		map.put("apiKey", props.getProperty("api_key"));
		map.put("response", "json");
		StringBuilder str = new StringBuilder();
		map.forEach((k,v)->{
			try {
				String encoded_v = URLEncoder.encode(String.valueOf(v), "UTF-8").replaceAll("\\+", "%20");
				str.append(k).append("=").append(encoded_v).append("&");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		str.replace(str.lastIndexOf("&"), str.length(), "");
		//生成签名
		String signature = "";
		try {
			signature = signRequest(str.toString().toLowerCase(), props.getProperty("secret_key"));
		} catch (Exception e) {
			logger.error("CloudStack API URL生成签名失败！");
			throw new BaseException(e.getMessage());
		}
		str.append("&signature=").append(signature);
		StringBuilder basePath = new StringBuilder(requestUrl);
		//?号特殊处理
		if(basePath.lastIndexOf("?") < 0){
			basePath.append("?");
		}
		int startQues = basePath.indexOf("?");
		int endQues = basePath.lastIndexOf("?");
		if(startQues != endQues){
			basePath.replace(startQues, endQues, "");
		}
		String httpUrl = basePath.append(str.toString()).toString();
		logger.info(httpUrl);
		return httpUrl;
	}
	//生成签名
	private static String signRequest(String request, String secretkey) throws Exception {
		Mac mac = Mac.getInstance("HmacSHA1");
		SecretKeySpec keySpec =new SecretKeySpec(secretkey.getBytes(),"HmacSHA1");
		mac.init(keySpec);
		mac.update(request.getBytes());
		byte[] encryptedBytes = mac.doFinal();
		return URLEncoder.encode(Base64.encodeBase64String(encryptedBytes), "UTF-8").replaceAll("\\+", "%20");
	}
}
