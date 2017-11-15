package com.sky.myquartz;

import org.quartz.SchedulerException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import com.sky.myquartz.dao.MenuMapper;
import com.sky.myquartz.job.ForJob;
import com.sky.myquartz.schedule.DealScheduler;
import com.sky.myquartz.schedule.ForScheduler;
import com.sky.myquartz.schedule.HelloScheduler;
import com.sky.myquartz.schedule.MenuScheduler;
import com.sky.myquartz.service.IMenuService;
import com.sky.myquartz.service.impl.MenuServiceImpl;

/**
 * Hello world!
 *
 */

public class App 
{
	  private static ClassPathXmlApplicationContext ctx;
	    public static void main( String[] args ) throws SchedulerException
	    {

//	        ctx = new ClassPathXmlApplicationContext(
//	                new String[] { "classpath:spring-mybatis.xml" });

//	      HelloScheduler.run();
//	      ForScheduler.run();
//	      DealScheduler.run();
	        //IMenuService menuService = (IMenuService) ctx.getBean("MenuService");  
//	        MenuMapper menuMapper = ctx.getBean(MenuMapper.class);  
	        MenuScheduler.run();
	    }
}
