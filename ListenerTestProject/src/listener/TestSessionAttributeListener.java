package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;


@WebListener
public class TestSessionAttributeListener implements HttpSessionAttributeListener {

    public void attributeAdded(HttpSessionBindingEvent e)  { 
         System.out.println("세션의 속성이 추가되었습니다.");
    }

    public void attributeRemoved(HttpSessionBindingEvent e)  { 
    	System.out.println("세션의 속성이 파괴되었습니다.");
    }

    public void attributeReplaced(HttpSessionBindingEvent e)  { 
    	System.out.println("세션의 속성이 바꿔치기 당했습니다.");
    }
	
}
