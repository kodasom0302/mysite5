package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//회원가입
	public int userInsert(UserVo userVo) {
		System.out.println("UserDao.userInsert()");
		
		int count=sqlSession.insert("user.insert", userVo);
		
		return count;
	}//insert
	
	//로그인
	public UserVo userSelectByIdPw(UserVo userVo) {
		System.out.println("UserDao.userSelectByIdPw()");
		
		UserVo authUser=sqlSession.selectOne("user.selectByIdPw", userVo);
		
		return authUser;
	}//select
	
	//회원정보수정
	public int uesrUpdate(UserVo userVo) {
		System.out.println("UserDao.uesrUpdate()");
		
		int count=sqlSession.update("user.update", userVo);
		
		return count;
	}//update

}
