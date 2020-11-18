package com.board.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.BoardDao;
import com.board.domain.BoardCommand;
import com.board.util.FileUtil;
import com.board.util.StringUtil;

@Component
@Controller
public class DetailController {
//logger객체 만들기
	private Logger log=Logger.getLogger(this.getClass()); //자동으로 로그처리할 클래스명 (this.getClass-> 자기 자신)
	
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping("/qnaDetail.do")
	public ModelAndView process(@RequestParam("qna_num") int qna_num,
			                                     @RequestParam(value="pageNum") int currentPage,
			                                     @RequestParam("qna_category") int qna_category,
			                                     BoardCommand command) {
		System.out.println("DetailController의 process()호출됨");
		if(log.isDebugEnabled()) {
			log.debug("qna_num=>"+qna_num);
			log.debug("currentPage=>"+currentPage);
			log.debug("qna_category=>"+qna_category);
		}
		
		//조회수 증가
		boardDao.updateQnaViews(qna_num);
		
		//게시글 상세보기
		BoardCommand board=boardDao.selectBoard(qna_num);
		
		//글 내용 엔터
		board.setQna_content(StringUtil.parseBr(board.getQna_content()));
		
		//이전글
		Map<String,Object> b = new HashMap<String, Object>();
		System.out.println("qna_category!!=>"+qna_category);
			b.put("qna_category", qna_category);//h.get("qna_category")
			b.put("qna_num", qna_num);
			BoardCommand beforeList = boardDao.beforeList(b);


		
		//다음글
			BoardCommand nextList = boardDao.nextList(b);
	
		ModelAndView mav = new ModelAndView("qnaView");

		mav.addObject("pageNum", currentPage);
		mav.addObject("qna_category", qna_category);
		mav.addObject("board", board);
		mav.addObject("beforeList", beforeList);
		mav.addObject("nextList", nextList);

		
		System.out.println("오류확인하기"+mav.getModel());
		return mav;
	}
	

	//파일 다운로드
	@RequestMapping("/file.do")
	public ModelAndView download(@RequestParam("qna_img") String qna_img) {
		File downloadFile = new File(FileUtil.UPLOAD_PATH+"/"+qna_img);
		//스프링에서 다운 받는 뷰(뷰객체,모델 객체명,전달할값)
		return new ModelAndView	("downloadView","downloadFile",downloadFile);
	}
	
}
