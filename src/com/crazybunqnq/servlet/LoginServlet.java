package com.crazybunqnq.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crazybunqnq.entity.User;
import com.crazybunqnq.service.UserService;
import com.crazybunqnq.utils.MD5Util;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -5524847119463925284L;
	private UserService cus = new UserService();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("CheckServlet 正在为你服务");
		super.service(req, res);
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
		/*
		this.getServletConfig().getInitParameter("charset");
		
		response.setContentType("text/html;charset=utf-9");
		PrintWriter out = response.getWriter();//获取服务器的输出流
		OutputStream os = response.getOutputStream();//输出字符流
		*/
		String uname = request.getParameter("uname");
		String passwd = MD5Util.getMD5(request.getParameter("upwd"));
		String returnUri = request.getParameter("return_uri");// 用户访问登录页面之前所访问的页面，用于使用户登录后跳转回原来的页面

		System.out.println("用户名  ==》  " + uname);
		System.out.println("密    码  ==》  " + passwd);
		System.out.println("Return Uri ==》  " + returnUri);

		RequestDispatcher rd = null;
		String forward = null;

		if (uname == null || uname.equals("") || passwd == null || passwd.equals("")) {
			request.setAttribute("msg", "用户名或密码为空！");
			rd = request.getRequestDispatcher("/KeyManager/login.jsp");
		} else {
			User user = new User();
			user.setName(uname);
			user.setPwd(passwd);
			boolean bool = cus.checkPwd(user);

			if (bool) {
				request.getSession().setAttribute("flag", "login_success");
				if (returnUri != null) {
					forward = returnUri;
				} else {
					forward = "/KeyManager/index.html";
				}
			} else {
				request.getSession().setAttribute("flag", "login_error");
				request.setAttribute("msg", "用户名或密码输入错误，请重新输入！");
				forward = "/KeyManager/Error.jsp";
			}

			rd = request.getRequestDispatcher(forward);
		}
		rd.forward(request, response);
	}
}
