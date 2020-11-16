package com.board.controller;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.dao.BoardDao;
import com.board.domain.BoardCommand;
import com.board.util.FileUtil;

@Controller
public class WriteController {
//로그객체 생성
	private Logger log = Logger.getLogger(this.getClass());

//db접속
	@Autowired
	private BoardDao boardDao;

@RequestMapping(value="/qnawrite.do", method = RequestMethod.GET)
public String form() {
	System.out.println("form()호출됨");
	return "qnaWrite";
	}

@RequestMapping(value="/qnawrite.do", method = RequestMethod.POST)
public String submit(@ModelAttribute("command") BoardCommand command) {
	    System.out.println("submit() 호출됨");
	if(log.isDebugEnabled()) {
		log.debug("BoardCommand=>"+command);
	}
	//글쓰기 및 업로드
	try {
		String newName="";
		System.out.println("command.getUpload()=>"+command.getUpload());
		if(!command.getUpload().isEmpty()) {
			newName=FileUtil.rename(command.getUpload().getOriginalFilename());
			System.out.println("newName=>"+newName);
			command.setQna_img(newName);
		}
		
		//글 번호 +1
		int newQna_num=boardDao.getNewQna_num()+1;
		System.out.println(command.toString());
		System.out.println("newSeq=>"+newQna_num);
		command.setQna_num(newQna_num);
		
		//글쓰기
		boardDao.insertqnaBoard(command);
		
	//업로드한 파일이 있다면  올려준 파일을 내 서버의 UPLOAD로 이동하라
		if(!command.getUpload().isEmpty()) {
			File file=new File(FileUtil.UPLOAD_PATH+"/"+newName);
			command.getUpload().transferTo(file);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
		return "redirect:/qnaList.do"; 
	}
}