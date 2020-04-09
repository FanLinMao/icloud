package cn.edu.cuit.icloud.http;


import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import cn.edu.cuit.icloud.utils.HttpClientUtil;
import cn.edu.cuit.icloud.utils.UrlUtil;

/**
 * TODO
 * @date: 2020年4月1日
 * @author: flfan
 */
public class HttpClientTest {
	
	@Test
	public void testHttpRequest() throws Exception{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://www.baidu.com");
		CloseableHttpResponse response1 = httpclient.execute(httpGet);
		try {
		    System.out.println(response1.getStatusLine());
		    HttpEntity entity1 = response1.getEntity();
		    // do something useful with the response body
		    // and ensure it is fully consumed
		    String content = EntityUtils.toString(entity1, "utf-8");
		    System.out.println(content);
		    EntityUtils.consume(entity1);
		} finally {
			response1.close();
		}

	}
	
	@Test
	public void testHttpClientUitl() throws Exception{
		String baseUrl = "http://localhost:8080/client/api?";
		String security = "H65hqe7U-T59TwpD2-0dNYbfcDYKaAnrQQoTFghyiMhMCrGm-pLJV5hGPc8fTHqn6XYxUowJNxjMXxilp4VY2Q";
		String apikey = "2n9_BGYlgUjLZMiHZi5U58_88QCcWLYHwm80WYoc8rd91XMsnlZ4kD9xvg3AMBKpuxz3P8OwOwJhtX-HpelrFg";
		
		TreeMap treeMap = new TreeMap((v1,v2)->{
			if(v1 == null || v2 == null){
				return 0;
			}
			return String.valueOf(v1).compareTo(String.valueOf(v2));
		});
		treeMap.put("command", "listUsers");
		treeMap.put("apiKey", apikey);
		treeMap.put("response", "json");
		StringBuilder str = new StringBuilder();
		treeMap.forEach((k,v)->{
			try {
				String encoded_v = URLEncoder.encode(String.valueOf(v), "UTF-8").replaceAll("\\+", "%20");
				str.append(k).append("=").append(encoded_v).append("&");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		str.replace(str.lastIndexOf("&"), str.length(), "");
		System.out.println(str.toString());
		Mac mac = Mac.getInstance("HmacSHA1");
		SecretKeySpec keySpec =new SecretKeySpec(security.getBytes(),"HmacSHA1");
		mac.init(keySpec);
		mac.update(str.toString().toLowerCase().getBytes());
		byte[] encryptedBytes = mac.doFinal();
		String encodeBase64String = URLEncoder.encode(Base64.encodeBase64String(encryptedBytes), "UTF-8").replaceAll("\\+", "%20");
		System.out.println(encodeBase64String);
		str.append("&signature=").append(encodeBase64String);
		System.out.println(str);
		String httpUrl = baseUrl+str.toString();
		System.out.println(httpUrl);
		HttpClientUtil httpClient = HttpClientUtil.getInstance();
		String reponseContent = httpClient.sendHttpGet(httpUrl);
		System.out.println(reponseContent);
	}
	@Test
	public void testRequestURL() throws Exception{
		String baseUrl = "http://localhost:8080/client/api";
		String security = "H65hqe7U-T59TwpD2-0dNYbfcDYKaAnrQQoTFghyiMhMCrGm-pLJV5hGPc8fTHqn6XYxUowJNxjMXxilp4VY2Q";
		String apikey = "   2n9_BGYlgUjLZMiHZi5U58_88QCcWLYHwm80WYoc8rd91XMsnlZ4kD9xvg3AMBKpuxz3P8OwOwJhtX-HpelrFg";
		String encodedApiKey = URLEncoder.encode(apikey, "UTF-8").replaceAll("\\+", "%20");
		String urlold = "apikey=" + encodedApiKey + "&command=listUsers";
		urlold = urlold.toLowerCase();
		String signature = signRequest(urlold, security);
		String encodedSignature = URLEncoder.encode(signature, "UTF-8").replaceAll("\\+","%20");
		System.out.println(encodedSignature);
		String url = baseUrl+"?command=listUsers&apikey="+encodedApiKey+"&response=json"+"&signature="+encodedSignature;
		System.out.println(url);
		HttpClientUtil httpClient = HttpClientUtil.getInstance();
		String content = httpClient.sendHttpGet(url);
		System.out.println(content);
	}

	private String signRequest(String request, String secretkey) throws Exception {
		Mac mac = Mac.getInstance("HmacSHA1");
		SecretKeySpec keySpec = new SecretKeySpec(secretkey.getBytes(),"HmacSHA1");
		mac.init(keySpec);
		mac.update(request.getBytes());
		byte[] encryptedBytes = mac.doFinal();
		return new String(Base64.encodeBase64(encryptedBytes));
	}
	@Test
	public void testStrAdd(){
		String replace = "+++2n9_BGYlgUjLZMiHZi5U58_88QCcWLYHwm80WYoc8rd91XMsnlZ4kD9xvg3AMBKpuxz3P8OwOwJhtX-HpelrFg".replaceAll("\\+", "%20");
		System.out.println(replace);
	}
	@Test
	public void testUrlUtil(){
		HashMap<String, Object> treeMap = new HashMap<String,Object>();
		treeMap.put("command", "listUsers");
		String createUrl = UrlUtil.createUrl(treeMap);
		System.out.println(createUrl);
	}
	
}
