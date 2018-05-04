
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="https://code.jquery.com/jquery-1.10.2.js">    </script>
 <script>

 $(document).ready(function(){

		

	 $(".close").click(function(){
 		alert('선택하셧습니다'); 
 		opener.document.getElementById("link").value = document.getElementById("linkdata").value;
 		 window.close();
 		
 	});
 	});
 </script>
 
<title>Insert title here</title>
</head>

<body>
	<center>
		<form action="shoppingList.do">
			<input type="text" name="keyword"> <input type="submit"
				value="검색">
		</form>

	</center>
		<c:if test="${title!=null}">
	<c:if test="${shoppingList!=null}">
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">사진</th>
				<th scope="col">제목</th>
				<th scope="col">가격</th>
				<th scope="col">판매mall</th>
				<th scope="col">선택</th>
				
			</tr>
		</thead>
		<tbody>
</c:if>
</c:if>
			<c:forEach items="${shoppingList}" var="b">
				<tr>
					<th scope="row"><a href="${b.link}"><img src="${b.image}"
							width="100px" height="100px"></a></th>
					<td><a href="${b.link}">${b.title}</a></td>
					<td>${b.lprice}</td>
					<td>${b.mallName}</td>
					<td><button type="button" class="btn btn-primary close">선택</button> 
					<input type="hidden" value="${b.link}" id="linkdata">
					

</td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

</body>
</html>
