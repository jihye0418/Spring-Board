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
		//�ٿ�ε� ȭ������ ��ȯ
		setContentType("application/download");
	}
	
	//����ڷκ��� ���� �Ű����� ó��
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// �ٿ�ε� ���� ���� ����
		File file=(File)model.get("downloadFile");
		System.out.println("file=>"+file);
		
		//���� Ÿ��, ũ�� ����
		response.setContentType(getContentType());
		response.setContentLength((int)file.length());
		
		//�������� �ѱ�ó��
		String userAgent=request.getHeader("user-Agent"); //������ Ȯ��
		System.out.println("user-Agent=>"+userAgent);
		boolean ie=userAgent.indexOf("MISE") > -1; //Microsoft Internet Explorer�� -1 ��ȯ
		String fileName=null;
		if(ie) {
			fileName=URLEncoder.encode(file.getName(),"uft-8"); //�ѱ�ó��
		}else {
			fileName=new String(file.getName().getBytes("utf-8"),"iso-8859-1"); //����ó��
		}
		
		//��ȭ���ڿ��� �ٿ�ε� ����
		//(�ٿ�ε� ��ġ, �ٿ���� ���ϸ�)
		response.setHeader("Content-Disposition", "attachment;fileName=\""+fileName+"\";");
		response.setHeader("Content-Transfer-Encoding","binary");
		
		//����� ��ü
		OutputStream out=response.getOutputStream();
		FileInputStream fis=null;
		//����ó��
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
