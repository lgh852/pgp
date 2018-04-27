<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<form action="mp_update" method="post" enctype="multipart/form-data">

<input type ="hidden" name="member_id" value="${member.member_id}">


<table>
   
   <tr>
		<td>별명</td>
		<td><input type="text" name="member_nickname" value="${member.member_nickname}">  </td>
	</tr>
	<tr>
		<td>성별</td>
		<td><input type="text" name="member_gender" value="${member.member_gender}">  </td>
	</tr>		
	<tr>
		<td>휴대폰</td>
		<td><input type="text" name="member_phone" value="${member.member_phone}">  </td>
	</tr>		 
	<tr>
		<td>생일</td>
		<td><input type="text" name="member_birth" value="${member.member_birth}">  </td>
	</tr>	
	<tr>
		<td>사진</td>
		<td><input type="file" name="photofile" value="${member.photofile}">  </td>
	    <!-- model/Member에 photofile로 되어있으니  이름 맞춰야짓  -->
	</tr> 
	<tr>
		<td>소개</td>
		<td><input type="text" name="member_intro" value="${member.member_intro}">  </td>
	</tr>	
	<tr>
		<td></td>
		<td>
			<input type="submit" value="수정">
			<input type="reset">
		</td>
	</tr>
</table>
