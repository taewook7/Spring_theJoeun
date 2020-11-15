package com.edu.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.edu.board.domain.BoardDTO;
import com.edu.board.domain.FileDTO;
import com.edu.board.mapper.BoardMapper;

@Service("com.edu.board.service.BoardService")
public class BoardService {
	
	@Resource(name="com.edu.board.mapper.BoardMapper")
	BoardMapper mBoardMapper;
	
	//게시글 등록 
	public int boardInsertService(BoardDTO board) throws Exception {
		return mBoardMapper.boardInsert(board);
		
	}
	// 파일 올리기
	public int fileInsertService(FileDTO file) throws Exception {
		return mBoardMapper.fileInsert(file);
	}
	
	
	// 게시글 목록 가져오기
	public List<BoardDTO> boardListService() throws Exception {
		return mBoardMapper.boardList();
	}
	
	//게시글 상세 정보 가져오기 
	public BoardDTO boardDetailService(int bno) throws Exception {
			
		
		return mBoardMapper.boardDetail(bno); 
	}
	
	//게시글에 해당하는 파일의 정보를 가져온다.
	public FileDTO fileDetailService(int bno) throws Exception {
		
		return mBoardMapper.fileDetail(bno);
	}
	
	
	// 게시글번호에 해당하는 게시글의 제목과 내용을 수정한다.
	public int boardUpdateService(BoardDTO board) throws Exception {
		return mBoardMapper.boardUpdate(board);
	}
	
	//게시글 번호에 해당하는 게시글을 삭제한다
	public int boardDeleteService(int bno) throws Exception {
		return mBoardMapper.boardDelete(bno);
	}
}


















