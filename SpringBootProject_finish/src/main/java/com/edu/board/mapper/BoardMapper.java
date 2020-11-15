package com.edu.board.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.board.domain.BoardDTO;
import com.edu.board.domain.FileDTO;

@Repository("com.edu.board.mapper.BoardMapper")
public interface BoardMapper {
	// 게시글 작성
	public int boardInsert(BoardDTO board) throws Exception;
	
	
	//파일 올리기
	public int fileInsert(FileDTO file) throws Exception;
	
	//게시글 목록 보기
	public List<BoardDTO> boardList() throws Exception;
	
	//게시글 상세 정보 가져오기
	public BoardDTO boardDetail(int bno) throws Exception;
	
	//게시글에 해당하는 File의 정보를 가져온다
	public FileDTO fileDetail(int bno) throws Exception;
	
	
	//게시글 번호에 해당하는 제목과 내용을 수정한다
	public int boardUpdate(BoardDTO board) throws Exception;
	
	//게시글 번호에 해당하는 글을 삭제한다.
	public int boardDelete(int bno) throws Exception;
}
