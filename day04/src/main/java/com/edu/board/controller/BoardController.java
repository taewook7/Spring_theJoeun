package com.edu.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.board.dto.BoardDTO;

//컨트롤러 역할을 하는 빈이다 라고 해서 어노테이션을 붙여준다.
@Controller
@RequestMapping("/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	
	//Controller => service 를 갔다가 => dao 를 갔다가 =>mapper 
	//controller => view 
	
	//@Inject // Service를 주입받는다. 
	//private BoardService service;
	
	
	//게시글 작성 화면
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insertGet() throws Exception {
		return "board/insert";
		/* servlet-context.xml 에 들어있는 정보를 가지고 페이지를 이동한다.
		 * prefix,suffix
		 *  /WEB-INF/views/board/insert.jsp
		 */
		
		
	}
	
	//게시글 작성 
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public void insertPost(BoardDTO board) throws Exception {
		logger.info(board.toString());
	}
	
	//서비스에게 board 정보를 주어 일을 시킨다.
	
	
}




















