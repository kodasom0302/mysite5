package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//회원가입폼
	@RequestMapping(value="/user/joinform", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("UserController.joinForm()");
		
		return "/user/joinForm";
	}
	
	//회원가입
	@RequestMapping(value="/user/join", method= {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("UserController.join()");
		
		userService.exeJoin(userVo);
		
		return "redirect:/main";
	}
	
	//로그인폼
	@RequestMapping(value="/user/loginform", method= {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("UserController.loginForm()");
		
		return "/user/loginForm";
	}
		
	//로그인
	//http://localhost:8080/mysite5/user/login?id=aaa&password=1234
	@RequestMapping(value="/user/login", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController.login()");
		//(id, pw) vo
		//service.메소드에게 보낸다 -> vo(no name) 받는다 -> 세션에 저장한다
		UserVo authUser=userService.exeLogin(userVo);
		
		session.setAttribute("authUser", authUser);
		
		//성공하면 메인으로 리다이렉트
		return "redirect:/main";
	}
	
	//로그아웃
	@RequestMapping(value="/user/logout", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("UserController.logout()");
		
		session.removeAttribute("authUser");
		
		return "redirect:/main";
	}
	
	//회원정보수정폼
	@RequestMapping(value="/user/modifyform", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm() {
		System.out.println("UserController.modifyForm()");
		
		return "/user/modifyForm";
	}
	
	//회원정보수정
	@RequestMapping(value="/user/modify", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute UserVo userVo) {
		System.out.println("UserController.modify()");
		
		userService.exeModify(userVo);
		
		return "redirect:/main";
	}

}
