package com.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.board.domain.BoardCommand;

public interface BoardDao {
	//글 목록 보기
	public List<BoardCommand> list(Map<String,Object> map);
	
	//총 레코드 수
	public int getRowCount(Map<String,Object> map);
	
	//최대값
	public int getNewQna_num();
	
	//글쓰기
	public void insertqnaBoard(BoardCommand board);
	
	//조회수 증가
	public void updateQnaViews(int qna_num);
	
	//상세보기
	public BoardCommand selectBoard(int qna_num);
	
	//이전글
	public BoardCommand beforeList(int qna_num);
	
	//다음글
	public BoardCommand nextList(int qna_num);
	
	//글 수정
	public void updateBoard(BoardCommand board);
	
	//글 삭제
	public void deleteBoard(int qna_num);
}
