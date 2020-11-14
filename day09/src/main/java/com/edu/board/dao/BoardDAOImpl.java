package com.edu.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.edu.board.controller.BoardController;
import com.edu.board.dto.BoardDTO;

@Repository // @Repository는 DB와 관련된 빈
public class BoardDAOImpl implements BoardDAO {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private SqlSession sqlSession;
	
	// **** namespace의 내용이 Mapper에 기술된 내용과 같아야 한다.
	private static String namespace = "com.edu.board.mapper.BoardMapper";
	
	@Override
	public void insert(BoardDTO boardDTO) throws Exception {
		logger.info("BoardDAO : " + boardDTO);
		sqlSession.insert(namespace + ".insertBoard", boardDTO);
	}

	@Override
	public List<BoardDTO> listAll() throws Exception {
		return sqlSession.selectList(namespace + ".listBoard");
		//return sqlSession.selectList("com.edu.board.mapper.BoardMapper.listBoard");
	}

	@Override
	public BoardDTO detail(Integer b_no) throws Exception {
		logger.info("BoardDAO : " + b_no);
		return sqlSession.selectOne(namespace + ".detailBoard", b_no);
	}

	@Override
	public void delete(Integer b_no) throws Exception {
		logger.info("BoardDAO : " + b_no);
		sqlSession.delete(namespace + ".deleteBoard", b_no);
	}

	@Override
	public void update(BoardDTO boardDTO) throws Exception {
		sqlSession.update(namespace + ".updateBoard", boardDTO);
		
	}
	
	

}














