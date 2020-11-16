package com.board.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.board.domain.BoardCommand;

public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao {

	public List<BoardCommand> list(Map<String, Object> map) {
		List<BoardCommand> list=getSqlSession().selectList("selectList",map);
		return list;
	}
	
	public int getRowCount(Map<String, Object> map) {
		return getSqlSession().selectOne("selectCount",map);
	}
	
	//게시글 번호
	public int getNewQna_num() {
		int newQnaNum=(Integer)getSqlSession().selectOne("getNewQna_num");
		return newQnaNum;
	}
	
	//글쓰기
	public void insertqnaBoard(BoardCommand board) {
		getSqlSession().insert("insertqnaBoard",board);
	}
	
	//조회수 증가
	public void updateQnaViews(int qna_num) {
		getSqlSession().update("updateQnaViews",qna_num);
	}
	
	//글 상세보기
	public BoardCommand selectBoard(int qna_num) {
		return (BoardCommand)getSqlSession().selectOne("selectBoard",qna_num);
	}
	
	//이전글
	public BoardCommand beforeList(int qna_num) {
		return (BoardCommand)getSqlSession().selectOne("beforeList",qna_num);
	}
	
	//다음글
	public BoardCommand nextList(int qna_num) {
		return (BoardCommand)getSqlSession().selectOne("nextList",qna_num);
	}
	
	//글 수정
	public void updateBoard(BoardCommand board) {
		getSqlSession().update("updateBoard", board);
	}
	
	//글 삭제
	public void deleteBoard(int qna_num) {
		getSqlSession().delete("deleteBoard", qna_num);
	}
}
