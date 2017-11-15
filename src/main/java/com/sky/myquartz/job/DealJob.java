package com.sky.myquartz.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class DealJob implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		// 打印当前的执行时间
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current Exec DealJob Time Is:" + sf.format(date));
		// 编写具体的业务逻辑
		System.out.println("DealJob：deal!");

	}

}
