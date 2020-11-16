<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>닥터쿡</title>
<!-- CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/bf15dcb45d.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/board.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<!-- header -->
    <c:import url="/WEB-INF/template/header.jsp"/>
<!-- 본문 -->
<div class="container">
      <h2 class="text-center pt-4 pb-4">
      	<c:if test="${qna_category==1}">
      		닥터쿡 공지사항
      	</c:if>
      	<c:if test="${qna_category==2}">
      		닥터쿡 Q&A
      	</c:if>
      	<c:if test="${qna_category==3}">
      		닥터쿡 자주 묻는 질문
      	</c:if>
      	</h2>
        <div class="clearfix board_bg">
          	<p class="board_title">
          	<c:if test="${qna_category != 1}">
          	   <span>[${board.qna_ask}]</span>
          	</c:if>
          	&nbsp;${board.qna_title}</p>
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
          <tr>
            <th class="w-25">첨부파일</th><td><a href="file.do?qna_img=${board.qna_img}">${board.qna_img }</a></td>
          </tr>
        </table>
      <div class="clearfix">
        <div class="float-right">
          <!-- 수정, 삭제는 본인만 가능하게 -->
          <%-- <c:if test="${sessionScope.mem_id == board.mem_id }"> --%>
	          <input type="button" class="btn btn-info" value="수정" onclick="location.href='qnaUpdate.do?qna_num=${board.qna_num}'">
	          <input type="button" class="btn btn-danger" value="삭제" data-toggle="modal" data-target="#staticBackdrop">
          <%-- </c:if> --%>
          
          <input type="button" class="btn btn-primary" value="목록" onclick="location.href='qnaList.do?qna_category=${board.qna_category}'">
        </div>
      </div>
      <table class="table table-borderless mt-5">
        <tr class="thead-light border-top border-bottom">
          <th class="w-25">이전글</th>
          <c:choose>
          	<c:when test="${empty beforeList.qna_num}">
          		<td class="text-black-50">이전 글이 없습니다. </td>
          	</c:when>
          	<c:otherwise>
          		<td><a href="qnaDetail.do?qna_num=${beforeList.qna_num}&pageNum=${pageNum}&qna_category=${qna_category}">${beforeList.qna_title}</a></td>
          	</c:otherwise>
          </c:choose>
        </tr>
        <tr class="thead-light border-bottom">
          <th class="w-25">다음글</th>
          <c:choose>
          	<c:when test="${empty nextList.qna_num}">
          		<td class="text-black-50">다음 글이 없습니다. </td>
          	</c:when>
          	<c:otherwise>
          		<td><a href="qnaDetail.do?qna_num=${nextList.qna_num}&pageNum=${pageNum}&qna_category=${qna_category}">${nextList.qna_title}</a></td>
          	</c:otherwise>
          </c:choose>
        </tr>
      </table>
      <!--  -->
      <!-- 모달창 -->
		<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">게시글을 삭제하시겠습니까?</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        게시글을 삭제하면 복구가 불가능합니다.<br>
		        그래도 삭제하시겠습니까?
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-primary" onclick="location.href='qnadelete.do?qna_num=${board.qna_num}&qna_category=${board.qna_category }'">삭제</button>
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
		      </div>
		    </div>
		  </div>
		</div>
    </div>
<!-- footer -->
    <c:import url="/WEB-INF/template/footer.jsp"/>
<!-- js -->
    <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
    <!-- 글쓰기 api -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- 유효성검사 -->
    <script src="js/jquery.validate.min.js"></script>
    <!-- 게시판용 js -->
    <script src="js/board.js"></script>
    <!-- 전체 js -->
    <script src="js/main.js"></script>
</body>
</html>