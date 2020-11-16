<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>닥터쿡 공지사항</title>
<!-- CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/bf15dcb45d.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<!-- header -->
    <c:import url="/WEB-INF/template/header.jsp"/>
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

      <!-- 검색 -->
      <div class="clearfix">
        <form action="qnaList.do" class="float-md-right pb-3" name="search" method="get">
          <div class="input-group">
            <select class="custom-select col-md-3 col-3" name="keyField">
              <option value="qna_title">제목</option>
              <option value="qna_content">내용</option>
              <option value="mem_id">아이디</option>
            </select>
            <input type="text" class="form-control" name="keyWord">
            <div class="input-group-append">
              <input type="submit" value="검색" class="btn btn-primary">
            </div>
          </div>
        </form>
      </div>

      <!-- 테이블 -->
      <table class="table table-hover text-center">
        <thead class="thead-light">
          <tr>
            <th>번호</th>
            <th>분류</th>
            <th class="w-50">제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회수</th>
          </tr>
        </thead>
        <c:if test="${count==0}">
          <tr>
            <td colspan="6">작성된 문의가 없습니다.</td>
          </tr>
     	</c:if>
     	<c:forEach var="article" items="${list}">
          <tr>
              <td>${article.qna_num }</td>
			  <td>${article.qna_ask }</td>
            <td class="text-left">
              <a href="qnaDetail.do?qna_num=${article.qna_num}&pageNum=${pageNum}&qna_category=${qna_category}">
              	${article.qna_title}</a>
              <c:if test="${article.qna_views>150}">
              	<span class="badge badge-danger">HOT</span>
              </c:if>
            </td>
            <td>${article.mem_id}</td>
            <td><fmt:formatDate value="${article.qna_date}" timeStyle="medium" pattern="yy.MM.dd"/></td>
            <td>${article.qna_views}</td>
          </tr>
          </c:forEach>

      </table>

      <!-- 글쓰기 버튼 (로그인 한 사람만 볼 수 있음)-->
      <%-- <c:if test="${sessionScope.mem_id != null }"> --%>
	      <div class="write_btn mt-2 mb-3 mr-3 clearfix">
	        <input type="button"  class="btn btn-primary float-right" value="글쓰기" onclick="location.href='qnawrite.do?qna_category=${qna_category}'">
	      </div>
	  <%-- </c:if> --%>

      <!-- 페이지 -->
      <nav aria-label="Page navigation example" class="float-none">
        <ul class="pagination justify-content-center">
            <li>${pagingHtml}</li>
        </ul>
      </nav>
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