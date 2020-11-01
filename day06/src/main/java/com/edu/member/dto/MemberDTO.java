package com.edu.member.dto;

public class MemberDTO {
	//getter,setter,toString() 를 만든다.
	
	private String userid;
	private String passwd;
	private String name;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", passwd=" + passwd + ", name=" + name + "]";
	}
	
	
	
	//생성자는 초기화 역할을 함 
	public MemberDTO() {
		
	}
	
	
	
	
	
	
	
	
	
}
