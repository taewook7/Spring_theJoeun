package com.edu.member.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.edu.member.controller.MemberController;
import com.edu.member.dto.MemberDTO;

@Repository //Spring에서 관리하는 dao bean(db와 연관)으로 설정
public class MemberDAOImpl implements MemberDAO {

	private static final Logger logger
		= LoggerFactory.getLogger(MemberController.class);
	
	@Inject // mybatis실행을 위한 SqlSession 객체를 주입받는다.
	SqlSession sqlSession;
	
	// 어는 Mapper와 연결되는지 알기 위해서 namespace를 만든다.
	private static String namespace = "com.edu.member.mapper.MemberMapper";

	//등록되어 있는 회원이지 검사하여, 맞으면 이름을 돌려준다.
	@Override
	public String loginCheck(MemberDTO memberDTO) {
		logger.info("MemberDAO 진입.....");
		return sqlSession.selectOne(namespace + ".login_check", memberDTO);
	}
	
	// 회원가입
	@Override
	public void register(MemberDTO memberDTO) throws Exception {
		logger.info("MemberDAO register.....");
		logger.info("Member : " + memberDTO);
		//sqlSession.insert("memberMapper.register", memberDTO);
		sqlSession.insert(namespace + ".register", memberDTO);
	}

	// 로그인
	@Override
	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		logger.info("MemberDAO login.....");
		return sqlSession.selectOne(namespace + ".login", memberDTO);
	}

	
	//회원정보수정
	@Override
	public void memberUpdate(MemberDTO memberDTO) throws Exception {
		logger.info("멤버업데이트 회원정보 수정문");
		// memberDTO 에 담긴 내용을 
		sqlSession.update(namespace + ".memberUpdate", memberDTO);
	}

	//회원탈퇴
	@Override
	public void memberDelete(MemberDTO memberDTO) throws Exception {
		logger.info("멤버 delete문 멤버다오임플");
		sqlSession.delete(namespace+ ".memberDelete", memberDTO);
		
	}

	//아이디 중복 체크 
	@Override
	public int idCheck(MemberDTO memberDTO) throws Exception {
		logger.info("멤버다오 아이디 체크");
		int result=sqlSession.selectOne(namespace+ ".idCheck",memberDTO);
		return result;
	}


	

}













