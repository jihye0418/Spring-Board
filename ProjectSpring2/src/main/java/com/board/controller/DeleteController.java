package com.board.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.board.dao.BoardDao;

@Controller
public class DeleteController {
//Logger ��ü ����
	private Logger log=Logger.getLogger(this.getClass());
	
//db����
	@Autowired //setter method ȣ�� ��� ���. == @Inject
	private BoardDao boardDao;
}
