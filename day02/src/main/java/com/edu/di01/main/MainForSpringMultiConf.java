package com.edu.di01.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.edu.di01.spring.AlreadyExisitingMemberException;
import com.edu.di01.spring.ChangePasswordService;
import com.edu.di01.spring.IdPasswordNotMatchingException;
import com.edu.di01.spring.MemberInfoPrinter;
import com.edu.di01.spring.MemberListPrinter;
import com.edu.di01.spring.MemberNotFoundException;
import com.edu.di01.spring.MemberRegisterService;
import com.edu.di01.spring.RegisterRequest;
import com.edu.di01.spring.VersionPrinter;

// DI 방식 : 생성자를 통한 방식
public class MainForSpringMultiConf {

	
	//생성한 컨테이너를 가리키는 참조 변수를 선언한다. 
	private static ApplicationContext ctx = null;
	
	
	
	public static void main(String[] args) throws IOException {
		// XML설정 파일을 가지고 객체를 생성한다.
		
		String[] conf= {"classpath:conf1.xml","classpath:conf2.xml"};
//		ctx=new GenericXmlApplicationContext("classpath:conf1.xml","classpath:conf2.xml");
//		ctx=new GenericXmlApplicationContext("conf");
		ctx=new GenericXmlApplicationContext("classpath:configImport.xml");
		
		
		
		
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
			} else if(command.equals("list")) {
				processListCommand();
			} else if(command.startsWith("info ")) {
				processInfoCommand(command.split(" "));
			} else if(command.equals("version")) {
				processVersionCommand();
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
		System.out.println("list");
		System.out.println("info 이메일");
		System.out.println("version");
		System.out.println();
	} // End -private static void printHelp() 
	
	
	//spring 을 통해서 작업을 하므로 Assembler 가 필요 없다.
	//객체 조립기를 생성한다.
//	private static Assembler assembler = new Assembler();
	
	//회원가입 처리 메서드
	private static void processNewCommand(String[] args) {
		// 입력한 글자의 개수가 맞지 않으면 메뉴로 돌려 보낸다.
		if (args.length !=5) {
			printHelp();
			return;
		}
		
//		MemberRegisterService regSvc=assembler.getMemberRegisterService();
		MemberRegisterService regSvc=ctx.getBean("memberRegSvc", MemberRegisterService.class);
		
		RegisterRequest req=new RegisterRequest();
		req.setEmail(args[1]);
		req.setName(args[2]);
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
			
		ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc",ChangePasswordService.class);
//												assembler.getChangePasswordService();
		
		try {
			changePwdSvc.changePassword(args[1], args[2], args[3]);
			System.out.println("비밀번호를 변ㄷ경하였습니다.");
		} catch (MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일입니다. \n 다시입력해주세요.");
		} catch(IdPasswordNotMatchingException e) {
			System.out.println("이메일과 비밀번호가 일치하지 않습니다. \n 확인 후에 다시 시작해주십시오.");
			
		}
		
		
	} // End - private static void processChangeCommand(String args[])
	
	
	//회원목록을 출력하는 메서드
	private static void processListCommand() {
		MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
		listPrinter.printAll();
		
		
	} // End - private static void processListCommand()
	
	
	//이메일에 해당하는 회원의 정보를 출력한다.
	private static void processInfoCommand(String[] args) {
		if (args.length !=2) {
			printHelp();
			return;
		}
		MemberInfoPrinter infoPrinter =ctx.getBean("infoPrinter",MemberInfoPrinter.class);
		infoPrinter.printMemberInfo(args[1]);
		
	} // End -private static void processInfoCommand(String[] args)
	
	
	private static void processVersionCommand() {
		VersionPrinter versionPrinter= ctx.getBean("version" ,VersionPrinter.class);
		versionPrinter.print();
	} // End - private static void processVersionCommand()
	
	
	
}	//End -public class MainForAssembler












