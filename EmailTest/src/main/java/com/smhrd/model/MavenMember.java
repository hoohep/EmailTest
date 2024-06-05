package com.smhrd.model;

public class MavenMember {

	private String id;
	private String pw;
	private String email;
	private String emailHash;
	private String name;
	
	
	public MavenMember(String id, String pw, String email, String emailHash, String name) {
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.emailHash = emailHash;
		this.name = name;
	}
	public MavenMember(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public MavenMember(String name, String email, String emailHash) {
		this.name = name;
		this.email = email;
		this.emailHash = emailHash;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailHash() {
		return emailHash;
	}

	public void setEmailHash(String emailHash) {
		this.emailHash = emailHash;
	}
}
