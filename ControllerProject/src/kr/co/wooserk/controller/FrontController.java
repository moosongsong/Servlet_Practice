package kr.co.wooserk.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.wooserk.service.ServiceController;

@WebServlet
(
	name = "frontController",
	urlPatterns = {"/member", "/board"},
	initParams = 
	{
		@WebInitParam(name="/ControllerProject/member",
			value="kr.co.wooserk.service.MemberService"),
		@WebInitParam(name="/ControllerProject/board",
			value="kr.co.wooserk.service.BoardService"),
		@WebInitParam(name="/ControllerProject/unknown",
			value="kr.co.wooserk.service.UnknownService")
	}
)
public class FrontController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	HashMap<String, ServiceController> services;
	
	public void init(ServletConfig config) throws ServletException
	{
		services = new HashMap<>();
		/*
		 * Properties prop = new Properties(); try { prop.load(new FileReader(
		 * "C:\\ServletWorkspace\\ControllerProject\\WebContent\\WEB-INF\\controller.properties"
		 * )); } catch(FileNotFoundException e) { e.printStackTrace(); }
		 * catch(IOException e) { e.printStackTrace(); }
		 */
		
		Enumeration<String> names = config.getInitParameterNames();
		while(names.hasMoreElements())
		{
			String name = names.nextElement();
			
			try
			{
				Class cls = Class.forName(config.getInitParameter(name));
				services.put(name, (ServiceController)(cls.newInstance()));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String uri = request.getRequestURI();
		String dispatcherUri = null;
		
		if(services.containsKey(uri))
		{
			dispatcherUri = services.get(uri).doService(request, response);
			RequestDispatcher disp = request.getRequestDispatcher(dispatcherUri);
			disp.forward(request, response);
		}
		/*
		 * else { dispatcherUri =
		 * services.get("/ControllerProject/unknown").doService(request, response); }
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
