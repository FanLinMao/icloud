package cn.edu.cuit.icloud.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * 关机Job
 * @author Flemming
 * @since 2020/04/20
 */
public class ShutDown implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("关机job...");
		
	}

}
