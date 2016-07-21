package com.example.websocket;

import java.util.Date;

public class WebSocketSendHeader {
	private String msgid;
	private String account;
	private String token;
	private Date date;

	public WebSocketSendHeader(String msgid, String account, String token)
	{
		this.msgid = msgid;
		this.account = account;
		this.token = token;
		this.date = new Date();
	}
	
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
