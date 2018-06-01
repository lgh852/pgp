<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>


<h1>제목 ${faq.faq_title}</h1>
<h1>내용 ${faq.faq_contents}</h1>
<h1>날짜 <fmt:formatDate value="${faq.faq_regdate}" pattern="yyyy-MM-dd hh:mm"/></h1>
<h1>관리자 번호 ${faq.manager_idx}</h1>
