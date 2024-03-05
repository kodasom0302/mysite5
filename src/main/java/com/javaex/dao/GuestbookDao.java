package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;

	public int guestDelete(GuestbookVo guestVo) {
		System.out.println("GuestbookDao.guestDelete()");

		int count = sqlSession.delete("guestbook.delete", guestVo);

		return count;

	}// delete

	public List<GuestbookVo> guestSelect() {
		System.out.println("GuestbookDao.guestSelect()");

		List<GuestbookVo> gList = sqlSession.selectList("guestbook.select");
		
		return gList;
	}// select

	public int guestInsert(GuestbookVo guestVo) {
		System.out.println("GuestbookDao.guestInsert()");
		
		int count=sqlSession.insert("guestbook.insert", guestVo);

		return count;

	}// insert

}
