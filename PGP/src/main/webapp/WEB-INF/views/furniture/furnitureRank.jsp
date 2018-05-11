<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	d여기 가구 랭킹
<div >
<ul>
 <li class="nav-item "> <!-- <li class="nav-item dropdown">   -->
            <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
            <div class="dropdown-menu" aria-labelledby="dropdown01">
            
            
            
              <a class="dropdown-item" href="<%=request.getContextPath()%>/mypage/mp_main">좋아요 순 </a>
              <a class="dropdown-item" href="#">조회수 순</a>
              <a class="dropdown-item" href="#">스크랩 순</a>
              
            </div>
          </li>
          </ul>
</div>


============================== 


<div class="input-group mb-3" >
  <div class="input-group-prepend" >
    <label class="input-group-text" for="inputGroupSelect01" >가구 랭킹</label>
  </div>
  <select class="custom-select" id="inputGroupSelect01">
    <option selected>선택하세여!!!!</option>
    <option value="1">좋아요 순 </option>
    <option value="2">조회수 순</option>
    <option value="3">스크랩 순</option>
  </select>
</div>


</body>
</html>