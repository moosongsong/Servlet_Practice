package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/*")
public class SecondFilter implements Filter {

    public SecondFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		System.out.println("DESTORY");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Second Filter에서 다음 필터 호출 전");
		chain.doFilter(request, response);//이 do filter는 자기 자신의 dofilter 가 아니다.
		System.out.println("Second Filter에서 다음 필터 호출 후");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("INIT");
	}

}
