package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestServletContextListner implements ServletContextListener {

	public void contextInitialized(ServletContextEvent e)  { 
        System.out.println("어플리케이션이 시작되었습니다.");
        ServletContext sc = e.getServletContext();
        sc.setAttribute("serverName", "me server");
	}
	
	public void contextDestroyed(ServletContextEvent e)  { 
		System.out.println("어플리케이션이 종료되었습니다.");
    }
	
}
