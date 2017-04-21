package com.crazybunqnq.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crazybunqnq.entity.User;
import com.crazybunqnq.service.UserService;
import com.crazybunqnq.utils.MD5Util;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = -6320156753638752483L;
	private String boyRex = "(([MmBb男公])|([Mm]ale)|([Mm]an)|([Bb]oy))";
	private String girlRex = "(([FfWwGg女母])|([Ff]emale)|([Ww]oman)|([Gg]irl))";
	private UserService cus = new UserService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("uname");
		String pwd = MD5Util.getMD5(request.getParameter("upwd"));
		String nick = request.getParameter("nick");
		String sex = formatSex(request.getParameter("sex"));
		Integer age = Integer.parseInt(request.getParameter("age"));
		String phone = request.getParameter("phone");
		String weChat = request.getParameter("wechat");
		String qq = request.getParameter("qq");

		boolean hasUser = cus.hasUser(name);

		if (hasUser) {

			return;
		}

		Date date = new Date();
		Long createTime = date.getTime();

		User user = new User(name, pwd, nick, sex, age, phone, weChat == null ? "" : weChat, qq == null ? "" : qq,
				new java.sql.Date(createTime));
		
		cus.addUser(user);
		
		hasUser = cus.hasUser(name);
		
		if (hasUser) {
			System.out.println("添加用户成功");
		} else {
			System.out.println("添加用户失败");
		}

		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	private String formatSex(String str) {
		String sex = null;
		if (str.matches(boyRex)) {
			sex = "男";
		}
		if (str.matches(girlRex)) {
			sex = "女";
		}
		return sex;
	}
}
