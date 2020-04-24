package kr.co.moosong.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ServiceController {
	public abstract String doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
