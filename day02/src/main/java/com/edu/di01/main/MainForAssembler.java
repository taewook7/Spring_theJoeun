package com.edu.di01.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.edu.di01.assembler.Assembler;
import com.edu.di01.spring.AlreadyExisitingMemberException;
import com.edu.di01.spring.ChangePasswordService;
import com.edu.di01.spring.IdPasswordNotMatchingException;
import com.edu.di01.spring.MemberNotFoundException;
import com.edu.di01.spring.MemberRegisterService;
import com.edu.di01.spring.RegisterRequest;

public class MainForAssembler {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//작업선택 메뉴 
		while (true) {
			printHelp(); // 작업도움말 
			System.out.println("명령어를 입력하십시오.");
			String command=reader.readLine();
			
			if (command.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			
			//new 로 시작하는게 있으면 참이다   startswith 
			if (command.startsWith("new ")) {
				processNewCommand(command.split(" "));
				//반복문 앞으로 간다.
				continue;
			} else if(command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			}
		}
		
		
	} //End -public static void main(String[] args)
	private static void printHelp() {
		System.out.println("---------------------------");
		System.out.println("명령어 사용법");
		System.out.println("exit");
		System.out.println("new 이메일 이름 암호 암호 확인");
		System.out.println("change 이메일 현재비밀번호 변경할 비밀번호");
		System.out.println();
	} // End -private static void printHelp() 
	
	
	//객체 조립기를 생성한다.
	private static Assembler assembler = new Assembler();
	
	//회원가입 처리 메서드
	private static void processNewCommand(String[] args) {
		// 입력한 글자의 개수가 맞지 않으면 메뉴로 돌려 보낸다.
		if (args.length !=5) {
			printHelp();
			return;
		}
		
		MemberRegisterService regSvc=assembler.getMemberRegisterService();
		RegisterRequest req=new RegisterRequest();
		req.setEmail(args[1]);
		req.setName(args[3]);
		req.setPassword(args[3]);
		req.setConfirmPassword(args[4]);
		
		//암호와 암호확인을 검사한다.
		if (!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("비밀번호와 비밀번호 확인이 일치하지 않습니다.\n 다시해주십시오.");
			return;
		}
		try {
			regSvc.regist(req);
			System.out.println("등록이 완료되었습니다.");
		} catch (AlreadyExisitingMemberException e) {
			System.out.println("이미존재하는 이메일입니다. \n 다시 입력해주세요.");
		}
		
		
	} // End -private static void processNewCommand(String[] args)
	
	
	private static void processChangeCommand(String args[]) {
		// 개수가 4개가 아니면 사용법을 보여주고 돌려보낸다.
		if(args.length !=4) {
			printHelp();
			return;
		}
			
		ChangePasswordService changePwdSvc = assembler.getChangePasswordService();
		
		try {
			changePwdSvc.changePassword(args[1], args[2], args[3]);
			System.out.println("비밀번호를 변ㄷ경하였습니다.");
		} catch (MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일입니다. \n 다시입력해주세요.");
		} catch(IdPasswordNotMatchingException e) {
			System.out.println("이메일과 비밀번호가 일치하지 않습니다. \n 확인 후에 다시 시작해주십시오.");
			
		}
		
		
	} // End - private static void processChangeCommand(String args[])
	
	
	
}	//End -public class MainForAssembler












