package com.bhk.service.publicher;

import javax.xml.ws.Endpoint;

import com.bhk.service.impl.HelloServiceImpl;

public class WebServicePublisher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endpoint.publish("http://localhost:9988/ws/hello", new HelloServiceImpl());
	}

}
