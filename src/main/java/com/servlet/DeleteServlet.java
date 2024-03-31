package com.servlet;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	@Override
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		int id = Integer.parseInt(req.getParameter("id"));
		
		StudentDao dao = new StudentDao(DBConnect.getConn()) ;
		
		HttpSession session = req.getSession();
		    boolean f = dao.deleteStudent(id);
		    
		    if(f) {
				session.setAttribute("succMsg" , "Student Details delete sucessfuly...");
				resp.sendRedirect("index.jsp");
				
				//System.out.println("Student Delete sucessfuly...");
			}else {
				session.setAttribute("errorMsg" , "Something wrong on server....");
				resp.sendRedirect("index.jsp");
				
			//	System.out.println("Something wrong on server... ");
			}
		
	}
}
