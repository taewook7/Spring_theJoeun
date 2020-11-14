package com.edu.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.edu.board.domain.BoardDTO;
import com.edu.board.domain.FileDTO;
import com.edu.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	// inject 와 Autowired와 동일한 역할이다. 
	@Resource(name="com.edu.board.service.BoardService")
	BoardService mBoardService;
	
	
	
	// 웹 브라우저에서 http://localhost:8099/board/insert 로 호출된 경우에 처리한다.
	@RequestMapping("/insert")
	private String boardInsertForm() {
		
		return "/board/insert";
	}
	
	
	@RequestMapping("/insertProc")
	private String boardInsertProc(HttpServletRequest request, @RequestPart MultipartFile files) throws Exception {
		//게시글 등록 화면에서 입력한 값들을 실어나르기 위해 BoardDTO를 생성한다. 
		BoardDTO board = new BoardDTO();
		FileDTO file = new FileDTO();
		
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		board.setWriter(request.getParameter("writer"));
		
		//업로드할 파일이 없는 경우
		if(files.isEmpty()) {
			mBoardService.boardInsertService(board); // 게시글만 올린다. 
		} else { // 업로드할 파일이 있는 경우
			
		}
		
		return "redirect:/board/list";
	}
} // End - public class BoardController
