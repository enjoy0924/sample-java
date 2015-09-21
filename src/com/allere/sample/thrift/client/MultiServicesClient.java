package com.allere.sample.thrift.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import com.allere.sample.thrift.service.HelloWorldService;
import com.allere.sample.thrift.service.TopicService;

public class MultiServicesClient {
	
	public static final String SERVER_IP = "localhost";
	public static final int SERVER_PORT = 8090;
	public static final int TIMEOUT = 30000;
	
	public void startClient(String echoString, String name) {
		
		TTransport transport = null;
		
		try {
			//transport = new TSocket("localhost",SERVER_PORT);
			transport = new TFramedTransport(new TSocket(SERVER_IP,
					SERVER_PORT, TIMEOUT));
			
			TCompactProtocol protocol = new TCompactProtocol(transport);
	
	        TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol,"TopicService");
	        TopicService.Client service1 = new TopicService.Client(mp1);
	
	        TMultiplexedProtocol mp2 = new TMultiplexedProtocol(protocol,"HelloWorldService");
	        HelloWorldService.Client service2 = new HelloWorldService.Client(mp2);
	
	        transport.open();

        
			System.out.println(service1.echo(echoString));
			System.out.println(service2.sayHello(name));
			
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(null != transport)
				transport.close();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MultiServicesClient client = new MultiServicesClient();
		client.startClient("This is my land!", "Michael");
 
	}

}
