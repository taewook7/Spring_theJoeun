package com.edu.di02.spring;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {
	//회원에 대한 정보를 처리할것이기때문에
	private MemberDao memberDao;
	
	
//	@Autowired
	@Autowired(required=false)  // 시작할때 매개변수가 없는상태에서 기본생성자로 만들어주겠다 라는 뜻이다.
	//생성자를 통해서 객체 주입
	//멤버 레지스터서비스를 사용하려면 내부적으로 멤버 다오가  필요하다.
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao=memberDao;
	}
	
	
	//기본생성자 추가 
	public MemberRegisterService() {}
	
	
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
