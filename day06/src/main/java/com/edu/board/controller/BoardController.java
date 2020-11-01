package com.edu.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.board.dto.BoardDTO;
import com.edu.board.service.BoardService;

@Controller
@RequestMapping("/board") //url 주소에서 /board로 시작되는 것은 여기서 처리한다.
public class BoardController {

	//Controller -> Service -> DAO -> Mapper
	//Controller -> View
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject //Service를 주입받는다.
	private BoardService service;
	
	//게시글 작성
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertGet() throws Exception {
		return "/board/insert";
		/* servlet-context.xml에 들어있는 정보를 가지고 페이지로 이동한다.
		<beans:property name="prefix" value="/WEB-INF/views/" />
		<beans:property name="suffix" value=".jsp" />
		/WEB-INF/views/board/insert.jsp
		 */
	}
	
	
	//게시글 작성
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertPost(BoardDTO board) throws Exception{
		logger.info(board.toString());
		
		//서비스에게 board 정보를 주어 일을 시킨다. 
		service.insert(board);
		return "redirect:/board/list";

	}
	
	//게시글 목록보기
	@RequestMapping(value="/list", method=RequestMethod.GET )
	public void list(Model model) throws Exception {
		List<BoardDTO> list=null; // 게시글 데이터를 저장하기 위한 변수
		//게시글 목록을 가져오기 위해서 서비스에게 일을 시킨다.
		list =service.listAll();
		//찾아온 값을 Model 에 저장하면 목록화면으로 이동한다
//		return "/board/list"; // WEB-INF/views/board/list.jsp
		// servlet-context.xml 이 접두어와 접미어를 붙여서 경로와 파일명을 완성시켜준다.
		model.addAttribute("list",list);
	}
	//게시글 상세 조회
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public void getView(@RequestParam("b_no") int b_no, Model model) throws Exception {
		BoardDTO boardDTO = null;
		boardDTO = service.detail(b_no);
		
		
		logger.info("View : "+boardDTO);
		model.addAttribute("boardDTO",boardDTO);
	}
	
	//게시글 삭제
	//삭제할 게시글 번호를 받아서 서비스한테 게시글번호에 해당하는 자료를 삭제하도록 의뢰한다.
	@RequestMapping("/delete")
	public String delete(@RequestParam("b_no") int b_no) throws Exception {
		logger.info("delete........." + Integer.toString(b_no));
		service.delete(b_no);
		return "redirect:/board/list";
	}
	
	//게시글 수정
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String postUpdate(BoardDTO boardDTO) throws Exception {
		logger.info("컨트롤러 업데이트문");
		
		service.update(boardDTO);
		return "redirect:/board/list";
	}
	
	
	
	
	
	
	
	
	
	
	
}
















