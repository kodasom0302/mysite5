package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	//삭제폼
	@RequestMapping(value = "/gbc/deleteform", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteForm() {
		System.out.println("GuestbookController.deleteForm()");

		return "deleteForm";
	}
		
	//삭제
	@RequestMapping(value="/gbc/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestbookVo guestVo) {
		System.out.println("GuestbookController.delete()");
		
		guestbookService.exeDelete(guestVo);

		return "redirect:/gbc/list";
	}
	
	//등록
	@RequestMapping(value="/gbc/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("GuestbookController.write()");
		
		guestbookService.exeWrite(guestbookVo);
		
		return "redirect:/gbc/list";
	}
	
	//리스트
	@RequestMapping(value="/gbc/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("GuestbookController.write()");
		
		List<GuestbookVo> gList=guestbookService.exeList();
		
		model.addAttribute("gList", gList);
		
		return "list";
	}
	
}
