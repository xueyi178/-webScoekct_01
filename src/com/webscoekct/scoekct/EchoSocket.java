package com.webscoekct.scoekct;

import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * 1.;连接webScoekct
 * 项目名称：webScoekct_01 
 * 类名称：EchoSocket
 * 开发者：Lenovo
 * 开发时间：2019年6月28日下午12:59:39
 */
@ServerEndpoint("/echo")
public class EchoSocket {

	public EchoSocket() {
		System.out.println("EchoSocket");
	}
	
	/**
	 * @OnOpen: 表示客户端与服务端建立连接,  onopen是打开连接时的响应事件。
	 * 1.webScocket中一个管道就是代表一个session,一个管道可以接收和发送信息,也就代表一个会话
	 * 接收前端连接webScoekct的请求
	 * 每个管道是一个独立的对象,是单实例的
	 * @param session
	 */
	@OnOpen
	public void open(Session session) {
		System.out.println("sessionId ===="+ session.getId());
	}
	
	/**
	 * 2. @OnClose: 表示释放webScoekct连接,   onclose是关闭连接时的响应事件。
	 * @param session
	 */
	@OnClose
	public void close(Session session) {
		System.out.println("session通道关闭了 ====="+ session.getId());
	}
	
	/**
	 * 3. onmessage 是发送数据时的响应事件。
	 * @param session
	 * @param msg
	 */
	@OnMessage
	public void message(Session session, String msg) {
		System.out.println("客户端的数据==="+ msg);
		try {
			session.getBasicRemote().sendText("服务器: 你好");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
