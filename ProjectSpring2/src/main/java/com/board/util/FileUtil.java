package com.board.util;

import java.io.File;

public class FileUtil {
	//업로드 파일 저장경로
	public static final String UPLOAD_PATH="C:/webtest/4.jsp/sou/ProjectSpring2/src/main/webapp/upload";
	
	//원본 파일
	public static String rename(String qna_img) throws Exception {
		if(qna_img==null) return null; 
		
		//새 이름 정하기(시스템날짜+랜덤숫자) _ 확장자 제외 파일명
		String newName=Long.toString(System.currentTimeMillis())+(int)(Math.random()*50);
		System.out.println("newName(난수)=>"+newName);
		return rename(qna_img,newName);
	}
	
	//확장자 포함 파일명
	public static String rename(String qna_img, String newName) throws Exception{
		if(qna_img==null) return null; 
		
		//확장자 구하기
		int idx=qna_img.lastIndexOf("."); //.을 기준으로 파일 이름, 확장자를 나눔.(lastIndexOf=> 뒤에서부터 찾아라) / 찾지 못하면 -1 리턴. 
		String extention=""; //확장자 저장할 곳.
		String newFileName="";//실질적 새로운 파일명(확장자 포함된 파일명)
		
		if(idx!=-1) {//.을 찾았다면
			extention=qna_img.substring(idx);//.부터 문자 끝까지 == 확장자. 
			System.out.println("확장자 확인(extention=>" + extention);
		}
		
		//새 파일명
		int newIdx=newName.lastIndexOf(".");//확장자를 포함한 변경된 파일명
		if(newIdx!=-1) {
			newName=newName.substring(0,newIdx); //0은 포함하면서 newIdx-1까지 파일명이 됨.
			System.out.println("변경된 파일명=>"+newName);
		}
			
			newFileName=newName+extention.toLowerCase(); //새로운 파일 이름 = 새로운 이름 + 확장자
			//확장자가 대문자면 소문자로 변경시켜야 한다. => toLowerCase();
			System.out.println("새로 변경된 파일명+확장자=>"+newFileName);
			return newFileName;
		}
		
	//글 수정할 때 업로드 된 파일도 수정 가능하게 -> 기존 업로드된 파일 삭제 후 새로 업로드. 
		public static void removeFile(String qna_img) {
			File file=new File(UPLOAD_PATH,qna_img); //1. 삭제하고자하는파일경로  2.파일명
			//파일 유무 확인
			if(file.exists()) file.delete(); //해당 경로에 파일이 존재한다면 삭제해라.
		}
}
