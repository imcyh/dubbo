package com.dubbo.controller;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.test.dubbo.registry.service.TestRegistryService;


@RestController
@RequestMapping("/dubbo")
public class IndexController {
	
	@RequestMapping("/hello")
	public String index(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(  
                new String[] { "src/main/resources/applicationContext.xml" });  
        context.start();
		TestRegistryService testRegistryService = (TestRegistryService) context.getBean("testRegistryService");
		String name = testRegistryService.hello("cccccyyyyyhhhhh");
		System.out.println(name);
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		context.close();
		return name;
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationConsumer.xml");
        context.start();
		TestRegistryService testRegistryService = (TestRegistryService) context.getBean("testRegistryService");
		String name = testRegistryService.hello("cccccyyyyyhhhhh");
		System.out.println(name);
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		context.close();
	}
}
