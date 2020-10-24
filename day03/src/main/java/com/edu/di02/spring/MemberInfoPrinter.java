package com.edu.di02.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberInfoPrinter {
//	@Autowired // 필드에 자동주입 
	@Autowired(required=false) 
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	//스프링에서 설정에서는 설정 메서드를 기준으로 프로퍼티 이름을 정한다
	// <property name="memberDao" .... /> 설정을 사용한다.
	public void setMemberDao(MemberDao memDao) {
		this.memberDao = memDao;
	}

	@Autowired //메서드에 자동주입 
//	@Qualifier("sysout")  // 똑같은 타입의 객체를 구분하기 위해서 
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	
	// 이메일에 해당하는 회원의 정보를 출력하는 메서드
	public void printMemberInfo(String email) {
		//전달받은 이메일에 해당하는 회원의 정보가 있는가 검사한다.
		Member member=memberDao.selectByEmail(email);
		if (member==null) {
			System.out.println("이메일에 해당하는 회원의 정보가 없습니다.");
			return;

		}
		printer.print(member);
		System.out.println("회원정보가 출력되었습니다.");
	}
}
