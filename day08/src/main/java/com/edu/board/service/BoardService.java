package com.edu.board.service;

import java.util.List;

import com.edu.board.dto.BoardDTO;

public interface BoardService {
	//게시글 작성
	public void			insert(BoardDTO boardDTO)	throws Exception;
	//게시글 목록 보기
	public List<BoardDTO>	listAll()				throws Exception;
	//게시글 상세보기
	//게시글번호를 넘겨주고, 그 번호에 해당하는 데이터를 모두 받아온다.
	public BoardDTO		detail(Integer b_no)		throws Exception;
	
	//게시글 번호에 해당하는 자료 삭제하기
	public void			delete(Integer b_no)		throws Exception;
	
	//게시글 정보 수정
	public void			update(BoardDTO boardDTO)	throws Exception;
}













