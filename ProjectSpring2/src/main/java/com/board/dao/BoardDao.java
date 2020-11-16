package com.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.board.domain.BoardCommand;

public interface BoardDao {
	//�� ��� ����
	public List<BoardCommand> list(Map<String,Object> map);
	
	//�� ���ڵ� ��
	public int getRowCount(Map<String,Object> map);
	
	//�ִ밪
	public int getNewQna_num();
	
	//�۾���
	public void insertqnaBoard(BoardCommand board);
	
	//��ȸ�� ����
	public void updateQnaViews(int qna_num);
	
	//�󼼺���
	public BoardCommand selectBoard(int qna_num);
	
	//������
	public BoardCommand beforeList(int qna_num);
	
	//������
	public BoardCommand nextList(int qna_num);
	
	//�� ����
	public void updateBoard(BoardCommand board);
	
	//�� ����
	public void deleteBoard(int qna_num);
}
