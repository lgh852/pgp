<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


		

<c:forEach var="scrap" items="${scrap}">

<img src="<%=request.getContextPath()%>/resources/memberphoto/${scrap.photo_name}" width="300px" height="300px">
                   
</c:forEach>
 