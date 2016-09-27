package cn.test.dubbo.registry.serviceImpl;

import cn.test.dubbo.registry.service.TestRegistryService;

public class TestRegistryServiceImpl implements TestRegistryService {

	public String hello(String name) {
		return "hello:"+name;
	}

}
