package com.sky.myquartz.job;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.sky.myquartz.model.Menu;
import com.sky.myquartz.service.IMenuService;

public class MenuJob  implements Job {
	
	@Autowired
	IMenuService menuService;
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// 打印当前的执行时间
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current Exec MenuJob Time Is:" + sf.format(date));
		// 编写具体的业务逻辑
		doSomeThing();
	}
	void  doSomeThing(){
		List<Menu> list=menuService.getAll();
		for (Menu menu : list) {
			System.out.println("menu-name:"+menu.getMenuName());
		}
	}
}
