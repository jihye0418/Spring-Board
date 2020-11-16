package com.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.board.domain.BoardCommand;

public interface BoardDao {
	//1. 글 목록 보기
	public List<BoardCommand> list(Map<String,Object> map);
	
	//2. 총 레코드 수
	public int getRowCount(Map<String,Object> map);
	
	//3. 최대값
	public int getNewQna_num();
	
	//4. 글쓰기
	public void insertqnaBoard(BoardCommand board);
	
	//5. 조회수 증가
	public void updateQnaViews(int qna_num);
	
	//6. 상세보기
	public BoardCommand selectBoard(int qna_num);
	
	//7.이전글
	public BoardCommand beforeList(int qna_num);
	
	//8.다음글
	public BoardCommand nextList(int qna_num);
	
	//9. 글 수정
	public void updateBoard(BoardCommand board);
	
	//10. 글 삭제
	public void qnaDelete(int seq);
}
