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
//�αװ�ü ����
	private Logger log = Logger.getLogger(this.getClass());

//db����
	@Autowired
	private BoardDao boardDao;

@RequestMapping(value="/qnawrite.do", method = RequestMethod.GET)
public String form() {
	System.out.println("form()ȣ���");
	return "qnaWrite";
	}

@RequestMapping(value="/qnawrite.do", method = RequestMethod.POST)
public String submit(@ModelAttribute("command") BoardCommand command) {
	    System.out.println("submit() ȣ���");
	if(log.isDebugEnabled()) {
		log.debug("BoardCommand=>"+command);
	}
	//�۾��� �� ���ε�
	try {
		String newName="";
		System.out.println("command.getUpload()=>"+command.getUpload());
		if(!command.getUpload().isEmpty()) {
			newName=FileUtil.rename(command.getUpload().getOriginalFilename());
			System.out.println("newName=>"+newName);
			command.setQna_img(newName);
		}
		
		//�� ��ȣ +1
		int newQna_num=boardDao.getNewQna_num()+1;
		System.out.println(command.toString());
		System.out.println("newSeq=>"+newQna_num);
		command.setQna_num(newQna_num);
		
		//�۾���
		boardDao.insertqnaBoard(command);
		
	//���ε��� ������ �ִٸ�  �÷��� ������ �� ������ UPLOAD�� �̵��϶�
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