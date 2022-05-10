package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    try {
	        
	        String fname = request.getParameter("user");
			String password = request.getParameter("password");

			Class.forName("com.mysql.jdbc.Driver");

			Connection c = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/gadgetbudget?characterEncoding=latin1", "root", "");

			PreparedStatement ps = (PreparedStatement) c
					.prepareStatement("select * from User where first_name=? and password=?");
			ps.setString(1, fname);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				response.sendRedirect("index.jsp");
				return;
			}
			response.sendRedirect("error.html");
			return;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection c = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/electrogrid?characterEncoding=latin1", "root", "");

			PreparedStatement ps = (PreparedStatement) c
					.prepareStatement("select * from employee where email=? and password=?");
			ps.setString(1, fname);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				response.sendRedirect("index.jsp");
				return;
			}
			response.sendRedirect("error.html");
			return;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

}
}