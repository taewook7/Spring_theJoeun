package com.edu.di01.spring;

import java.util.Collection;

public class MemberListPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public MemberListPrinter(MemberDao memberDao,MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer=printer;
	}
	
	public void printAll() {
		//memberDao.selectAll() 메서드를 사용하여 모든 회원의 정보를 가져온다.
		Collection<Member> members=memberDao.selectAll();
		
		
		//향상된 for문 
		// 콜론앞에 m 은 한개를 가리키는 변수이고. 
		// 데이터가 없을때까지 for문이 돌아간다.
		for(Member m:members) {
			printer.print(m);
		}
	}
}
