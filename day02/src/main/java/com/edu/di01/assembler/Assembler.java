package com.edu.di01.assembler;

import com.edu.di01.spring.ChangePasswordService;
import com.edu.di01.spring.MemberDao;
import com.edu.di01.spring.MemberRegisterService;

public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	
	//Assembler 객체가 생성될 때, 기술한 객체도 같이 생성된다. 
	public Assembler() {
		memberDao=new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService(memberDao);
	}


	public MemberDao getMemberDao() {
		return memberDao;
	}


	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}


	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}


	public void setRegSvc(MemberRegisterService regSvc) {
		this.regSvc = regSvc;
	}


	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}


	public void setPwdSvc(ChangePasswordService pwdSvc) {
		this.pwdSvc = pwdSvc;
	}
	
	
	
	
}






















