package com.allere.sample.thrift;
/**
 * 这个类用来实现自动生成消息类里面的Iface接口，属于
 * 服务器端的消息处理实现
 * 
 */
import org.apache.thrift.TException;

import com.allere.sample.thrift.HelloWorldService.Iface;

public class HelloWorldImpl implements Iface {

	public HelloWorldImpl() {
		
	}
	
	@Override
	public String sayHello(String username) throws TException {
		// TODO Auto-generated method stub
		return "Hi," + username + " welcome to plum land";
	}

}
