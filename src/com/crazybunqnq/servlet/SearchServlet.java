package com.crazybunqnq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crazybunqnq.dao.impl.UserDaoImpl;
import com.crazybunqnq.entity.User;
import com.crazybunqnq.service.UserService;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = -4279315399448002795L;
	private UserService cus = new UserService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
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
		List<User> userList = null;
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String nick = request.getParameter("isnick");
		String statrTime = request.getParameter("start");
		String endTime = request.getParameter("end");
		boolean isNick = "isNick".equals(request.getParameter("isnick"))? true: false;
		if ("manager".equals(type)) {
			userList = cus.searchManager(name, isNick);
		} else if ("user".equals(type)) {
			userList = cus.searchUser(name, isNick);
		}
		//将 list 装入 request 中
				request.setAttribute("list", userList);
		//1. 获取一个转发器
		RequestDispatcher dispatcher = request.getRequestDispatcher("/KeyManager/content.jsp");
		//2.完成转发动作
		dispatcher.forward(request, response);
	}
	
	
}
