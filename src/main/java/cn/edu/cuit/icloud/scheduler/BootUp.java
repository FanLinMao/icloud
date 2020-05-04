package cn.edu.cuit.icloud.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * 开机Job
 * @author FLemming
 * @since 2020/4/20
 */
public class BootUp implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("开机job..");
		
	}

}
