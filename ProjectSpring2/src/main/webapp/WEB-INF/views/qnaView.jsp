<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<!-- CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/bf15dcb45d.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/board.css">
    <link rel="stylesheet" href="css/style.css">
    <title>닥터쿡 Q&A</title>
<!-- header -->
    <c:import url="/WEB-INF/views/template/header.jsp"/>
<!-- 본문 -->
<div class="container">
      <h2 class="text-center pt-4 pb-4">닥터쿡 Q&A</h2>
      <div class="">
        <div class="clearfix board_bg">
          <p class="board_title"><span>[${board.qna_ask}]</span>&nbsp;${board.qna_title}</p>
          <p class="board_info">
            <span>${board.mem_id}</span>
            <span><fmt:formatDate value="${board.qna_date}" timeStyle="medium" pattern="yy.MM.dd"/></span>
            <span>${board.qna_views }</span>
          </p>
        </div>
        <div class="p-3 board_content">
          ${board.qna_content }
        </div>
        <table class="table table-borderless border-bottom">
          <tr class="thead-light">
            <th class="w-25">첨부파일</th><td><a href="file.do?filename=${board.qna_img}">${board.qna_img }</a></td>
          </tr>
        </table>
      </div>
      <div class="clearfix">
        <div class="float-right">
          <input type="button" class="btn btn-success" value="답변달기" onclick="location.href='qnaWrite.do'">
          <input type="button" class="btn btn-info" value="수정하기">
          <input type="button" class="btn btn-danger" value="삭제">
          <input type="button" class="btn btn-primary" value="목록" onclick="location.href='qnaList.do'">
        </div>
      </div>
      <table class="table table-borderless mt-5">
        <tr class="thead-light border-top border-bottom">
          <th class="w-25">이전글</th>
          <td>ddd</td>
          <!-- 이전글이 없는 경우 
          <td class="text-black-50">이전 글이 없습니다. </td>-->
        </tr>
        <tr class="thead-light border-bottom">
          <th class="w-25">다음글</th>
          <td>ddd</td>
          <!-- 다음글이 없는 경우 
          <td class="text-black-50">다음 글이 없습니다. </td>
          -->
        </tr>
      </table>
    </div>

<!-- footer -->
    <c:import url="/WEB-INF/views/template/footer.jsp"/>
    
<!-- js -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <!-- 글쓰기 api -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- 유효성검사 -->
    <script src="js/jquery.validate.min.js"></script>
    <!-- 게시판용 js -->
    <script src="js/board.js"></script>
</body>
</html>