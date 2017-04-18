package com.crazybunqnq.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crazybunqnq.enums.Images;
import com.crazybunqnq.utils.PhotoUtil;

public class PhotoEditorServlet extends HttpServlet {

	private static final long serialVersionUID = -3427036383245697121L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PhotoEditorServlet() {
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
		RequestDispatcher rd = null;
		String forward = null;
//		String photoName = request.getParameter("photo_name");
		String photoName = "XinNian";
		String str1 = request.getParameter("str1");
		String str2 = request.getParameter("str2");
//		String str3 = request.getParameter("str2");
		String[] strs = {"包俊杰", "河畔", "何畔", "逗比"};
		String path = "e:/NR/" + Images.XinNian.toString() + ".jpg";
		String[] userInputs = new String[Images.Test.getStrCount()];
		for (int i = 0; i < userInputs.length; i++) {
			userInputs[i] = strs[i];
		}
		
		request.setAttribute("imgName", PhotoUtil.exportImg(path, userInputs, Images.XinNian, false));
		forward = "/MyPages/picResult.jsp";
		rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}
}
