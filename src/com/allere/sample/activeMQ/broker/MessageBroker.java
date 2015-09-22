package com.allere.sample.activeMQ.broker;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

public class MessageBroker {
	
	/**
	 * [1].直接使用activeMQ.bat或者activeMQ.sh启动broker
	 */
	public static void startBroker0() {
		System.out.println("activeMQ.bat | activeMQ.sh");
	}
	
	/**
	 * [2].使用对象方式编码启动broker
	 * 
	 * @throws Exception
	 */
	public static void startBroker1() throws Exception {
       BrokerService broker =new BrokerService();
       broker.setBrokerName("broker01");//如果启动多个Broker时，必须为Broker设置一个名称
       broker.addConnector("tcp://localhost:61616");
       broker.start();
	}
	/**
	 * [3].使用工厂方式编码启动broker
	 * 
	 * @throws URISyntaxException
	 * @throws Exception
	 */
	public static void startBroker2() throws URISyntaxException, Exception {
	   BrokerService broker =BrokerFactory.createBroker(new URI("broker:tcp://localhost:61616"));
	   broker.setBrokerName("broker02");
	   broker.start();
	}
	
	public static void main(String[] argv){
		
		try {
			startBroker2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
