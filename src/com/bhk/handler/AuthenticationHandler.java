package com.bhk.handler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class AuthenticationHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public void close(MessageContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		System.out.println("I am in Interseptor..");
		Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		String[] values = null;
		String strUName = "";
		String strPass = "";
		if(!isRequest){			
			try{
				SOAPMessage soapMsg = context.getMessage();					    
		        SOAPHeader soapHeader = soapMsg.getSOAPHeader();		        
		        
		        NodeList userNameNode = soapHeader.getElementsByTagNameNS("*", "Username");
		        strUName = userNameNode.item(0).getChildNodes().item(0).getNodeValue();
		        
		        NodeList passwordNode = soapHeader.getElementsByTagNameNS("*", "Password");
		        strPass = passwordNode.item(0).getChildNodes().item(0).getNodeValue();
		      
	        	if(strUName.equalsIgnoreCase("bhaskar") && strPass.equalsIgnoreCase("password")) {
	        		//generateSOAPErrMessage(soapMsg, "Valid Credential...");
	    			return true;
	    		}else {
	    			generateSOAPErrMessage(soapMsg, "Innalid Credential...");
	    			return false;
	    		}
		       
		        
			}catch(SOAPException e){
				System.err.println(e);
			}catch(Exception e){
				e.printStackTrace();
				System.err.println(e);
			}
		}		
		return false;
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

	 private void generateSOAPErrMessage(SOAPMessage msg, String reason) {
	       try {
	          SOAPBody soapBody = msg.getSOAPPart().getEnvelope().getBody();
	          SOAPFault soapFault = soapBody.addFault();
	          soapFault.setFaultString(reason);
	          throw new SOAPFaultException(soapFault); 
	       }
	       catch(SOAPException e) { }
	    }
}
