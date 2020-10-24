package com.edu.di03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.edu.di03.spring.MemberDao;
import com.edu.di03.spring.MemberRegisterService;

@Configuration
public class ConfigPart1 {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
}
