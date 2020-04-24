package kr.co.moosong.controller;

import java.io.FileReader;
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

import kr.co.moosong.service.BoardService;
import kr.co.moosong.service.MemberService;
import kr.co.moosong.service.ServiceController;
import kr.co.moosong.service.UnkownService;

@WebServlet(name="frontController",
			urlPatterns= {"/member", "/board"},
			initParams = {
					@WebInitParam(name="/ControllerProject/member", value = "kr.co.moosong.service.MemberService"),
					@WebInitParam(name="/ControllerProject/board", value = "kr.co.moosong.service.BoardService"),
					@WebInitParam(name="/ControllerProject/unkown", value = "kr.co.moosong.service.UnkownService")
			})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, ServiceController> services;
	
	public void init(ServletConfig config) throws ServletException{
		//해쉬맵 구성하기
		services = new HashMap<String, ServiceController>();
		services.put("/ControllerProject/member", new MemberService());
		services.put("/ControllerProject/board", new BoardService());
		services.put("/ControllerProject/unkown", new UnkownService());
		
//		Properties pro = new Properties();
////		pro.load(new FileReader("C:\\Users\\송무송\\ECLIPSE_WORKSPACE2\\ControllerProject\\WebContent\\WEB-INF\\controller.properties"));
//		
//		Enumeration<String>names = config.getInitParameterNames();
//		while (names.hasMoreElements()) {
//			String name=names.nextElement();
//			try {
//				Class cls = Class.forName(config.getInitParameter(name));
//				services.put(name, (ServiceController) cls.newInstance());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		ServiceController sc = null;
		String dispURI=null;
		if (services.containsKey(uri)) {
			//서비스가 존재한다.
			//서비스 컨트롤러가 나온다.
			dispURI = services.get(uri).doService(request, response);
		}else {
			services.get("/ControllerProject/unkown").doService(request, response);
		}
		RequestDispatcher disp = request.getRequestDispatcher(dispURI);
		disp.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("text/html;charset=utf-8");
		doGet(request, response);
	}

}
