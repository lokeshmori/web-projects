package com.servlet;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.StudentDao;
import com.entity.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String qualification = req.getParameter("qualification");
		
		Student student = new Student(name, dob, email, address,qualification);
		
		StudentDao dao =new StudentDao(DBConnect.getConn());
		
		HttpSession session = req.getSession();
		
		boolean f = dao.addStudent(student);
		
		if(f) {
			session.setAttribute("succMsg" , "Student Details submit sucessfuly...");
			resp.sendRedirect("add_student.jsp");
			
			//System.out.println("Student Details submit sucessfuly...");
		}else {
			session.setAttribute("errorMsg" , "Something wrong on server....");
			resp.sendRedirect("add_student.jsp");
			
		//	System.out.println("Something wrong on server... ");
		}
		
		
	}
}