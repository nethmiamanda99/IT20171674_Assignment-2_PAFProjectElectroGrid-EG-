package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeAPI")
public class EmployeeAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Employee empObj = new Employee();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeAPI() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		Employee empobj = new Employee();
		
		String output = "";
		output = empobj.readEmployees();
		
		response.getWriter().append(output);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String output = empObj.insertEmployees(
				request.getParameter("first_name"),
				request.getParameter("last_name"),
				request.getParameter("email"),
				request.getParameter("user_role"),
				request.getParameter("password"));
		response.getWriter().write(output);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = "";
		if (paras.get("hididSave") != null) {
		output = empObj.updateEmployees(
				paras.get("hididSave").toString(),
				paras.get("first_name").toString(),
				paras.get("last_name").toString(),
				paras.get("email").toString(), 
				paras.get("user_role").toString(), 
				paras.get("password").toString());
		}
		else {
			output = empObj.updateEmployees(
					request.getParameter("hididSave"),
					request.getParameter("first_name"),
					request.getParameter("last_name"),
					request.getParameter("email"),
					request.getParameter("user_role"), 
					request.getParameter("password"));
		}
		response.getWriter().write(output);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = "";
		
		if (paras.get("id") != null) {
			output = empObj.deleteEmployees(paras.get("id").toString());
		}
		else {
			
			output = empObj.deleteEmployees(request.getParameter("id"));
		}
		System.out.println("ID: " + output);
		response.getWriter().write(output);
	}

	private static Map getParasMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			for (String param : params) {

				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		} catch (Exception e) {
		}
		return map;
	}

}
