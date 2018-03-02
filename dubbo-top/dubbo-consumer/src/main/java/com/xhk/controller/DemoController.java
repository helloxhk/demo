package com.xhk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.xhk.service.DemoService;

@Controller
public class DemoController {
	
	@Autowired
	private DemoService demoService;
	
	public String getPermission(int id){
		return demoService.getPermission(id);
	}
}
