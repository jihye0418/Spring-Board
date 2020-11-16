package com.board.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.board.dao.BoardDao;

@Controller
public class DeleteController {
//Logger 객체 생성
	private Logger log=Logger.getLogger(this.getClass());
	
//db접속
	@Autowired //setter method 호출 대신 사용. == @Inject
	private BoardDao boardDao;
}
