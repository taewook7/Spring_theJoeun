package com.edu.member.service;

import javax.servlet.http.HttpSession;

import com.edu.member.dto.MemberDTO;

public interface MemberService {

	//아이디와 비밀번호를 가지고 등록된 유저인지 확인한다.
	public String loginCheck(MemberDTO memberDTO, HttpSession session);
	//로그 아웃
	public void logout(HttpSession session);
	
	// 회원가입
	public void register(MemberDTO memberDTO) throws Exception;
	
	// 로그인
	public MemberDTO login(MemberDTO memberDTO) throws Exception;
	
	//회원정보 수정
	public void memberUpdate(MemberDTO memberDTO) throws Exception;
	
	//회원 탈퇴 
	public void memberDelete(MemberDTO memberDTO) throws Exception;
	
	//아이디 중복 검사
	public int idCheck(MemberDTO memberDTO) throws Exception;
}








