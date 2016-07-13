package com.example.websocket;

public interface WebSocketListener {
	void onConnect(MyWebSocket client);
	void onTextMessage(MyWebSocket client, String message);
	void onDisconnect(MyWebSocket client);
}
