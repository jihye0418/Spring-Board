package com.board.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.dao.BoardDao;
import com.board.domain.BoardCommand;
import com.board.util.FileUtil;

@Controller
public class DeleteController {
//Logger 객체 생성
	private Logger log=Logger.getLogger(this.getClass());
	
//db접속
	@Autowired
	private BoardDao boardDao;
	
	//삭제
	@RequestMapping(value="/qnadelete.do", method = RequestMethod.GET)
	public String form(@ModelAttribute("command") BoardCommand command) {
		System.out.println("form()호출됨");
		
		
		
		BoardCommand board=null; //레코드 전체를 board로 저장.
		board=boardDao.selectBoard(command.getQna_num());
		boardDao.deleteBoard(command.getQna_num()); 
		if(board.getQna_img()!=null) {//업로드된 파일이 있다면
			FileUtil.removeFile(board.getQna_img());
		}
		
		return "qnaDelete";
	}
}