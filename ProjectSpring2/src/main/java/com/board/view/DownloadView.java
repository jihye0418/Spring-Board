package com.board.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView {

	public DownloadView() {
		//다운로드 화면으로 전환
		setContentType("application/download");
	}
	
	//사용자로부터 받은 매개변수 처리
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 다운로드 받을 파일 정보
		File file=(File)model.get("downloadFile");
		System.out.println("file=>"+file);
		
		//파일 타입, 크기 설정
		response.setContentType(getContentType());
		response.setContentLength((int)file.length());
		
		//브라우저별 한글처리
		String userAgent=request.getHeader("user-Agent"); //브라우저 확인
		System.out.println("user-Agent=>"+userAgent);
		boolean ie=userAgent.indexOf("MISE") > -1; //Microsoft Internet Explorer면 -1 반환
		String fileName=null;
		if(ie) {
			fileName=URLEncoder.encode(file.getName(),"uft-8"); //한글처리
		}else {
			fileName=new String(file.getName().getBytes("utf-8"),"iso-8859-1"); //영문처리
		}
		
		//대화상자에서 다운로드 설정
		//(다운로드 위치, 다운받을 파일명)
		response.setHeader("Content-Disposition", "attachment;fileName=\""+fileName+"\";");
		response.setHeader("Content-Transfer-Encoding","binary");
		
		//입출력 객체
		OutputStream out=response.getOutputStream();
		FileInputStream fis=null;
		//예외처리
		try {
			fis=new FileInputStream(file);
			FileCopyUtils.copy(fis, out); 
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {fis.close();} catch(IOException e) {}
		}
		out.flush();
	}
}
