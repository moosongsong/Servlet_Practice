package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestServletRequestListener implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent arg0)  { 
         System.out.println("리퀘스트가 파괴되었습니다");
    }
    public void requestInitialized(ServletRequestEvent arg0)  { 
         System.out.println("리퀘스트가 생성되었습니다.");
    }
	
}
