package com.crazybunqnq.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PermissionFilter implements Filter {

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

	/**
	 * Default constructor.
	 */
	public PermissionFilter() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String servletPath = req.getServletPath();

		HttpSession session = req.getSession();
		String flag = (String) session.getAttribute("flag");

		if (servletPath != null && (servletPath.equals("/MyPages/Login.jsp") || servletPath.equals("/MyPages/index.jsp") || servletPath.equals("/CheckServlet") || servletPath.equals("/SearchServlet") || servletPath.equals("/PhotoEditor") || servletPath.substring(0, 12).equals("/MyPages/pic"))) {
			chain.doFilter(request, response);
		} else {
			if (flag != null && flag.equals("login_success")) {
				chain.doFilter(request, response);
			} else if (flag != null && flag.equals("login_error")) {
				req.setAttribute("msg", "登录失败，请重新登陆！！！<br/>");
				req.setAttribute("return_uri", servletPath);
				RequestDispatcher rd = req.getRequestDispatcher("/MyPages/Login.jsp");
				rd.forward(req, resp);
			} else {
				req.setAttribute("msg", "您尚未登录！！！");
				req.setAttribute("return_uri", servletPath);
				RequestDispatcher rd = req.getRequestDispatcher("/MyPages/Login.jsp");
				rd.forward(req, resp);
			}
		}
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}
}
