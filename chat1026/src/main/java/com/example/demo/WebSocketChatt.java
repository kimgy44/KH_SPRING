package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
@ServerEndpoint("/chatt") // 웹소켓 endpoint 경로 추가 (WEB-INF아래의 chatt경로 )
public class WebSocketChatt {
	Logger logger = LoggerFactory.getLogger(WebSocketChatt.class);
	// Set자료구조는 기본적으로 중복제거됨
	// 웹소켓 연결이 되면 Session 인스턴스를 담기
	// 웹소켓이 닫히기 전까지 유지됨
	private static Set<Session> clients = 
			Collections.synchronizedSet(new HashSet<Session>());
	// 중복이 허락되는 문제점.. 대신에 순서는 지켜진다.
	private static final List<Session> sessionList = new ArrayList<>();
	private static final List<Map<String, Session>> sessionList2 = new ArrayList<>(); // 방을만든다하면
	// 웹소켓 연결시 콜백으로 호출 - 세션을 담기
	@OnOpen
	public void onOpen(Session s) {
		System.out.println("open session : " + s.toString());
		if(!clients.contains(s)) {
			clients.add(s);
			sessionList.add(s);
			System.out.println("session open : " + s);
		}else {
			System.out.println("이미 연결된 session 임!!!");
		}
	}
	
	/******************************************************
	 * 웹소켓의 endpoint가 메시지를 수신하면 아래 메서드가 콜백됨
	 * @param msg - 사용자가 입력한 메시지 담기
	 * @param session - 웹소켓 생성시 세션을 담기 - 스레드에 의해서 관리
	 * @throws Exception
	 */
	@OnMessage
	public void onMessage(String msg, Session session) throws Exception{
		// 사용자가 입력한 메시지 출력
		System.out.println("receive message : " + msg); //클라이언트가 전송한 메시지 듣기
		String id = session.getId();
		Gson g = new Gson();
		String imsi = g.toJson(msg);
		System.out.println(imsi);
		JSONObject jo = new JSONObject(imsi);
		Iterator it = jo.keys();
        while (it.hasNext()) {
            String key = (String) it.next();
            System.out.println("key: " + key + ", value: " + jo.getString(key));
        }
		logger.info(id);
		for(Session s : clients) {
			System.out.println("send data : " + msg);
			s.getBasicRemote().sendText(msg); // 들은 내용을 다시 내려보내기
		}
		
	}
	
	@OnClose
	public void onClose(Session s) {
		System.out.println("session close : " + s);
		clients.remove(s);
	}
}
