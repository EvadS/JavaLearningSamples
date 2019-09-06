package com.concretepage;

public class AuthService {
	private String user;
	private String pwd;
	private String appName;

	public AuthService(String user, String pwd, String appName) {
		this.user = user;
		this.pwd = pwd;
		this.appName = appName;
		System.out.println("User: " + this.user + ", Password: " + this.pwd);
		System.out.println("App Name: " + appName);
	}

	public String getUser() {
		return user;
	}

	public String getPwd() {
		return pwd;
	}

	public String getAppName() {
		return appName;
	}
}
