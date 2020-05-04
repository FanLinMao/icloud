package cn.edu.cuit.icloud.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import cn.edu.cuit.icloud.quartz.HelloJob;
import cn.edu.cuit.icloud.scheduler.ShutDown;
import cn.edu.cuit.icloud.scheduler.TaskManager;

/**
 * 任务调度监听器
 * @author Flemming
 * @date 2020/04/19
 */
@WebListener("QuartzListener")
public class QuartzListener implements ServletContextListener{
	
	private Logger logger = Logger.getLogger(QuartzListener.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent sc) {
		logger.info("The all scheduled tasks is closing...");
		TaskManager.shutdownJobs();
	}

	@Override
	public void contextInitialized(ServletContextEvent sc) {
		logger.info("The all scheduled tasks is starting...");
		TaskManager.startJobs();
	}

}
