package com.bhk.service.impl;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.bhk.service.HelloService;

@WebService(endpointInterface = "com.bhk.service.HelloService")
public class HelloServiceImpl implements HelloService {

	@Resource
	WebServiceContext wsctx;
	
	String strUsername;
	String strPassword;
	
	String[] values;
	
	List lstUsername = null;
	List lstPassword = null;
	
	@Override
	public String getHelloWorldAsString() {
		/*MessageContext msgctx = wsctx.getMessageContext();
		
		// Get the Request Header for the Request.
		Map http_headers  = (Map)msgctx.get(MessageContext.HTTP_REQUEST_HEADERS);
		
		http_headers.forEach((K , V) -> {
			System.out.println(K + " : "+V);
			if(K.toString().equalsIgnoreCase("Authorization")) {
				System.out.println("1 : "+K.toString());
				System.out.println("1 : "+V.toString());
				String authorization = V.toString();
				authorization = authorization.replace("[", "");
				authorization = authorization.replace("]", "");
				if (authorization != null && authorization.toLowerCase().startsWith("basic")) {
					System.out.println("2 : "+K.toString());
				    // Authorization: Basic base64credentials
				    String base64Credentials = authorization.substring("Basic".length()).trim();
				    byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
				    String credentials = new String(credDecoded, StandardCharsets.UTF_8);
				    // credentials = username:password
				    values = credentials.split(":", 2);
				    for(String val : values) {
				    	System.out.println(val);
				    }
				}
			}
		});
		
		if(http_headers.containsKey("Username") && http_headers.containsKey("Password")) {
			lstUsername = (List) http_headers .get("Username");
			lstPassword = (List) http_headers .get("Password");
			Optional<String> checkNullForUSer = Optional.ofNullable(lstUsername != null ? lstUsername.get(0).toString(): "");
			Optional<String> checkNullForPass = Optional.ofNullable(lstPassword != null ?lstPassword.get(0).toString() : "");
			
			strUsername = checkNullForUSer.isPresent() ? checkNullForUSer.get() : "";
			strPassword = checkNullForPass.isPresent() ? checkNullForPass.get() : "";
		}else if(values != null && values.length > 0) {
			strUsername = values[0];
			strPassword = values[1];
		}else {
			strUsername = "";
			strPassword = "";
		}
		
		
		
		if(strUsername.equalsIgnoreCase("bhaskar") && strPassword.equalsIgnoreCase("password")) {
			return "Hi you have call the Hello web Service";
		}else {
			return "Invalid User";
		}*/
		return "Hi you have call the Hello web Service";
	}

}
