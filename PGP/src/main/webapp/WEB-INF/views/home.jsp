<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    
      <style>
          .margin{
              margin: 0 auto;
          }
      </style>
    <title>home</title>
 <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>

    <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/resources/css/offcanvas.css" rel="stylesheet">
    
    <link href="<%=request.getContextPath()%>/resources/dist/summernote.css" rel="stylesheet">
  </head>

  <body class="bg-light">

    <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
      <a class="navbar-brand mr-auto mr-lg-0" href="#">오늘의집</a>
      <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
        <span class="navbar-toggler-icon"></span>
      </button>
<input type =hidden value="${member_member_id}">
      <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="<%=request.getContextPath()%>/">홈 <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/photo/photofeed">사진</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">가구랭킹</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/manager/noticelist">공지사항</a>
          </li>
            <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/manager/faqlist">질문과답변</a>
          </li>
            <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/board/boardFrom">글쓰기</a>
          </li>
         
            <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/manager/managerloginform">관리자</a>
          </li>
        <c:if test="${user!=null}">
       
            <li class="nav-item">
            <a class="nav-link" href="#">로그아웃</a>
          </li>
          
        </c:if>
           <c:if test="${user==null}">
               <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/member/loginform">로그인</a>
          </li>
            <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/member/memberform">회원가입</a>
          </li>
                 </c:if>
                 
                 
            <c:if test="${manager!=null}">
     
        
            <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/manager/noticeinsert"> 공지사항 입력하기</a>
          </li>
            </c:if>
            
              <c:if test="${user!=null}">
            <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
            <div class="dropdown-menu" aria-labelledby="dropdown01">
            
            
            
              <a class="dropdown-item" href="<%=request.getContextPath()%>/mypage/mp_main">마이페이지</a>
              <a class="dropdown-item" href="#">Another action</a>
              <a class="dropdown-item" href="#">Something else here</a>
              
            </div>
          </li>
                  </c:if>
                 
            
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav>

    <div class="nav-scroller bg-white box-shadow">
      <nav class="nav nav-underline">
        <a class="nav-link active" href="#">Dashboard</a>
        <a class="nav-link" href="#">
          Friends
          <span class="badge badge-pill bg-light align-text-bottom">27</span>
        </a>
        <a class="nav-link" href="#">Explore</a>
        <a class="nav-link" href="#">Suggestions</a>
        <a class="nav-link" href="#">Link</a>
        <a class="nav-link" href="#">Link</a>
        <a class="nav-link" href="#">Link</a>
        <a class="nav-link" href="#">Link</a>
        <a class="nav-link" href="#">Link</a>
      </nav>
    </div>

    <main role="main" class="container">
      <div class="d-flex align-items-center p-3 my-3 text-white-50 bg-purple rounded box-shadow">
        <img class="mr-3" src="https://getbootstrap.com/assets/brand/bootstrap-outline.svg" alt="" width="48" height="48">
        <div class="lh-100">
          <h6 class="mb-0 text-white lh-100">Bootstrap</h6>
          <small>Since 2011</small>
        </div>
      </div>
          <jsp:include page="${page}"/>
      </main>
        

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="<%=request.getContextPath()%>/resources/js/popper.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/holder.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/offcanvas.js"></script>
    
	<script src="<%=request.getContextPath()%>/resources/dist/summernote.min.js"></script>
  </body>
</html>
