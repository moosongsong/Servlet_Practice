package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
//name은 필터이름
@WebFilter(filterName="FirstFilter", 
			urlPatterns= {"/test", "/second"},
			initParams= {
					@WebInitParam(name="encoding", value="utf-8"),
					@WebInitParam(name="contentType", value="text/html; charset=utf-8")
			})
public class FirstFilter implements Filter{
	
	private String encoding = null;
	private String content = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
		content = filterConfig.getInitParameter("contentType");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setContentType(content);
		System.out.println("First Filter에서 다음 필터 호출 전");
		chain.doFilter(request, response);//이 do filter는 자기 자신의 dofilter 가 아니다.
		System.out.println("First Filter에서 다음 필터 호출 후");
	}
	
	
	@Override
	public void destroy() {
		System.out.println("First DESTROY");
	}

	
}
