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
	
	//�Խñ� ��ȣ
	public int getNewQna_num() {
		int newQnaNum=(Integer)getSqlSession().selectOne("getNewQna_num");
		return newQnaNum;
	}
	
	//�۾���
	public void insertqnaBoard(BoardCommand board) {
		getSqlSession().insert("insertqnaBoard",board);
	}
	
	//��ȸ�� ����
	public void updateQnaViews(int qna_num) {
		getSqlSession().update("updateQnaViews",qna_num);
	}
	
	//�� �󼼺���
	public BoardCommand selectBoard(int qna_num) {
		return (BoardCommand)getSqlSession().selectOne("selectBoard",qna_num);
	}

}
