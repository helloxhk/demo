package com.xhk.service.impl;

import com.xhk.service.DemoService;

public class DemoServiceImpl implements DemoService {

	public String getPermission(int id) {
		return "congratulations!," + id;
	}

}
