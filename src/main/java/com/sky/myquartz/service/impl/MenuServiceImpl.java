package com.sky.myquartz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.myquartz.dao.MenuMapper;
import com.sky.myquartz.model.Menu;
import com.sky.myquartz.service.IMenuService;

@Service("MenuService")
public class MenuServiceImpl implements IMenuService {

	@Autowired
	MenuMapper menuMapper;
	public List<Menu> getAll() {
		return menuMapper.getAll();
	}

}
