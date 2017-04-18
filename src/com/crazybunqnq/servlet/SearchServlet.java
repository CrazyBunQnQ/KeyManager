package com.crazybunqnq.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crazybun.service.SearchService;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		String type = request.getParameter("type");
		String keyWord = request.getParameter("keyword");
		switch (type) {
		case "user":
			if (keyWord != "" || keyWord != null) {
				SearchService ss = new SearchService();
				String reuslt = ss.searchUser(keyWord).toString();
				PrintWriter pw = response.getWriter();
				pw.write(reuslt);
				pw.flush();
				pw.close();
			}
			break;

		default:
			break;
		}
	}
}
