<%
  response.sendRedirect(request.getContextPath()+"/qnaList.do?qna_category=1"); //글목록보기로 이동
  System.out.println("request.getContextPath()=>"+request.getContextPath());
%>