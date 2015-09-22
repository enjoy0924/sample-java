package com.allere.sample.thrift.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;

import com.allere.sample.thrift.service.HelloWorldService;
import com.allere.sample.thrift.service.HelloWorldService.Iface;
import com.allere.sample.thrift.service.impl.HelloWorldImpl;
/**
 * 0.8之后引入，网络IO模型为 Multi IO + Multi worker, 这种方式理论上可以达到最大的PV吞吐量
 * 
 * @author G_dragon
 *
 */
public class HelloThreadSelectorServer {
	
	public static final int SERVER_PORT = 8090;
	
	public void startServer() {
		try {
			System.out.println("HelloWorld Multi Selector Server start ....");
 
			TProcessor tprocessor = new HelloWorldService.Processor((Iface) new HelloWorldImpl());
 
			TNonblockingServerSocket tnbSocketTransport = new TNonblockingServerSocket(SERVER_PORT);
			TThreadedSelectorServer.Args thhsArgs = new TThreadedSelectorServer.Args(tnbSocketTransport);
			thhsArgs.processor(tprocessor);
			thhsArgs.transportFactory(new TFramedTransport.Factory());
			thhsArgs.protocolFactory(new TCompactProtocol.Factory());
 
			//半同步半异步的服务模型
			TServer server = new TThreadedSelectorServer(thhsArgs);
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
		HelloThreadSelectorServer server = new HelloThreadSelectorServer();
		server.startServer();
	}
}
