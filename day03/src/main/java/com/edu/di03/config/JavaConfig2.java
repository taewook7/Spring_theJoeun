package com.edu.di03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.edu.di03.spring.MemberDao;
import com.edu.di03.spring.MemberInfoPrinter;
import com.edu.di03.spring.MemberPrinter;
import com.edu.di03.spring.MemberRegisterService;

//@Configuration은 해당 클래스가 스프링의 설정으로 사용된다는 것을 지정.
@Configuration
public class JavaConfig2 {
	
//	<bean id="memberDao" class="com.edu.di02.spring.MemberDao" />
// @Bean이 적용된 메서드가 리턴한 객체를 빈 객체로 사용한다.
// 자바 설정에서는 빈 객체를 직접 설정한다.
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}

	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter=new MemberInfoPrinter();
		
//		infoPrinter.setMemberDao(memberDao());
//		infoPrinter.setPrinter(printer());
		
		return infoPrinter;
	}
	
}
