<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
	<p class="text-left">
		<button type="button"
			onclick="location.href='<%=request.getContextPath()%>/manager/noticelist'"
			class="btn btn-primary" data-toggle="button" aria-pressed="false">
			공지사항 리스트 확인할래</button>
	</p>

	<p class="text-left">
		<button type="button"
			onclick="location.href='<%=request.getContextPath()%>/manager/faqlist'"
			class="btn btn-primary" data-toggle="button" aria-pressed="false">
			FAQ 리스트 확인할래</button>
	</p>
	
	<p class="text-left">
		<button type="button"
			onclick="location.href='<%=request.getContextPath()%>/manager/reportview'"
			class="btn btn-primary" data-toggle="button" aria-pressed="false">
			신고 들어온거 확인해보쟈</button>
	</p>

</div>

</body>
</html>