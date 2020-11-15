package com.edu.board.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	private String boardInsertProc(HttpServletRequest request, @RequestPart MultipartFile files)
		throws Exception {
	
		//게시글 등록 화면에서 입력한 값들을 실어나르기 위해 BoardDTO를 생성한다.
		BoardDTO 	board	= new BoardDTO();
		FileDTO		file	= new FileDTO();
	
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		board.setWriter (request.getParameter("writer"));
		
		//업로드할 파일이 없는 경우
		if(files.isEmpty()) {
			mBoardService.boardInsertService(board); //파일없이 게시글만 올린다.
		} else { //업로드할 파일이 있는 경우
			// FilenameUtils : commons-io defendency를 사용한다.
			String	fileName			= files.getOriginalFilename();
			String	fileNameExtension	= FilenameUtils.getExtension(fileName).toLowerCase();
			File	destinationFile;
			String	destinationFileName;
			
			// fileUrl = "uploadFiles 폴더의 위치";
			// uploadFiles 폴더의 위치 확인 : uploadFiles 우클릭 -> Properties -> Resource -> Location
			String	fileUrl = "C:/workspaceSpring/SpringBootProject/src/main/webapp/WEB-INF/uploadFiles/";
			
			do {
				destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension;
				destinationFile		= new File(fileUrl + destinationFileName);
			} while(destinationFile.exists());
			
			// MultipartFile.transferTo() : 
			// 요청 시점의 임시 파일을 로컬 파일 시스템에 영구적으로 복사하다.
			destinationFile.getParentFile().mkdirs();
			files.transferTo(destinationFile);
			
			// 게시글 올리기
			mBoardService.boardInsertService(board);
			
			// 파일관련 자료를 Files 테이블에 등록한다.
			file.setBno(board.getBno());
			file.setFileName(destinationFileName);
			file.setFileOriName(fileName);
			file.setFileUrl(fileUrl);
			
			mBoardService.fileInsertService(file);
		}
		
		return "redirect:/board/list";
	}

	
	
	
	
	@RequestMapping("/insertProc2")
	private String boardInsertProc2(HttpServletRequest request, @RequestPart MultipartFile files) throws Exception {
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
			//FilenameUtils : commons-io defendency 를 사용한다.
			String fileName = files.getOriginalFilename();
			String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase();  // 확장자를 소문자로 받아온다. 
			File destinationFile;
			String destinationFileName;
			
			//파일을 올릴 위치를 잡아준다. fileUrl = "uploadFiles 폴더의 위치;
			// uploadFiles 폴더의 위치 확인 : uploadFiles 우클릭 -> Properties -> Resource -> location
			String fileUrl="C:/work_spring/SpringBootProject/src/main/webapp/WEB-INF/uploadFiles/";
			
			// 글자는 32글자로 하되 아까찾은 확장자명을 붙여준다.
			do {
				destinationFileName= RandomStringUtils.randomAlphanumeric(32) + "." +fileNameExtension;
				destinationFile = new File(fileUrl + destinationFileName);
			} while(destinationFile.exists());
			
			//MultipartFile.transferTo() : 요청 시점의 임시 파일을 로컬 파일 시스템에 영구적으로 복사하다.
			destinationFile.getParentFile().mkdirs();
			files.transferTo(destinationFile);
			
			//게시글 올리기
			mBoardService.boardInsertService(board);
			
			
			// 파일 관련 자료를 Fils 테이블에 등록한다.
			file.setBno(board.getBno());
			file.setFileName(destinationFileName);
			file.setFileOriName(fileName);
			file.setFileUrl(fileUrl);
			
			mBoardService.fileInsertService(file);
			
				
		}
		
		return "redirect:/board/list";
	}
	
	
	
	// 게시물 목록 보기 
	@RequestMapping(value="/list")
	private String boardList(Model model) throws Exception{ 
		//게시물 목록 화면을 보여주기 전에
		//보여줄 데이터를 가져와서 model 에 담는다.

		model.addAttribute("list",mBoardService.boardListService());
		
		return "/board/list";
	}
	
	
	//게시글 번호에 해당하는 상세정보화면
	@RequestMapping("/detail/{bno}")
	private String boardDetail(@PathVariable int bno,Model model) throws Exception {
		// bno에 해당하는 자료를 찾아와서 model 에 담는다. 
		model.addAttribute("detail", mBoardService.boardDetailService(bno)); // 게시글 정보
		//파일의정보 
		model.addAttribute("files",mBoardService.fileDetailService(bno));
		
		return "/board/detail";
	}
	
	// 게시글 수정 화면 
	@RequestMapping("/update/{bno}")
	// 경로에 붙었으니까 {}  pathvariable 을쓴다
	private String boardUpdateForm(@PathVariable int bno, Model model) throws Exception {
		model.addAttribute("detail",mBoardService.boardDetailService(bno));
		return "/board/update";
	}
	
	// 게시글 수정화면에서 수정한 자료를 업데이트를 한다.
	@RequestMapping("/updateProc")
	private String boardUpdateProc(HttpServletRequest request) throws Exception {
		//서비스에 넘겨줄 자료를 저장한다
		BoardDTO board = new BoardDTO();
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		board.setBno(Integer.parseInt(request.getParameter("bno")));
		
		mBoardService.boardUpdateService(board);
//		return "/board/list";
		return "redirect://board/detail/" +request.getParameter("bno");
	}
	
	// 글 번호에 해당하는 자료를 삭제한다. 
	@RequestMapping("/delete/{bno}")
	private String boardDelete(@PathVariable int bno) throws Exception {
		mBoardService.boardDeleteService(bno);
		return "redirect:/board/list";
	}
	
	
} // End - public class BoardController




















