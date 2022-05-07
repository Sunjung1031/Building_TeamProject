<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>unit</title>
</head>
<body>
<table border="1" width="100%">
<tr>
	<td>호실</td>
	<td>${unit.no}</td>
</tr>
<tr>
	<td>관리인</td>
	<td>${unit.name}</td>
</tr>
<tr>
	<td>임차인</td>
	<td>${unit.hire}</td>
</tr>
<tr>
	<td>임대인</td>
	<td>${unit.lease}</td>
</tr>
<tr>
	<td>임대료</td>
	<td>${unit.rent_fee}</td>
</tr>
<tr>
	<td>사용기간</td>
	<td>${unit.period}</td>
</tr>
<tr>
	<td>면적</td>
	<td>${unit.size}</td>
</tr>
<tr>
	<td>입주일</td>
	<td>${unit.coming}</td>
</tr>
<tr>
	<td>계약만료</td>
	<td>${unit.leaving}</td>
</tr>


		<td colspan="2">
		<c:set var="pageNo" value ="${empty param.pageNp ? '1' : param.pageNo }"/>
			<a href="list.do?pageNo=${pageNo}">[목록]</a>
			
			<a href ="modify.do?no=${unit.no }">[게시글수정]</a>
			<a href ="delete.do?no=${unit.no }">[게시글삭제]</a>
	
			</td>
	</tr>
</table>
</body>
</html>