package com.edu.di03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.edu.di03.spring.MemberDao;
import com.edu.di03.spring.MemberRegisterService;

@Configuration
@Import(ConfigPartSub.class)
public class ConfigPartMain {
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
}
