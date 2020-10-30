package cn.edu.cuit.icloud.quartz;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import cn.edu.cuit.icloud.scheduler.TaskManager;

public class QuartzTest {
	
	@Test
	public void testQuartzFramework() throws Exception {
		String JOB_NAME = "动态任务调度";  
	    String TRIGGER_NAME = "动态任务触发器";  
	    String JOB_GROUP_NAME = "XLXXCC_JOB_GROUP";  
	    String TRIGGER_GROUP_NAME = "XLXXCC_JOB_GROUP"; 
	    System.out.println("【系统启动】开始(每1秒输出一次)...");    
        TaskManager.addJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME, "1", "0/1 * * * * ?");    

        Thread.sleep(5000);    
        System.out.println("【修改时间】开始(每5秒输出一次)...");    
        TaskManager.modifyJobTime(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME, "0/5 * * * * ?");    

        Thread.sleep(6000);    
        System.out.println("【移除定时】开始...");    
        TaskManager.removeJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME);    
        System.out.println("【移除定时】成功");  
	}
	@Test
	public void testGetweekday() {
		String week = getWeek("2019-03-21");
		System.out.println(week.substring(0,3));
	}
	
	public String getWeek(String date){
		LocalDate parse = LocalDate.parse(date);
		DayOfWeek dayOfWeek = parse.getDayOfWeek();
		String name = dayOfWeek.name();
		return name;
	}
	
}
