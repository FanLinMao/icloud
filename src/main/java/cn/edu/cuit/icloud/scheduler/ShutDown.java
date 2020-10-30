package cn.edu.cuit.icloud.scheduler;

import java.util.ArrayList;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cn.edu.cuit.icloud.constant.Cmd;
import cn.edu.cuit.icloud.service.CallService;
import cn.edu.cuit.icloud.service.impl.CallServiceImpl;
/**
 * 关机Job
 * @author Flemming
 * @since 2020/04/20
 */
public class ShutDown implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("关机job...");
		CallService callService = new CallServiceImpl();
		Gson gson = new Gson();
		List<cn.edu.cuit.icloud.call.virtualmachine.list.ResponseTags> list = new ArrayList<cn.edu.cuit.icloud.call.virtualmachine.list.ResponseTags>();
		try {
			String json = callService.callCommand2(Cmd.LIST_VIRTUALMACHINES, "");
			JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
			JsonObject subObj = obj.get("listvirtualmachinesresponse").getAsJsonObject();
			JsonArray result = subObj.get("virtualmachine").getAsJsonArray();
			result.forEach(o->{
				cn.edu.cuit.icloud.call.virtualmachine.list.ResponseTags res = gson.fromJson(o, cn.edu.cuit.icloud.call.virtualmachine.list.ResponseTags.class);
				list.add(res);
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cn.edu.cuit.icloud.call.virtualmachine.stop.RequestParameters requestParameters = new cn.edu.cuit.icloud.call.virtualmachine.stop.RequestParameters();
		List<String> list2 = new ArrayList<String>();
		if(null != list) {
			list.forEach(s->{
				String vm_id = s.getId();
				requestParameters.setId(vm_id);
				try {
					String json = callService.callCommand2(Cmd.STOP_VIRTUALMACHINE, gson.toJson(requestParameters));
					list2.add(json);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
		System.out.println("关闭了；"+list2.size()+"台虚拟机.");
	}

}
