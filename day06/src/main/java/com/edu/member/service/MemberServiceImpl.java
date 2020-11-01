package com.edu.member.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.edu.member.controller.MemberController;
import com.edu.member.dao.MemberDAO;
import com.edu.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
		private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
		
		
		@Inject // 서비스를 사용하기 위해서 MemberDAO  객체를 주입받는다.
		MemberDAO memberDAO;
	
	
	

	@Override
	public String loginCheck(MemberDTO memberDTO, HttpSession session) {
		// 데이터가 존재하면 : 이름이 넘어온다. 
		// 데이터가 존재하지 않으면 : null이 넘어온다.
		String name=memberDAO.loginCheck(memberDTO);
		
		if (name!=null) { //데이터가 존재하면 => 등록된 유저임을 뜻한다.
			//세션을 발급한다.
			session.setAttribute("userid", memberDTO.getUserid());
			session.setAttribute("name", name);
		}
		
		return name;
	}



	// 로그아웃 => 세션 초기화 
	@Override
	public void logout(HttpSession session) {
		//세션을 모두 초기화 한다.
		session.invalidate();
	}
	
	
	
	

}
