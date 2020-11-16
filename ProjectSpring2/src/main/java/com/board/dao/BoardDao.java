package com.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

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
	
	//7.������
	public BoardCommand beforeList(int qna_num);
	
	//8.������
	public BoardCommand nextList(int qna_num);
	
	//9. �� ����
	public void updateBoard(BoardCommand board);
	
	//10. �� ����
	public void qnaDelete(int seq);
}
