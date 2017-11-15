package com.sky.myquartz.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ForJob implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		// 打印当前的执行时间
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current Exec ForJob Time Is:" + sf.format(date));
		// 编写具体的业务逻辑
		doSomeThing();
	}
	void  doSomeThing(){
		for(int i=0;i<5;i++){
			System.out.println("DealJob：doSomeThing---"+i);
		}
	}
}
