package com.example.websocket;

public class WebSocketSendPacket {
	private WebSocketSendHeader header;
	private Object data;
	
	public WebSocketSendHeader getHeader() {
		return header;
	}
	public void setHeader(WebSocketSendHeader header) {
		this.header = header;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
