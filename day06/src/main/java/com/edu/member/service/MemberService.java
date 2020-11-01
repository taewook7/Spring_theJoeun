package com.edu.member.service;

import javax.servlet.http.HttpSession;

import com.edu.member.dto.MemberDTO;

public interface MemberService {
	//아이디와 비밀번호를 가지고 등록된 유저인지 확인한다.
	public String loginCheck(MemberDTO memberDTO,HttpSession session);
	
	public void logout(HttpSession session);
	
}
