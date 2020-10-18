package com.edu.di01.spring;

public class ChangePasswordService {
	private MemberDao memberDao;
	
	
	//생성자를 통해서 객체 주입
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	
	public void changePassword(String email, String oldPwd,String newPwd) {
		Member member=memberDao.selectByEmail(email);
		
		//이메일에 해당하는 회원정보가 없으면 비밀번호를 변경할 수 없다.
		if(member ==null)
			//throw= 던진다 멤버낫파운드 클래스에 
			throw new MemberNotFoundException("해당되는 회원정보가 없습니다.");
			
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
	}
}
