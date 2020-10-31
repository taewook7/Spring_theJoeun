package com.edu.board.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.edu.board.controller.BoardController;
import com.edu.board.dao.BoardDAO;
import com.edu.board.dto.BoardDTO;

@Service // 서비스 역할을 하는 빈으로 등록하기 위해 @Service를 기술한다. 
public class BoardServiceImpl implements BoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public void insert(BoardDTO boardDTO) throws Exception {
		boardDAO.insert(boardDTO);
	}

	@Override
	public List<BoardDTO> listAll() throws Exception {
		return boardDAO.listAll();
	}

	@Override
	public BoardDTO detail(Integer b_no) throws Exception {
		return boardDAO.detail(b_no);
		
	}

	@Override
	public void delete(Integer b_no) throws Exception {
		logger.info("BoardService: " + b_no);
		boardDAO.delete(b_no);
	
	}
	
	
	
	
}
