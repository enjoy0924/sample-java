package com.allere.sample.thrift.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;

import com.allere.sample.thrift.HelloWorldImpl;
import com.allere.sample.thrift.HelloWorldService;
/**
 * 非阻塞式服务
 * 
 * @author G_dragon
 *
 */
public class HelloNonBlockingServer {
	public static final int SERVER_PORT = 8090;
	 
	public void startServer() {
		try {
			System.out.println("HelloWorld TNonblockingServer start ....");
 
			TProcessor tprocessor = new HelloWorldService.Processor(new HelloWorldImpl());
 
			TNonblockingServerSocket tnbSocketTransport = new TNonblockingServerSocket(
					SERVER_PORT);
			TNonblockingServer.Args tnbArgs = new TNonblockingServer.Args(
					tnbSocketTransport);
			tnbArgs.processor(tprocessor);
			
			/**
			 *  使用非阻塞式IO，服务端和客户端需要指定TFramedTransport数据传输的方式
			 */
			tnbArgs.transportFactory(new TFramedTransport.Factory());
			
			tnbArgs.protocolFactory(new TCompactProtocol.Factory());
 
			
			TServer server = new TNonblockingServer(tnbArgs);
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
		HelloNonBlockingServer server = new HelloNonBlockingServer();
		server.startServer();
	}
}
