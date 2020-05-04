package cn.edu.cuit.icloud.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import cn.edu.cuit.icloud.pojo.User;
import cn.edu.cuit.icloud.vo.TaskVO;

/**
 * TODO
 * @date: 2020年3月11日
 * @author: flfan
 */
public class NullPointTest {
	
	@Test
	public void testNullPoint(){
		/*User user = new User();
		System.out.println(null == user.getUsername());
		ArrayList<String> arrayList = new ArrayList<String>();
		System.out.println(0== arrayList.size());*/
	}
	@Test
	public void testNullString(){
		String str = null + "haha";
		System.out.println(str);
	}
	@Test
	public void testFunctionInterface() {
		List<TaskVO> tasks = new ArrayList<TaskVO>();
		//List<TaskVO> tasks = null;
		tasks.stream().map(obj->{
			if("1".equals(obj.getAction())) {
				obj.setAction("开机");
			}else {
				obj.setAction("关机");
			}
			if("daily".equals(obj.getFrequence())) {
				obj.setFrequence("每天");
			}else if("weekly".equals(obj.getFrequence())){
				obj.setFrequence("每周");
			}
			return obj;
		}).collect(Collectors.toList());
		tasks.forEach(r->System.out.println(r));
	}
	
}
