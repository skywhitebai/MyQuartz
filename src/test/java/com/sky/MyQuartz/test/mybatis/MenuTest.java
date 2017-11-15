package com.sky.MyQuartz.test.mybatis;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sky.myquartz.model.Menu;
import com.sky.myquartz.service.IMenuService;


@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class MenuTest {
	@Resource
	private IMenuService menuService ;

	@Test
	public void test() {
		List<Menu> list=menuService.getAll();
		for (Menu menu : list) {
			System.out.println("menu-name:"+menu.getMenuName());
		}
	}
}
