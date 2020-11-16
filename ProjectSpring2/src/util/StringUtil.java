package com.board.util;

//글내용 보기 -> <textarea></textarea>를 많이 썼었다. 
//요즘에는 <pre><textarea><%=content%></textarea></pre>
public class StringUtil {
	public static String parseBr(String msg){
		
		if(msg == null) return null;
		
		//replace(변경전단어, 변경후단어)
		return msg.replace("\r\n", "<br>")
                  .replace("\n", "<br>");
	}
}
