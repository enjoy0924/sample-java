package com.allere.sample.thrift.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;

import com.allere.sample.thrift.HelloWorldImpl;
import com.allere.sample.thrift.HelloWorldService;

/**
 * 半同步半异步模型服务
 * @author G_dragon
 *
 */
public class HelloHaHsServer {

	public static final int SERVER_PORT = 8090;
	 
	public void startServer() {
		try {
			System.out.println("HelloWorld THsHaServer start ....");
 
			TProcessor tprocessor = new HelloWorldService.Processor(new HelloWorldImpl());
 
			TNonblockingServerSocket tnbSocketTransport = new TNonblockingServerSocket(
					SERVER_PORT);
			THsHaServer.Args thhsArgs = new THsHaServer.Args(tnbSocketTransport);
			thhsArgs.processor(tprocessor);
			thhsArgs.transportFactory(new TFramedTransport.Factory());
			thhsArgs.protocolFactory(new TBinaryProtocol.Factory());
 
			//半同步半异步的服务模型
			TServer server = new THsHaServer(thhsArgs);
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
		HelloHaHsServer server = new HelloHaHsServer();
		server.startServer();
	}
	
}
