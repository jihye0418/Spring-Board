<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
      <div class="container">
        <a class="navbar-brand" href="#">닥터<b>쿡</b></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbars" aria-controls="navbars" aria-expanded="false" aria-label="Toggle navigation">
          <div class="burger-menu">
            <div class="burger"></div>  
          </div>
        </button>
    
        <div class="collapse navbar-collapse" id="navbars">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="dropdownv" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">이야기</a>
              <div class="dropdown-menu" aria-labelledby="dropdownv">
                <a class="dropdown-item" href="qnaList.do?category=0     ">공지사항</a>
                <a class="dropdown-item" href="#">질문게시판</a>
                <a class="dropdown-item" href="#">자주묻는질문</a>
              </div>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">클래스</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">선생님</a>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <form class="navbar-form form-inline mr-3">
              <input id="searchBar" class="searchbar" type="text" placeholder="입력하세요">
              <button class="btn" type="submit"><i class="fa fa-search"></i></button>
            </form>
            <li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-heart"></i>내 강의</a></li>
            <li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-user"></i><span>로그인</span></a></li>
          </ul>
        </div>
      </div>
    </nav>