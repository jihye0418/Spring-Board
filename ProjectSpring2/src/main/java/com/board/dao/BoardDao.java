package com.board.dao;

import java.util.List;
import java.util.Map;

import com.board.domain.BoardCommand;

public interface BoardDao {
	//1. 글 목록 보기
	public List<BoardCommand> list(Map<String,Object> map);
	
	//2. 총 레코드 수
	public int getRowCount(Map<String,Object> map);
}
