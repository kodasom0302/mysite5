package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookDao guestbookDao;
	
	//등록
	public int exeWrite(GuestbookVo guestVo) {
		System.out.println("GuestbookService.exeWrite()");
		
		int count=guestbookDao.guestInsert(guestVo);
		
		return count;
	}
	
	//삭제
	public int exeDelete(GuestbookVo guestVo) {
		System.out.println("GuestbookService.exeDelete()");
		
		int count=guestbookDao.guestDelete(guestVo);
		return count;
	}
	
	//리스트
	public List<GuestbookVo> exeList() {
		System.out.println("GuestbookService.exeList()");
		
		List<GuestbookVo> gList=guestbookDao.guestSelect();
		
		return gList;
	}
	

}
