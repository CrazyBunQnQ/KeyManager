package com.crazybunqnq.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -6175648996890350478L;

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String userName = req.getParameter("uname");
//		String password = req.getParameter("upwd");
//
//		System.out.println("用户名 ==> " + userName);
//		System.out.println("密码 ==> " + password);
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("======进入doGet方法======");
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("======进入doPost方法======");
		// resp.setContentType("text/html;charset=utf-8");
		String userName = req.getParameter("uname");
		String password = req.getParameter("upwd");
		System.out.println("用户名 ==> " + userName);
		System.out.println("密码 ==> " + password);

		String forward = null;
		if ("crazybao".equals(userName) && "123456".equals(password)) {
			// 请求转发
			forward = "KeyManager/index.html";
			RequestDispatcher rd = req.getRequestDispatcher(forward);
			rd.forward(req, resp);

			// 请求重定向
			// resp.sendRedirect(req.getContextPath() + "/MyPages/Success.jsp");
		} else {
			// 请求转发
			forward = "KeyManager/login.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(forward);
			rd.forward(req, resp);

			// 请求重定向
			// resp.sendRedirect(req.getContextPath() + "/MyPages/Error.jsp");
		}
	}

}
