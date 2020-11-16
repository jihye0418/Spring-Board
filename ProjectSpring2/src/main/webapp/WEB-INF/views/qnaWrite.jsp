<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<!-- CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/bf15dcb45d.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
    <title>닥터쿡 Q&A</title>
<!-- header -->
    <c:import url="/WEB-INF/views/template/header.jsp"/>

<!-- 본문 -->
<div class="container">
      <h2 class="text-center pt-4 pb-4">닥터쿡 Q&A</h2>
      <form method="post" action="qnaWrite.do" novalidate>
        <!-- 검색 -->
          <div class="input-group mb-3">
            <select class="custom-select col-md-2 col-3" id="ask_qna" name="ask_qna">
              <option value="">선택하세요</option>
              <option value="order">주문/결제</option>
              <option value="cancle">취소/교환/반품</option>
              <option value="delivery">상품배송</option>
              <option value="etc">기타</option>
            </select>
            <input type="text" class="form-control" name="qna_title" id="qna_title">
            <label id="ask_qna-error" class="bad" for="ask_qna" style="display:none"></label>
            <label id="qna_title-error" class="bad" for="qna_title" style="display:none"></label>
          </div>
        
        <!-- 글쓰기 api -->
        <textarea id="summernote" name="qna_content"></textarea>
        <div class="float-right mt-3 mb-3">
          <input type="submit" class="btn btn-primary mr-2" value="글쓰기">
          <input type="button" class="btn btn-danger" value="목록" onclick="location.href='qnaList.do'">
        </div>
      </form>
    </div>
<!-- footer -->
<c:import url="/WEB-INF/views/template/footer.jsp"/>
<!-- js -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <!-- 글쓰기 api -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
    <script src="js/summernote-ko-KR.min.js"></script>
    <!-- 유효성검사 -->
    <script src="js/jquery.validate.min.js"></script>
    <!-- 게시판용 js -->
    <script src="js/board.js"></script>
  </body>
