package com.entity;

public class Student {

	 private int id ;
	 private String fulName;
	 private String dob ;
	 private String email ;
	 private String Address ;
	 private String Qualification ;
	
	 public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String fulName, String dob, String email, String address, String qualification) {
		super();
		this.fulName = fulName;
		this.dob = dob;
		this.email = email;
		Address = address;
		Qualification = qualification;
	}
	

	public Student(int id, String fulName, String dob, String email, String address, String qualification) {
		super();
		this.id = id;
		this.fulName = fulName;
		this.dob = dob;
		this.email = email;
		Address = address;
		Qualification = qualification;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFulName() {
		return fulName;
	}

	public void setFulName(String fulName) {
		this.fulName = fulName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getQualification() {
		return Qualification;
	}

	public void setQualification(String qualification) {
		Qualification = qualification;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fulName=" + fulName + ", dob=" + dob + ", email=" + email + ", Address="
				+ Address + ", Qualification=" + Qualification + "]";
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
