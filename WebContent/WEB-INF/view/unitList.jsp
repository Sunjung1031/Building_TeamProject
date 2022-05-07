<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글 목록</title>
</head>
<body>

	<table border="1">
		<tr>
			<td colspan="4"><a href="write.do">[상가정보작성]</a></td>
		</tr>
		<tr>
			<td>상가번호</td>
			<td>상호명</td>
		
			<td>임대인</td>
		</tr>
		<c:if test="${unitPage.hasNoUnits() }">
			<tr>
				<td colspan="4">정보가 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach var="unit" items="${unitPage.content }">
			<tr>
				<td>${unit.no }</td>
				<td>
				<a href="read.do?no=${unit.no }&pageNo=${unitPage.currentPage}">
						<c:out value="${unit.name }" />
				</a>
				</td>
				<td>${unit.lease}</td>
		
			</tr>
		</c:forEach>
		<c:if test="${unitPage.hasUnits() }">
			<tr>
				<td colspan="4">
				<c:if test="${unitPage.startPage>5 }">
						<a href="list.do?pageNo=${unitPage.startPage-5 }">[이전]</a>
					</c:if> 
					<c:forEach var="pNo" 
					begin="${unitPage.startPage }"
						end="${unitPage.endPage }">
						<a href="list.do?pageNo=${pNo }">[${pNo }]</a>
					</c:forEach> 
					<c:if test="${unitPage.endPage<articlePage.totalPages }">
						<a href="list.do?pageNo=${unitPage.startPage +5 }">[다음]</a>
					</c:if>
					</td>
			</tr>
		</c:if>
	</table>
</body>
</html>