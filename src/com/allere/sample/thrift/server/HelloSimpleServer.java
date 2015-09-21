package com.allere.sample.thrift.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

import com.allere.sample.thrift.HelloWorldImpl;
import com.allere.sample.thrift.HelloWorldService;

public class HelloSimpleServer {
	
	public static final int SERVER_PORT = 8090;
	 
	public void startServer() {
		try {
			System.out.println("HelloWorld TSimpleServer start ....");
 
			TProcessor tprocessor = new HelloWorldService.Processor( new HelloWorldImpl() );
 
			// 简单的单线程服务模型，一般用于测试
			TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
			TServer.Args tArgs = new TServer.Args(serverTransport);
			tArgs.processor(tprocessor);
			
			/**
			 * 设置数据传输格式
			 */
			//tArgs.protocolFactory(new TBinaryProtocol.Factory());
			// tArgs.protocolFactory(new TCompactProtocol.Factory());
			tArgs.protocolFactory(new TJSONProtocol.Factory());
			
			TServer server = new TSimpleServer(tArgs);
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
		HelloSimpleServer server = new HelloSimpleServer();
		server.startServer();
	}
}
