package com.board.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.BoardDao;
import com.board.domain.BoardCommand;

@Controller
public class DetailController {
//logger객체 만들기
	private Logger log=Logger.getLogger(this.getClass()); //자동으로 로그처리할 클래스명 (this.getClass-> 자기 자신)
	
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping("/qnaDetail.do")
	public ModelAndView process(@RequestParam("qna_num") int qna_num) {
		if(log.isDebugEnabled()) {
			log.debug("qna_num=>"+qna_num);
		}
		
		//조회수 증가
		boardDao.updateQnaViews(qna_num);
		BoardCommand board=boardDao.selectBoard(qna_num);
		
		board.setQna_content(board.getQna_content()); 
		return new ModelAndView("qnaView","board",board);
	}
}
