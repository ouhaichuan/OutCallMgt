package cn.info.platform.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.info.platform.entity.User;

public class RightFilter implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
		User user = (User) httpServletRequest.getSession(true).getAttribute(
				"user");
		if (!isExcludePages(httpServletRequest.getRequestURI())) {
			if (user == null) {
				PrintWriter out = httpServletResponse.getWriter();
				out.println("<script   language=javascript>");
				out.println("window.open('login.jsp','_top')");
				out.println("</script>");
				return;
			}
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}

	private boolean isExcludePages(String url) {
		return url.indexOf("login.dhtml") != -1
				|| url.indexOf("logout.dhtml") != -1
				|| url.indexOf("login.jsp") != -1 || url.endsWith(".css")
				|| url.endsWith(".js") || url.endsWith(".gif")
				|| url.endsWith(".jpg") || url.endsWith(".png");
	}

	public void destroy() {
	}
}
