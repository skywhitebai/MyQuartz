package com.sky.myquartz.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.sky.myquartz.job.HelloJob;

public class HelloScheduler {

	public static void run() throws SchedulerException {
		// 创建一个JobDetail的实例，将该实例与HelloJob class绑定
		JobDetail jobDetail = JobBuilder
				.newJob(HelloJob.class)
				.withIdentity("HelloJob", "group1")
				.build();
		// 创建一个Tigger实例，定义该job立即执行，并且每隔3秒钟重复执行一次，直到永远
		CronTrigger trigger = (CronTrigger) TriggerBuilder
				.newTrigger()
				.withIdentity("HelloTrigger", "group1")
				.startNow()
				.withSchedule(CronScheduleBuilder
						.cronSchedule("0/3 * * * * ? *"))// 秒分时 日月周年
				.build();
		// 创建Schedule实例
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.start();
		// 打印当前的执行时间
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("scheduler HelloScheduler start Time Is:" + sf.format(date));
		Date dealDate = scheduler.scheduleJob(jobDetail, trigger);
		System.out.println("dealDate HelloScheduler Is:" + sf.format(dealDate));
	}
}
