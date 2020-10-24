package com.edu.di03.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.edu.di03.spring.MemberDao;
import com.edu.di03.spring.MemberInfoPrinter;
import com.edu.di03.spring.MemberPrinter;

@Configuration
public class ConfigPartSub {
	
	@Autowired
	private MemberDao memberDao;
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter =new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao);
		infoPrinter.setPrinter(printer());
		return infoPrinter;
	}
}
