package com.edu.member.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.edu.member.controller.MemberController;
import com.edu.member.dao.MemberDAO;
import com.edu.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	private static final Logger logger
		= LoggerFactory.getLogger(MemberController.class);

	@Inject // DAO를 사용하기 위해서 MemberDAO 객체를 주입받는다.
	MemberDAO memberDAO;

	@Override
	public String loginCheck(MemberDTO memberDTO, HttpSession session) {
		logger.info("MemberService 진입.....");
		// 데이터가 존재하면 : 이름이 넘어온다.
		// 데이터가 존재하지 않으면 : null이 넘어온다.
		String name = memberDAO.loginCheck(memberDTO);
		
		if(name != null) { // 데이터가 존재하면 => 등록된 유저임을 뜻한다.
			//세션을 발급한다.
			session.setAttribute("userid", memberDTO.getUserid());
			session.setAttribute("name",   name);
		}
		return name;
	}

	//로그아웃 => 세션 초기화
	@Override
	public void logout(HttpSession session) {
		//세션을 모두 초기화한다.
		session.invalidate();
	}

	// 회원가입
	@Override
	public void register(MemberDTO memberDTO) throws Exception {
		logger.info("MemberService register.....");
		memberDAO.register(memberDTO);

	}

	// 로그인
	@Override
	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		logger.info("MemberService login.....");
		return memberDAO.login(memberDTO);
	}

	// 회원정보 수정
	@Override
	public void memberUpdate(MemberDTO memberDTO) throws Exception {
		// 넘겨받은 회원정보를 DAO 에 넘겨준다.
		memberDAO.memberUpdate(memberDTO);
	}

	//회원 탈퇴
	@Override
	public void memberDelete(MemberDTO memberDTO) throws Exception {
		memberDAO.memberDelete(memberDTO);
	}

	// 아이디 검사
	@Override
	public int idCheck(MemberDTO memberDTO) throws Exception {
		logger.info("membersrive id check");
		int result=memberDAO.idCheck(memberDTO);
		return result;
	}
	
	
	
}




