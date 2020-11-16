package com.board.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.BoardDao;
import com.board.domain.BoardCommand;
import com.board.util.FileUtil;

@Controller
public class DeleteController {
//Logger 按眉 积己
	private Logger log=Logger.getLogger(this.getClass());
	
//db立加
	@Autowired
	private BoardDao boardDao;
	
	//昏力 汽栏肺 捞悼
	@RequestMapping("/qnaDelete.do" )
	public String delete(@RequestParam("qna_num") int qna_num) {
		return "qnaDelete";
	}
}