package com.crazybunqnq.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

public class AjaxServlet extends HttpServlet {

	private static final long serialVersionUID = 7382943479190950304L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjaxServlet() {
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

		JsonObject object = new JsonObject();
		object.addProperty("data", "");
		String data = "{'isAdmin':'true', 'usename':wsf}";

		PrintWriter writer = response.getWriter();
		writer.write(data); // 这里是你要返回的字符串
		writer.flush();
		writer.close();
	}
}
