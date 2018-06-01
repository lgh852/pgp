<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>


.list-group{

    list-style : none;
    margin: 10px;
    padding: 0px;
    
    max-width: 250px;
    max-height: 50px;
    width: 100%;
    text-align: center;
    
}

</style>
		
<%-- <c:forEach var="scrap" items="${scrap}">

<img src="<%=request.getContextPath()%>/resources/memberphoto/${scrap.photo_name}" width="300px" height="300px">
                   
</c:forEach> --%>
 
 
 <c:forEach var="scrapNameList" items="${scrapNameList}" varStatus="status">
 
<div class="list-group">
  <a href="<%=request.getContextPath()%>/sidebar/scrapdetail?scrap_name=${scrapNameList.scrap_name}" class=" list-group-item list-group-item-action active">
  ${scrapNameList.scrap_name}</a>
  

</div>

</c:forEach>