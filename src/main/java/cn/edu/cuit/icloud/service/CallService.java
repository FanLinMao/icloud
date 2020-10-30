package cn.edu.cuit.icloud.service;

/**
 * TODO
 * @author: Think
 * @since: 2020年5月9日
 */
public interface CallService {
	
	/**
	 * 公共调用cloudstack api的方法
	 * @param command  命令
	 * @param jsonRequestParameters  命令附带的参数
	 * @return 返回cloudstack的标准ResultTags
	 * @throws Exception
	 */
	public Object callCommand(String command, String jsonRequestParameters) throws Exception;
	
	/**
	 * 公共调用cloudstack api的方法
	 * @param command  命令
	 * @param jsonRequestParameters  命令附带的参数
	 * @return 返回请求cloudstack的json字符串
	 * @throws Exception
	 */
	public String callCommand2(String command, String jsonRequestParameters) throws Exception;
	
	/**
	 * 入库处理
	 * @param sql
	 * @param params 参数
	 * @return 状态
	 */
	public boolean insertDB(String sql, Object[] params);
}
