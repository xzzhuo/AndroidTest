package com.example.websocket;

import android.util.Log;
import de.tavendo.autobahn.WebSocket;
import de.tavendo.autobahn.WebSocketConnection;
import de.tavendo.autobahn.WebSocketConnectionHandler;
import de.tavendo.autobahn.WebSocketException;

public class MyWebSocket {

	private static final String TAG = "MyWebSocket";
	
	private WebSocketListener mListener = null;
	private WebSocket mConnection = null;
	private boolean mIsConnect = false;
	
	public MyWebSocket()
	{
		mConnection = new WebSocketConnection();
	}

	public void connect(String wsuri, WebSocketListener listener)
	{
		Log.d(TAG, "Status: Connected to " + wsuri);
		final MyWebSocket socket = this;
		this.mListener = listener;
		
		try {
			mConnection.connect(wsuri, new WebSocketConnectionHandler() {
				@Override
				public void onOpen() {
					socket.mIsConnect = true;
					if (socket.mListener != null)
					{
						socket.mListener.onConnect(socket);
					}
					else
					{
						Log.w(TAG, "no handle 'onConnect()'");
					}
				}

				@Override
				public void onTextMessage(String message) {
					if (socket.mListener != null)
					{
						socket.mListener.onTextMessage(socket, message);
					}
					else
					{
						Log.w(TAG, "no handle 'onTextMessage()'");
					}
				}

				@Override
				public void onClose(int code, String reason) {
					
					Log.w(TAG, "code = " + code);
					
					socket.mIsConnect = false;
					
					if (code == 2 && reason != null)
					{
						Log.e(TAG, reason);
					}
					
					if (socket.mListener != null)
					{
						socket.mListener.onDisconnect(socket);
					}
					else
					{
						Log.w(TAG, "no handle 'onClose()'");
					}
				}
			});
		} catch (WebSocketException e) {
			Log.e(TAG, e.toString());
			
			socket.mIsConnect = false;
		}
	}
	
	public void sendTextMessage(String payload)
	{
		mConnection.sendTextMessage(payload);
	}
	
	public void sendBinaryMessage(byte[] payload)
	{
		mConnection.sendBinaryMessage(payload);
	}
	
	public void Disconnect()
	{
		mConnection.disconnect();
	}
	
	boolean isConnect()
	{
		return this.mIsConnect;
	}
}
