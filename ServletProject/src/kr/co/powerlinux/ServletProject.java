package kr.co.powerlinux;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletProject")//@WebServlet("/search")�� �ٲٱ⵵ ����
// ���� ��û ������ ���� ����!!
public class ServletProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get �޼ҵ��� ��û�� ó���Ѱ�
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();//���, Ŭ���� ��Ʈ���� ���� ����
		out.print("Get method's response_����");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post ������� ��û������, ó���ϴ¾�.
		// ���ó���� �����̳ʷ� �����ȴ�.
		// ����� ������ ���Ե� ������ �����͸� �о���̷��� ��� ��Ʈ���� �ʿ��ϴ�.
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();//���, Ŭ���� ��Ʈ���� ���� ����
		out.print("Post method's response_����");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		super.doDelete(req, resp);
	}

}
