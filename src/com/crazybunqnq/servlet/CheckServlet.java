package com.crazybunqnq.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crazybunqnq.entity.User;
import com.crazybunqnq.service.CheckUserService;
import com.crazybunqnq.utils.CDKeyBuilder;

public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = -5524847119463925284L;
	private CheckUserService cku = new CheckUserService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String passwd = request.getParameter("upwd");
		String returnUri = request.getParameter("return_uri");// 用户访问登录页面之前所访问的页面，用于使用户登录后跳转回原来的页面

		System.out.println("用户名  ==》  " + uname);
		System.out.println("密    码  ==》  " + passwd);
		System.out.println("Return Uri ==》  " + returnUri);

		RequestDispatcher rd = null;
		String forward = null;

		if (uname == null || uname.equals("") || passwd == null || passwd.equals("")) {
			request.setAttribute("msg", "用户名或密码为空！");
			rd = request.getRequestDispatcher("/MyPages/Login.jsp");
		} else {
			User user = new User();
			user.setName(uname);
			user.setPassword(passwd);
			boolean bool = cku.check(user);

			if (bool) {
				CDKeyBuilder.massProduction(30, "31");
				request.getSession().setAttribute("flag", "login_success");
				if (returnUri != null) {
					forward = returnUri;
				} else {
					forward = "/MyPages/index.jsp";
				}
			} else {
				request.getSession().setAttribute("flag", "login_error");
				request.setAttribute("msg", "用户名或密码输入错误，请重新输入！");
				forward = "/MyPages/Error.jsp";
			}

			rd = request.getRequestDispatcher(forward);
		}
		rd.forward(request, response);
	}
}
