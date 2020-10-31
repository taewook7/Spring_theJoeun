package com.edu.board.dao;

import java.util.List;

import com.edu.board.dto.BoardDTO;

public interface BoardDAO {
	//게시글 작성
	public void insert(BoardDTO boardDTO) throws Exception;
	
	//게시물 목록 보기
	public List<BoardDTO> listAll() throws Exception;

	//게시물 상세 보기
	public BoardDTO detail(Integer b_no) throws Exception;
	
	//게시글 삭제하기
	public void delete(Integer b_no) throws Exception;
	
	
	
}
