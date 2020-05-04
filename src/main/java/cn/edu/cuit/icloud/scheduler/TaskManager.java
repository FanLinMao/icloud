package cn.edu.cuit.icloud.scheduler;

import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

/**
 * TODO
 * 定时任务管理类
 * @author: Flemming
 * @since: 2020年4月22日
 */
public class TaskManager {
	
	static Logger logger = Logger.getLogger(TaskManager.class);

	private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();

	/**
	 * 添加一个作业
	 * @param jobName 作业名
	 * @param jobGroupName 作业组
	 * @param triggerName 触发器名
	 * @param triggerGroupName 触发器组
	 * @param jobClass 要执行的作业类
	 * @param cron 时间表达式
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void addJob(String jobName, 
			String jobGroupName, 
			String triggerName, 
			String triggerGroupName,
			Class jobClass, 
			String cron) {
		try {
			Scheduler sched = schedulerFactory.getScheduler();
			// 任务名，任务组，任务执行类
			JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();

			// 触发器
			TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
			// 触发器名,触发器组
			triggerBuilder.withIdentity(triggerName, triggerGroupName);
			triggerBuilder.startNow();
			// 触发器时间设定
			triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
			// 创建Trigger对象
			CronTrigger trigger = (CronTrigger) triggerBuilder.build();

			// 调度容器设置JobDetail和Trigger
			sched.scheduleJob(jobDetail, trigger);

			// 启动
			if (!sched.isShutdown()) {
				sched.start();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 修改作业时间
	 * @param jobName 作业名
	 * @param jobGroupName 作业所在组
	 * @param triggerName 触发器名
	 * @param triggerGroupName 触发器所在组
	 * @param cron 时间表达式
	 */
	public static void modifyJobTime(String jobName, String jobGroupName, String triggerName, String triggerGroupName,
			String cron) {
		try {
			Scheduler sched = schedulerFactory.getScheduler();
			TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
			CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerKey);
			if (trigger == null) {
				return;
			}

			String oldTime = trigger.getCronExpression();
			if (!oldTime.equalsIgnoreCase(cron)) {
				/** 方式一 ：调用 rescheduleJob 开始 */
				// 触发器
				TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
				// 触发器名,触发器组
				triggerBuilder.withIdentity(triggerName, triggerGroupName);
				triggerBuilder.startNow();
				// 触发器时间设定
				triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
				// 创建Trigger对象
				trigger = (CronTrigger) triggerBuilder.build();
				// 方式一 ：修改一个任务的触发时间
				sched.rescheduleJob(triggerKey, trigger);
				/** 方式一 ：调用 rescheduleJob 结束 */

				/** 方式二：先删除，然后在创建一个新的Job */
				// JobDetail jobDetail = sched.getJobDetail(JobKey.jobKey(jobName,
				// jobGroupName));
				// Class<? extends Job> jobClass = jobDetail.getJobClass();
				// removeJob(jobName, jobGroupName, triggerName, triggerGroupName);
				// addJob(jobName, jobGroupName, triggerName, triggerGroupName, jobClass, cron);
				/** 方式二 ：先删除，然后在创建一个新的Job */
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 移除一个作业
	 * @param jobName 作业名
	 * @param jobGroupName 作业组
	 * @param triggerName 触发器
	 * @param triggerGroupName 
	 * @return
	 */
	public static int removeJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName) {
		int status = 1;
		try {
			Scheduler sched = schedulerFactory.getScheduler();

			TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);

			sched.pauseTrigger(triggerKey);// 停止触发器
			sched.unscheduleJob(triggerKey);// 移除触发器
			sched.deleteJob(JobKey.jobKey(jobName, jobGroupName));// 删除任务
			logger.info("移除定时任务成功...");
		} catch (Exception e) {
			logger.info("移除定时任务失败！");
			status = 0;
		}
		return status;
	}
	
	/**
	 * 开启所有任务
	 */
	public static void startJobs() {
		try {
			Scheduler sched = schedulerFactory.getScheduler();
			sched.start();
			logger.info("定时任务已全部开启...");
		} catch (Exception e) {
			logger.error("定时任务开启失败："+e.getMessage());
		}
	}

	/**
	 * 关闭所有作业
	 */
	public static void shutdownJobs() {
		try {
			Scheduler sched = schedulerFactory.getScheduler();
			if (!sched.isShutdown()) {
				sched.shutdown();
				logger.info("定时任务已全部关闭！");
			}
		} catch (Exception e) {
			logger.error("定时任务关闭失败："+e.getMessage());
		}
	}

}
