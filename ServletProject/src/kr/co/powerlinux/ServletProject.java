package kr.co.powerlinux;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletProject")//@WebServlet("/search")로 바꾸기도 가능
// 서블릿 요청 패턴을 내가 지정!!
public class ServletProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get 메소드의 요청을 처리한거
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();//출력, 클라이 언트에게 정보 전송
		out.print("Get method's response_츄츄");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 방식으로 요청했을때, 처리하는애.
		// 요류처리는 컨테이너로 전가된다.
		// 입출력 오류가 포함된 이유는 데이터를 읽어들이려면 출력 스트림이 필요하다.
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();//출력, 클라이 언트에게 정보 전송
		out.print("Post method's response_츄츄");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		super.doDelete(req, resp);
	}

}
