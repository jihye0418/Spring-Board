package com.board.util;

import java.io.File;

public class FileUtil {
	//���ε� ���� ������
	public static final String UPLOAD_PATH="C:/webtest/4.jsp/sou/ProjectSpring2/src/main/webapp/upload";
	
	//���� ����
	public static String rename(String qna_img) throws Exception {
		if(qna_img==null) return null; 
		
		//�� �̸� ���ϱ�(�ý��۳�¥+��������) _ Ȯ���� ���� ���ϸ�
		String newName=Long.toString(System.currentTimeMillis())+(int)(Math.random()*50);
		System.out.println("newName(����)=>"+newName);
		return rename(qna_img,newName);
	}
	
	//Ȯ���� ���� ���ϸ�
	public static String rename(String qna_img, String newName) throws Exception{
		if(qna_img==null) return null; 
		
		//Ȯ���� ���ϱ�
		int idx=qna_img.lastIndexOf("."); 
		String extention="";
		String newFileName="";
		
		if(idx!=-1) {
			extention=qna_img.substring(idx);//.���� ���� ������ == Ȯ����. 
			System.out.println("Ȯ���� Ȯ��(extention=>" + extention);
		}
		
		//�� ���ϸ�
		int newIdx=newName.lastIndexOf(".");
		if(newIdx!=-1) {
			newName=newName.substring(0,newIdx);
			System.out.println("����� ���ϸ�=>"+newName);
		}
			
			newFileName=newName+extention.toLowerCase();
			System.out.println("���� ����� ���ϸ�+Ȯ����=>"+newFileName);
			return newFileName;
		}
		
	//�� ������ �� ���ε� �� ���ϵ� ���� �����ϰ� -> ���� ���ε�� ���� ���� �� ���� ���ε�. 
		public static void removeFile(String qna_img) {
			File file=new File(UPLOAD_PATH,qna_img); 
			//���� ���� Ȯ��
			if(file.exists()) file.delete();
		}
}
