package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class TestSessionListener implements HttpSessionListener {
	
	public void sessionCreated(HttpSessionEvent e)  { 
		HttpSession se = e.getSession();
		System.out.println("세션 id:"+se.getId()+", 세션이 연결되었습니다.");
    }
	
	 public void sessionDestroyed(HttpSessionEvent e)  { 
		 HttpSession se = e.getSession();
         System.out.println("세션 id:"+se.getId()+", 세션이 파괴되었습니다.");
    }
    
}
