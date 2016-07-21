package com.example.websocket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WebSocketSendPacket {
	private WebSocketSendHeader header;
	private Object data;
	private String type;
	
	public WebSocketSendPacket(WebSocketSendHeader header, Object data, String type)
	{
		this.header = header;
		this.data = data;
		this.type = type;
	}
	
	public WebSocketSendPacket(String msgid, String account, String token, Object data, String type)
	{
		this.header = new WebSocketSendHeader(msgid, account, token);
		this.data = data;
		this.type = type;
	}
	
	public WebSocketSendPacket(String msgid, String account, String token)
	{
		this.header = new WebSocketSendHeader(msgid, account, token);
		this.data = null;
		this.type = "value";
	}
	
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
	
	public String toJsonValue() throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonValue = null;
		
		if (this.data == null)
		{
			jsonValue = String.format("{\"header\":%s}", objectMapper.writeValueAsString(this.header));
		}
		else
		{
			String jsonFormat = "{\"header\":%s,\"data\":{\"%s\":%s}}";
			jsonValue = String.format(jsonFormat,
					objectMapper.writeValueAsString(this.header),
					type,
					objectMapper.writeValueAsString(this.data));
		}

		return jsonValue;
	}
}
