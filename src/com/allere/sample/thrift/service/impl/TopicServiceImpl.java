package com.allere.sample.thrift.service.impl;

import org.apache.thrift.TException;

import com.allere.sample.thrift.service.TopicService.Iface;

public class TopicServiceImpl implements Iface{

	@Override
	public String echo(String displayWords) throws TException {
		// TODO Auto-generated method stub
		return displayWords;
	}

}
