package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Reset")
public class Reset extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		String s=request.getParameter("email");
		String password=request.getParameter("password");
		String password1=request.getParameter("password1");
		
		
		if(password.equals(password1)){
			try{
				Connection con=ConProvider.getConnection();
				
				PreparedStatement ps=con.prepareStatement("update company_mailer_user set password=? where email=? ");
				ps.setString(1, password);
				ps.setString(2,s);
				ps.executeUpdate();
				out.println("successfully changed ur password");
				}catch(Exception e){
					out.println(e);
				}
			System.out.println("matched");
		}
		
	}
}
