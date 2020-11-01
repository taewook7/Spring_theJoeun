package com.edu.member.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.edu.member.controller.MemberController;
import com.edu.member.dto.MemberDTO;

@Repository  // Spring 에서 관리하는 dao bean (db와 연관)으로 설정
public class MemberDAOImpl implements MemberDAO {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	@Inject //my바티스 실행을 위한 SqlSession 객체를 주입받는다.
	SqlSession sqlSession;
	
	//어느 Mapper 와 연결 되는지 알기 위해서 namespace를 만든다.
	private static String namespace="com.edu.member.mapper.MemberMapper";
	
			
	//등록되어 있는 회원인지 검사하여, 맞으면 이름을 돌려준다.
	@Override
	public String loginCheck(MemberDTO memberDTO) {
		logger.info("멤버다오임플");
		return sqlSession.selectOne(namespace + ".login_check",memberDTO);
	}

}
