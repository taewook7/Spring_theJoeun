package com.edu.member.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edu.member.dto.MemberDTO;
import com.edu.member.service.MemberService;

@Controller //컨트롤러 빈으로 등록
@RequestMapping("member/*") //공통적인 url 매핑
public class MemberController {

	//로깅을 위한 변수
	private static final Logger logger
		= LoggerFactory.getLogger(MemberController.class);
	
	//컨트롤러는 서비스를, 서비스는 DAO를 호출한다.
	@Inject
	MemberService memberService;
	
	//로그인 화면으로 이동
	@RequestMapping("login.do")
	public String login() {
		return "member/login";	// WEB-INF/views/member/login.jsp로 이동
	}
	
	//로그인 입력 값 검사
	@RequestMapping("login_check.do")
	public ModelAndView login_check(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
		logger.info("MemberController 진입.....");
		
		//로그인 검사 성공 => 이름이 넘어온다, 실패일 경우 => null이 넘어온다.
		String name = memberService.loginCheck(memberDTO, session);
		
		//넘겨줄 값을 저장하고 넘어갈 뷰페이지를 동시에 사용.
		ModelAndView mav = new ModelAndView();
		if(name != null) {	// 로그인 검사가 정상이면 시작 페이지로 이동한다.
			mav.setViewName("main"); //main => 뷰의 이름
			//뷰에 전달할 값
			mav.addObject("message", name);
		} else { //로그인 검사를 실패하였으면 login 페이지로 다시 되돌아가게 한다.
			mav.setViewName("member/login");
			//뷰에 전달할 값
			mav.addObject("message", "error");
		}
		return mav;
	}
	
	//로그아웃
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session, ModelAndView mav) {
		memberService.logout(session);		//세션 초기화
		mav.setViewName("member/login"); 	//이동할 페이지 이름
		mav.addObject("message", "logout");	//변수에 값을 저장한다.
		return mav;	//페이지 이동
	}
	
	// 회원가입 get
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void getRegister() throws Exception {
		logger.info("get register");
	}
	
	// 회원가입 post
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(MemberDTO memberDTO) throws Exception {
		logger.info("post register");
		
		memberService.register(memberDTO);
		
		return null;
	}

	// 로그인 get
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public void getLogin() throws Exception {
		logger.info("MemberController login GET....");
	}
	
	// 로그인 post
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(MemberDTO memberDTO, HttpServletRequest req,
			RedirectAttributes rttr) throws Exception {
		
		HttpSession session = req.getSession();
		//넘겨받은 회원정보를 가지고 Service에게 의뢰한다.
		MemberDTO login = memberService.login(memberDTO);
		
		//해당하는 회원정보가 없으면
		if(login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("mgs", false);
		} else {
			// 로그인이 정상이라면 세션을 발급한다.
			session.setAttribute("member", login);
		}
		return "/member/login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		//로그아웃 버튼을 눌렀을 경우, 세션을 없앤다.
		session.invalidate();
		return "redirect:/member/login";
	}
	
	
	// 회원정보수정
	@RequestMapping(value="/memberUpdateView", method=RequestMethod.GET)
	public String memberUpdateView() throws Exception {
		logger.info("membercontroller memberUpdateView......");
		return "/member/memberUpdateView";
	}
	
	//회원정보 수정 POST
	@RequestMapping(value="/memberUpdate", method=RequestMethod.POST)
	public String memberUpdate(MemberDTO memberDTO, HttpSession session) throws Exception {
		logger.info("멤버 업데이트 포스트방식이다.");
		memberService.memberUpdate(memberDTO);
		//회원정보가 수정이 되었으면 세션을 없애고, 다시 로그인을 하게한다.
		session.invalidate(); // 세션을 없애는 메소드 
		return "redirect:/member/login";
	}
	
	//회원 탈퇴 GET
	@RequestMapping(value="/memberDeleteView",method=RequestMethod.GET)
	public String memberDeleteView() throws Exception {
		return "member/memberDeleteView";
	}
	
	//회원 탈퇴 POST
	@RequestMapping(value="/memberDelete",method=RequestMethod.POST)
	public String memberDelete(MemberDTO memberDTO, HttpSession session, RedirectAttributes rttr) throws Exception {
		
		// 세션에 들어있는 정보를 member변수에 저장한다.
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		
		//세션에 있는 비밀번호를 추출한다.
		String sessionPass = member.getPasswd();
		
		//memberDTO 에 들어있는 비밀번호(memberDeleteView 에서 입력한 비밀번호)
		String memberDTOPass = memberDTO.getPasswd();
		
		//세션에는 회원에 대한 모든 정보(아이디, 비밀번호, 이름)이 들어있기 때문에 테이블을 다시 검색하지 않아도 된다.
		//세션에 담겨있는 비밀번호와 탈퇴하기 위해서 입력한 비밀번호를 비교합니다.
		if( !(sessionPass.equals(memberDTOPass)) ) {
			rttr.addFlashAttribute("msg", false);
			return "redirect:/member/memberDeleteView";
		}
		// 회원탈퇴로직을 수행한다.
//		memberService.memberDelete(memberDTO);
		
		
		
		//회원 탈퇴가 완료되었으므로 세션을 없앤다. 
		session.invalidate();
		
		return "redirect:/member/login";
	}
	
	// 아이디 중복 검사 
	@ResponseBody // 보여줄 페이지가 존재하지 않더라도 내용을 보여줄 수 있다.
	@RequestMapping(value="/idCheck",method=RequestMethod.POST)
	public int idCheck(MemberDTO memberDTO) throws Exception {
		
		logger.info("MemberController idCheck.......");
		int result=memberService.idCheck(memberDTO);
		logger.info("member컨트롤러 아이디 체크 리턴 밸류 ["+result+"]");
		
		
		return result;
	}
	
	
	//우편번호
	@RequestMapping(value="address", method=RequestMethod.GET)
	public String address() throws Exception {
		return "/member/address";
	}
	
} // End - public class MemberController













