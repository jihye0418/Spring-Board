package com.board.util;

//�۳��� ���� -> <textarea></textarea>�� ���� �����. 
//���򿡴� <pre><textarea><%=content%></textarea></pre>
public class StringUtil {
	public static String parseBr(String msg){
		
		if(msg == null) return null;
		
		//replace(�������ܾ�, �����Ĵܾ�)
		return msg.replace("\r\n", "<br>")
                  .replace("\n", "<br>");
	}
}
