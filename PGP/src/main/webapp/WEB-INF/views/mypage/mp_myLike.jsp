<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="likephoto" items="${likeList}">

<img src="<%=request.getContextPath()%>/resources/BoardPhoto/
${likephoto.photo_name}" width="200px" height="200px">

</c:forEach>
