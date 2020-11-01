package com.edu.member.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.member.dto.MemberDTO;
import com.edu.member.service.MemberService;

@Controller //컨트롤러 빈으로 등록
@RequestMapping("member/*")  //공통적인 url 매핑
//method=Request.Method를 지정하지않으면 기본적으로 get 매핑임 
public class MemberController {
	//로깅을 위한 변수
	//매개변수에는 자기 클래스 이름을 써주면된다. 
	
	private static final Logger logger=LoggerFactory.getLogger(MemberController.class);
	
	
	//컨트롤러는 서비스를, 서비스는 DAO를 호출한다. 
	
	@Inject
	MemberService memberService;
	
	
	//로그인 화면으로 이동
	@RequestMapping("login.do")
	public String login() {
		return "member/login"; //WEB-INF/views/member/login.jsp
	}
	
	//로그인 입력 값 검사 
	@RequestMapping("login_check.do")
	//모델은 데이터가 같이 넘어가는것이고 모델앤뷰는 데이터와 화면이 같이 넘어가는것이다. 
	
	public ModelAndView login_check(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
		logger.info("MemberController 진입.....");
		
		
		// 로그인 검사 성공 => 이름이 넘어온다,실패일 경우 =>null 이 넘어온다. 
		String name=memberService.loginCheck(memberDTO,session);
		
		//넘겨줄 값을 저장하고 넘어갈 뷰페이지를 동시에 사용
		ModelAndView mav = new ModelAndView();
		if (name!=null) { // 로그인 검사가 정상이면 시작 페이지로 이동한다.
			mav.setViewName("main");  // main=>뷰의이름 
			//뷰에 전달할 값
			mav.addObject("message",name);
		} else { //로그인 검사가 실패하였으면 login 페이지로 다시 되돌아가게 한다.
			mav.setViewName("member/login");
			//뷰에 전달할값 
			mav.addObject("message","error");
		}
		
		return mav;
	}
	
	
	//로그아웃
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session, ModelAndView mav) {
		memberService.logout(session); //세션 초기화
		mav.setViewName("member/login");  // 이동할 페이지 이름
		mav.addObject("message","logout");  // 변수에 값을 저장한다.
		return mav; 
	}
}





