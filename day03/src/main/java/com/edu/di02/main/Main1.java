package com.edu.di02.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.edu.di02.spring.MemberInfoPrinter;
import com.edu.di02.spring.MemberRegisterService;
import com.edu.di02.spring.RegisterRequest;

public class Main1 {
	public static void main(String[] args) {
		//스프링 설정 파일을 가지고 Bean들을 생성한다.
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx1.xml");
		
		//컨테이너에서 빈을 가져 온다.
		MemberRegisterService regSvc=ctx.getBean("memberRegSvc",MemberRegisterService.class);
		MemberInfoPrinter infoPrinter=ctx.getBean("infoPrinter",MemberInfoPrinter.class);
		
		RegisterRequest regReq = new RegisterRequest();
		//회원등록에 필요한 정보들을 입력한다.
		regReq.setEmail("xodnr1532@naver.com");
		regReq.setName("김태욱");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");

		//회원등록 
		regSvc.regist(regReq);
		
		//등록한 회원정보를 출력한다.
		infoPrinter.printMemberInfo("xodnr1532@naver.com");
		
	}
}
