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
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.sky.myquartz.job.ForJob;
import com.sky.myquartz.job.MenuJob;

public class MenuScheduler {

	public static void run() throws SchedulerException {
		// 创建一个JobDetail的实例，将该实例与HelloJob class绑定
		JobDetail jobDetail = JobBuilder
				.newJob(MenuJob.class)
				.withIdentity("MenuJob", "group1")
				.build();
		// 创建一个Tigger实例，定义该job立即执行，并且每隔1分钟重复执行一次，直到永远
		CronTrigger trigger = (CronTrigger) TriggerBuilder
				.newTrigger()
				.withIdentity("ForTrigger", "group1")
				.startNow()
				.withSchedule(CronScheduleBuilder
						.cronSchedule("0/5 * * * * ? *"))// 秒分时 日月周年
				.build();
		// 创建Schedule实例
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.start();
		// 打印当前的执行时间
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("scheduler MenuJob start Time Is:" + sf.format(date));
		Date dealDate = scheduler.scheduleJob(jobDetail, trigger);
		System.out.println("dealDate MenuJob Is:" + sf.format(dealDate));
	}
}
