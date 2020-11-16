<%
  response.sendRedirect(request.getContextPath()+"/qnaList.do"); //글목록보기로 이동
  System.out.println("request.getContextPath()=>"+request.getContextPath());
%>