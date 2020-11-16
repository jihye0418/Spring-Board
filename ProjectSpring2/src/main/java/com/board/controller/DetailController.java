package com.board.controller;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.BoardDao;
import com.board.domain.BoardCommand;
import com.board.util.FileUtil;
import com.board.util.StringUtil;

@Controller
public class DetailController {
//logger��ü �����
	private Logger log=Logger.getLogger(this.getClass()); //�ڵ����� �α�ó���� Ŭ������ (this.getClass-> �ڱ� �ڽ�)
	
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping("/qnaDetail.do")
	public ModelAndView process(@RequestParam("qna_num") int qna_num) {
		if(log.isDebugEnabled()) {
			log.debug("qna_num=>"+qna_num);
		}
		
		//��ȸ�� ����
		boardDao.updateQnaViews(qna_num);
		
		//�Խñ� �󼼺���
		BoardCommand board=boardDao.selectBoard(qna_num);
		
		//�� ���� ����
		board.setQna_content(StringUtil.parseBr(board.getQna_content()));
		
		//������
		BoardCommand beforeContent=boardDao.beforeList(qna_num);
		System.out.println("beforeContent Ȯ��=>"+boardDao.beforeList(qna_num));
		
		//������
		BoardCommand nextContent=boardDao.nextList(qna_num);
		System.out.println("nextContent Ȯ��=>"+boardDao.nextList(qna_num));
	
		ModelAndView mav = new ModelAndView("qnaView");

		mav.addObject("beforeContent", beforeContent);
		mav.addObject("nextContent", nextContent);
		mav.addObject("board", board);
		
		System.out.println("����Ȯ���ϱ�"+mav.getModel());
		return mav;
	}
	

	//���� �ٿ�ε�
	@RequestMapping("/file.do")
	public ModelAndView download(@RequestParam("qna_img") String qna_img) {
		//�ٿ�ε� ���� ���� ��ġ, �̸�
		System.out.println("qna_img=>"+qna_img);
		File downloadFile = new File(FileUtil.UPLOAD_PATH+"/"+qna_img);
		//���������� �ٿ� �޴� ��(�䰴ü,�� ��ü��,�����Ұ�)
		return new ModelAndView	("downloadView","downloadFile",downloadFile);
	}
	
}
