package com.edu.di03.spring;

import java.util.Date;

public class MemberRegisterService {
	//회원에 대한 정보를 처리할것이기때문에
	private MemberDao memberDao;
	
	//생성자를 통해서 객체 주입
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao=memberDao;
	}
	
	public void regist(RegisterRequest req) {
		//이메일로 회원 데이터 조회 
		Member member = memberDao.selectByEmail(req.getEmail());
		
		//같은 이메일을 가진 회원이 이미 존재한다면 익셉션을 발생시킨다.
		if(member !=null) {
			throw new AlreadyExisitingMemberException("중복된 이메일입니다. "+req.getEmail());
		}
		
		// 같은 이메일을 가진 회원이 존재하지 않으면 데이터를 등록한다.
		Member newMember = new Member(req.getEmail(),req.getPassword(),req.getName(),new Date()) ;
		memberDao.insert(newMember);
	}
	
}
