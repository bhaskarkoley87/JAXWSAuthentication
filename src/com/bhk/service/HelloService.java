package com.bhk.service;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
//@SOAPBinding(style = Style.RPC)
@SOAPBinding(style = Style.DOCUMENT)
@HandlerChain(file="handler-chain.xml")
public interface HelloService {
	
	@WebMethod 
	@WebResult(partName="MyReturn")	
	String getHelloWorldAsString();
}
