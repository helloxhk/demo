package com.xhk.controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xhk.service.DemoService;

public class MainClass {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
		context.start();
		System.out.println(" ------------- consumer start --------------- ");
		DemoService demoService = context.getBean(DemoService.class);
		String string = demoService.getPermission(111);
		System.out.println(string);
		
		System.out.println(" ------------- consumer end --------------- ");
	}
	
}
