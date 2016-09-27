package com.dubbo.main;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider implements InitializingBean{

	@SuppressWarnings("resource")
	public void afterPropertiesSet() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationProvider.xml");
		context.start();
		System.in.read();
	}
	
//	public static void main(String[] args){
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationProvider.xml");
//		context.start();
//		
//	}
}
