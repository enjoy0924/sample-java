package com.allere.sample.thrift.server;

import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

import com.allere.sample.thrift.service.HelloWorldService;
import com.allere.sample.thrift.service.TopicService;
import com.allere.sample.thrift.service.impl.HelloWorldImpl;
import com.allere.sample.thrift.service.impl.TopicServiceImpl;
/**
 * 0.9.1引入，支持多种服务的接口实现
 * 
 * @author G_dragon
 *
 */
public class MultiServicesServer {
	
	public static final int SERVER_PORT = 8090;
	
	public void startServer() {
		
		System.out.println("Multi-services server start ....");
		
		try {
			TMultiplexedProcessor processor = new TMultiplexedProcessor();
			processor.registerProcessor("TopicService", new TopicService.Processor<TopicService.Iface>(new TopicServiceImpl()));
	        processor.registerProcessor("HelloWorldService", new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldImpl()));
			
			TNonblockingServerSocket tnbSocketTransport = new TNonblockingServerSocket(
					SERVER_PORT);
			TNonblockingServer.Args tnbArgs = new TNonblockingServer.Args(
					tnbSocketTransport);
			tnbArgs.processor(processor);
			
			/**
			 *  使用非阻塞式IO，服务端和客户端需要指定TFramedTransport数据传输的方式
			 */
			tnbArgs.transportFactory(new TFramedTransport.Factory());
			
			tnbArgs.protocolFactory(new TCompactProtocol.Factory());

			TServer server = new TNonblockingServer(tnbArgs);
	        
	        server.serve();
	        
		} catch ( TTransportException e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MultiServicesServer server = new MultiServicesServer();
		server.startServer();
	}

}
