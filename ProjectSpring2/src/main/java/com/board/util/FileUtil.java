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
		int idx=qna_img.lastIndexOf("."); //.�� �������� ���� �̸�, Ȯ���ڸ� ����.(lastIndexOf=> �ڿ������� ã�ƶ�) / ã�� ���ϸ� -1 ����. 
		String extention=""; //Ȯ���� ������ ��.
		String newFileName="";//������ ���ο� ���ϸ�(Ȯ���� ���Ե� ���ϸ�)
		
		if(idx!=-1) {//.�� ã�Ҵٸ�
			extention=qna_img.substring(idx);//.���� ���� ������ == Ȯ����. 
			System.out.println("Ȯ���� Ȯ��(extention=>" + extention);
		}
		
		//�� ���ϸ�
		int newIdx=newName.lastIndexOf(".");//Ȯ���ڸ� ������ ����� ���ϸ�
		if(newIdx!=-1) {
			newName=newName.substring(0,newIdx); //0�� �����ϸ鼭 newIdx-1���� ���ϸ��� ��.
			System.out.println("����� ���ϸ�=>"+newName);
		}
			
			newFileName=newName+extention.toLowerCase(); //���ο� ���� �̸� = ���ο� �̸� + Ȯ����
			//Ȯ���ڰ� �빮�ڸ� �ҹ��ڷ� ������Ѿ� �Ѵ�. => toLowerCase();
			System.out.println("���� ����� ���ϸ�+Ȯ����=>"+newFileName);
			return newFileName;
		}
		
	//�� ������ �� ���ε� �� ���ϵ� ���� �����ϰ� -> ���� ���ε�� ���� ���� �� ���� ���ε�. 
		public static void removeFile(String qna_img) {
			File file=new File(UPLOAD_PATH,qna_img); //1. �����ϰ����ϴ����ϰ��  2.���ϸ�
			//���� ���� Ȯ��
			if(file.exists()) file.delete(); //�ش� ��ο� ������ �����Ѵٸ� �����ض�.
		}
}
