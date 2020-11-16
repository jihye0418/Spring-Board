package com.board.dao;

import java.util.List;
import java.util.Map;

import com.board.domain.BoardCommand;

public interface BoardDao {
	//1. �� ��� ����
	public List<BoardCommand> list(Map<String,Object> map);
	
	//2. �� ���ڵ� ��
	public int getRowCount(Map<String,Object> map);
	
	//3. �ִ밪
	public int getNewQna_num();
	
	//4. �۾���
	public void insertqnaBoard(BoardCommand board);
	
	//5. ��ȸ�� ����
	public void updateQnaViews(int qna_num);
	
	//6. �󼼺���
	public BoardCommand selectBoard(int qna_num);
	
	//������
	public BoardCommand beforeContent(int qna_num);
	
	//������
	public BoardCommand afterContent(int qna_num);
}
