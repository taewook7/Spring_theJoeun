package com.edu.member.dao;

import com.edu.member.dto.MemberDTO;

public interface MemberDAO {

	public String loginCheck(MemberDTO memberDTO);
	
	// 회원가입
	public void register(MemberDTO memberDTO) throws Exception;
	
	// 로그인
	public MemberDTO login(MemberDTO memberDTO) throws Exception;
	
	// 회원정보 수정
	public void memberUpdate(MemberDTO memberDTO) throws Exception;

	
	//회원탈퇴
	public void memberDelete(MemberDTO memberDTO) throws Exception;
	
	//아이디 중복 체크
	public int idCheck(MemberDTO memberDTO) throws Exception;
}










