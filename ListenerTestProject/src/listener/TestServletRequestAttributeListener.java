package listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestServletRequestAttributeListener implements ServletRequestAttributeListener {

    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	 System.out.println("리퀘스트 속성이 파괴되었습니다.");
    }

    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
         System.out.println("리퀘스트 속성이 추가되었습니다.");
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	 System.out.println("리퀘스트 속성이 바꿔치기 당했습니다.");
    }
	
}
