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
        //�����ڵ� �ѹ��� ȣ��ȴ�.
        // �����ڸ� ����ϰ� �Ǹ�, �������� �Ѱ��� �ִ�.
        //�μ��� ���� ����� ����.....
        //�׷��⿡ �����ں��ٴ� init�� ����ϰ� �ȴ�.
        //������ ������ �Ҹ�ȴ�.
        //������ �� �����Ҷ����� �Ҹ�ȴ�.
        //�̶� ȣ��Ǵ� �޼ҵ尡 destory �޼ҵ��̴�.
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
