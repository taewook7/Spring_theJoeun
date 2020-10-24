package com.edu.di03.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.edu.di03.spring.MemberDao;
import com.edu.di03.spring.MemberPrinter;
import com.edu.di03.spring.MemberRegisterService;

//XML 파일을 import 해서 사용한다.
@Configuration
@ImportResource("classpath:sub-config.xml")

public class JavaMainConfig {
	
	
	@Autowired
	private MemberDao memberDao;
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao);
	}
	
	
	
	
}
