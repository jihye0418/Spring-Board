package com.board.controller;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.BoardDao;
import com.board.domain.BoardCommand;
import com.board.util.FileUtil;

@Component
@Controller
public class UpdateController {
//Logger
	private Logger log = Logger.getLogger(this.getClass());

//db연결
	@Autowired
	private BoardDao boardDao;

	//
@RequestMapping(value="/qnaUpdate.do", method=RequestMethod.GET )
	public ModelAndView form(@RequestParam("qna_num") int qna_num) {
		BoardCommand boardCommand=boardDao.selectBoard(qna_num);
		//이동할 페이지명, 키명, 전달할 값
		return new ModelAndView("qnaUpdate","command",boardCommand);
	}
	
@RequestMapping(value="/qnaUpdate.do", method = RequestMethod.POST)
public String submit(@ModelAttribute("command") BoardCommand command) {
	if(log.isDebugEnabled()) {
		log.debug("BoardCommand=>"+command);
	}
	
	//글 수정
	BoardCommand board=null;
	String oldFileName=""; //기존에 DB에 저장된 파일
	board=boardDao.selectBoard(command.getQna_num());
	oldFileName=board.getQna_img();
	System.out.println("oldFileName=>"+oldFileName);
	
	//DB에 파일이 있다면
	if(!command.getUpload().isEmpty()) {
		try {	//파일을 수정할 경우
			command.setQna_img(FileUtil.rename(command.getUpload().getOriginalFilename()));
		}catch(Exception e) {e.printStackTrace();}
	}else {//2) 기존 파일을 유지한다면
		command.setQna_img(oldFileName); //DB에 저장된 기존 파일명
	}
	boardDao.updateBoard(command);//글 수정 메서드 호출
	
	//업로드 하다 오류가 날 수 있으므로 예외처리
	if(!command.getUpload().isEmpty()) { //변경된 내용이 있다면
	try {
		File file=new File(FileUtil.UPLOAD_PATH+"/"+command.getQna_img());
		command.getUpload().transferTo(file);
	}catch(IOException e) {
		e.printStackTrace();
	}
	//새로운 파일 업로드 시 기존 파일 삭제
	if(oldFileName!=null) {
		FileUtil.removeFile(oldFileName);{
		}
	}
}
		return "redirect:/qnaList.do?qna_category="+command.getQna_category(); 
	}
}