package com.board.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger; //로그객체와 관련된 클래스
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.board.dao.BoardDao;
import com.board.domain.BoardCommand;
import com.board.util.PagingUtil;

@Controller
public class ListController {
	
	//로그객체 생성
	private Logger log = Logger.getLogger(this.getClass());
	
	//DAO클래스 객체를 얻어옴
	@Autowired
	private BoardDao boardDao;

	//웹상에 호출할 메서드
		@RequestMapping("/qnaList.do")
		public ModelAndView process(@RequestParam(value="pageNum", defaultValue="1") int currentPage, 
													@RequestParam(value="keyField",defaultValue="")String keyField,
													@RequestParam(value="keyWord",defaultValue="")String keyWord) {
			
			if(log.isDebugEnabled()) {
				log.debug("currentPage:"+currentPage);
				log.debug("keyField:"+keyField);
				log.debug("keyWord:"+keyWord);
			}
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("keyField",keyField);
			map.put("keyWord",keyWord); 
		
			//페이징처리를 하기 위해 총 레코드 수 필요
			int count = boardDao.getRowCount(map);
		
			//페이징처리 -> PaginUtil클래스의 객체를 생성해서 사용.
			PagingUtil page=new PagingUtil(currentPage, count, 10,10,"qnaList.do");
			map.put("start", page.getStartCount());
			map.put("end", page.getEndCount());
			
			//List
			List<BoardCommand> list = null;
			if(count>0) {
				list=boardDao.list(map);
				System.out.println("list=>" +list);
			}else {
				list=Collections.EMPTY_LIST;
			}
			System.out.println("ListController클래스의 count=>" + count);
			
			ModelAndView mav = new ModelAndView("qnaList");
			mav.addObject("count",count);
			mav.addObject("list",list);
			mav.addObject("pagingHtml",page.getPagingHtml());

			return mav;
		}
}