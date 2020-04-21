package kr.co.powerlinux;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SecondServlet() {
        super();
        System.out.println("Secondservlet()");
        //생성자도 한번만 호출된다.
        // 생성자를 사용하게 되면, 문제점이 한가지 있다.
        //인수를 받을 방법이 없다.....
        //그렇기에 생성자보다는 init을 사용하게 된다.
        //서버가 죽을때 소멸된다.
        //서버를 재 가동할때에도 소멸된다.
        //이때 호출되는 메소드가 destory 메소드이다.
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException{
    	System.out.println("init method is occured");
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text.html; charset=utf-8");
		response.getWriter().println("send");
	}


}
