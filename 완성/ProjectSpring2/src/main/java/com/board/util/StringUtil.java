package com.board.util;

public class StringUtil {
	public static String parseBr(String msg){
		
		if(msg == null) return null;
		
		//replace(변경전단어, 변경후단어)
		return msg.replace("\r\n", "<br>")
                  .replace("\n", "<br>");
	}
}
