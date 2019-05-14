package com.bhk.service.bean;

public class Message {

	String strMessage;
	String strMessage2;
	public String getStrMessage() {
		return strMessage;
	}
	public void setStrMessage(String strMessage) {
		this.strMessage = strMessage;
	}
	public String getStrMessage2() {
		return strMessage2;
	}
	public void setStrMessage2(String strMessage2) {
		this.strMessage2 = strMessage2;
	}
	public Message(String strMessage, String strMessage2) {		
		this.strMessage = strMessage;
		this.strMessage2 = strMessage2;
	}
	
	public Message() {
		
	}
}
