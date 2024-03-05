package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	//회원가입
	public int exeJoin(UserVo userVo) {
		System.out.println("UserService.exeJoin()");
		
		int count=userDao.userInsert(userVo);
		
		return count;
	}
	
	//로그인
	public UserVo exeLogin(UserVo userVo) {
		System.out.println("UserService.exeLogin()");
		
		UserVo authUser=userDao.userSelectByIdPw(userVo);
		
		return authUser;
	}
	
	//회원정보수정
	public int exeModify(UserVo userVo) {
		System.out.println("UserService.exeModify()");
		
		int count=userDao.uesrUpdate(userVo);
		
		return count;
	}

}
