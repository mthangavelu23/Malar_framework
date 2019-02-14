package com.training.bean;

public class LoginBean {
	private String fname;
	private String lname;
	private String email;
	private String phone;
	private String userlogin;
	private String password;

	public LoginBean() {
	}

	public LoginBean(String fname, String lname,String email,String phone,String userlogin,String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.userlogin = userlogin;
		this.password = password;
	}

	public String getFirstName() {
		return fname;
	}

	public void setFirstName(String fname) {
		this.fname = fname;
	}

	public String getLastName() {
		return lname;
	}
	public void setLastName(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
		
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserLogin() {
		return password;
	}
	public void setUserLogin(String userlogin) {
		this.userlogin = userlogin;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginBean [FirstName=" + fname + ", LastName=" + lname + ",Email=\" + email + \", Phone=\" + phone + \",UserLogin=\" + userlogin + \", Password=\" + password + \"]";
	}

}
