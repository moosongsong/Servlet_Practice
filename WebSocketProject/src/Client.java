import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.Session;

public class Client {
	private static ArrayList<Session> client;
	
	static {
		client = new ArrayList<Session>();
	}
	
	public static void addSession(Session session) {
		client.add(session);
		sendMessage(session.getId()+", 접솝함");
	}
	
	static void removeSession(Session session) {
		client.remove(session);
		sendMessage(session.getId()+", 삭제됨");
	}
	
	public static void sendMessage(String message) {
		for (Session session : client) {
			if(session.isOpen()) {
				try {
					session.getBasicRemote().sendText(message);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
