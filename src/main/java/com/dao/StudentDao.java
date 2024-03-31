package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Student;

public class StudentDao   {

	 private Connection conn; // object

	public StudentDao(Connection conn) {
		super();
		this.conn = conn;
	}
	 
	public boolean addStudent(Student student) {
		boolean f = false ;
		
		try {
			
			String sql = " insert into student_mg(name,dob,email,address,qualification) values(?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, student.getFulName());
			ps.setString(2, student.getDob());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getAddress());
			ps.setString(5, student.getQualification());
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				 f =true ;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return f ;
	}
	
	public List<Student> getAllStudent(){
		
		List<Student> list = new ArrayList<Student>();
		Student s = null;
		
		try {
			
			String sql = "select * from student_mg";
			
			PreparedStatement ps =conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				s =new Student();
				
				s.setId(rs.getInt(1));
				s.setFulName(rs.getString(2));
				s.setDob(rs.getString(3));
				s.setEmail(rs.getString(4));
				s.setAddress(rs.getString(5));
				s.setQualification(rs.getString(6));
				list.add(s);
				
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		return list ;
	}
	
	
	public Student getStudentById(int id) {
		
		Student s = null ;
		

		
		try {
			
			String sql = "select * from student_mg where id=?";
			
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				s = new Student();
				
				s.setId(rs.getInt(1));
				s.setFulName(rs.getString(2));
				s.setDob(rs.getString(3));
				s.setEmail(rs.getString(4));
				s.setAddress(rs.getString(5));
				s.setQualification(rs.getString(6));
				
				
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return s ;
	}
	
	
	
	public boolean updateStudent(Student student) {
		boolean f = false ;
		
		try {
			
			String sql = " update student_mg set name=?,dob=?,email=?,address=?,qualification=? where id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, student.getFulName());
			ps.setString(2, student.getDob());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getAddress());
			ps.setString(5, student.getQualification());
			ps.setInt(6, student.getId());
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				 f =true ;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return f ;
	}
	 
	public boolean deleteStudent(int id) {
		
		boolean f = false ;
		
		try {
			
			String sql ="delete from student_mg where id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				
				f = true ;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f ;
	}
	 
	
}
