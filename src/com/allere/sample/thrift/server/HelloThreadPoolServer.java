package com.allere.sample.thrift.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;

import com.allere.sample.thrift.service.impl.HelloWorldImpl;
import com.allere.sample.thrift.service.HelloWorldService;
import com.allere.sample.thrift.service.HelloWorldService.Iface;
/**
 * 阻塞式的线程池处理
 * 
 * @author G_dragon
 *
 */
public class HelloThreadPoolServer {
	
	public static final int SERVER_PORT = 8090;
	 
	public void startServer() {
		try {
			System.out.println("HelloWorld TThreadPoolServer start ....");
 
			TProcessor tprocessor = new HelloWorldService.Processor((Iface) new HelloWorldImpl());
 
			 TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
			 TThreadPoolServer.Args ttpsArgs = new TThreadPoolServer.Args(serverTransport);
			 ttpsArgs.processor(tprocessor);
			 
			 //ttpsArgs.protocolFactory(new TBinaryProtocol.Factory());
			 ttpsArgs.protocolFactory(new TJSONProtocol.Factory());
 
			// 线程池服务模型，使用标准的阻塞式IO，预先创建一组线程处理请求。
			 TServer server = new TThreadPoolServer(ttpsArgs);
			 server.serve();
 
		} catch (Exception e) {
			System.out.println("Server start error!!!");
			e.printStackTrace();
		}
	}
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloThreadPoolServer server = new HelloThreadPoolServer();
		server.startServer();
	}

}
