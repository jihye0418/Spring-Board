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
      <form action="qnaUpdate.do" enctype="multipart/form-data" method="post"   id="writeform" novalidate>
        <div class="card shadow p-4 border-left-primary mb-3">
          <div class="form-group">
            <label for="qna_title">제목</label>
            <div class="input-group">
            	<input type="hidden" name="qna_num" value="${command.qna_num }">
            	<input type="hidden" name="mem_id" value="${command.mem_id }">
            	<input type="hidden" name="qna_category" value="${command.qna_category }">
              <select class="custom-select col-md-2 col-3" name="qna_ask" id="qna_ask">
                <option value="${command.qna_ask}">${command.qna_ask}</option>
              </select>
              <input type="text" class="form-control" value="${command.qna_title}" id="qna_title" name="qna_title">
          		<label id="qna_title-error" class="bad" for="qna_title" style="display:none"></label>
            </div>
          </div>
          <div class="form-group">
            <label for="qna_content">내용</label>
            <textarea id="qna_content" name="qna_content" class="form-control" rows="10"
              style="resize:none">${command.qna_content}</textarea>
          </div>
          <div class="form-group custom-file mb-3">
            <input type="file" class="custom-file-input" id="customFile" name="upload">
            <c:if test="${empty command.qna_img }">
            	<label class="custom-file-label" for="customFile">첨부된 파일이 없습니다.</label>
            </c:if>
            <c:if test="${!empty command.qna_img }">
            	<label class="custom-file-label" for="customFile">[${command.qna_img }] 파일이 등록되어 있습니다.</label>
            </c:if>
          </div>
          <div class="form-group">
            <div class="text-right">
              <input type="submit" class="btn btn-primary" value="수정하기">
              <input type="button" class="btn btn-info" value="목록" onclick=rewriteCancle();>
            </div>
          </div>
      </form>
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