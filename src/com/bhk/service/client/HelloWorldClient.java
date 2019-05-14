package com.bhk.service.client;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

import com.bhk.service.HelloService;


public class HelloWorldClient{
	
	private static final String WS_URL = "http://localhost:9999/ws/hello?wsdl";
		
	public static void main(String[] args) throws Exception {
	   
	URL url = new URL(WS_URL);
        QName qname = new QName("http://impl.service.bhk.com/", "HelloServiceImplService");

        Service service = Service.create(url, qname);
        HelloService hello = service.getPort(HelloService.class);
        
        /*******************UserName & Password ******************************/
        Map<String, Object> req_ctx = ((BindingProvider)hello).getRequestContext();
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);

        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList("bhaskar"));
        headers.put("Password", Collections.singletonList("password"));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
        /**********************************************************************/
        
        System.out.println(hello.getHelloWorldAsString());
       
    }
}
