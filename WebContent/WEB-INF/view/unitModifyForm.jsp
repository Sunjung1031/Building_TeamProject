
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<title>게시글 수정</title>
</head>
<body>
	<form action="modify.do?no=${unit.no}" method="post">
		<p>
			번호 : <br />${unit.no}
		</p>
		
		<p>
			상호명 : <br />
			<input name="content" type=text value= ${unit.name }/>
		</p>
		
		<p>
			임차인 : <br />
			<input name="content" type=text value=  ${unit.hire }/>
		</p>
		
		
		<p>
			임대인 : <br />
			<input name="content" type=text value=${unit.lease }/>
		</p>
		
		
		<p>
			임대료 : <br />
			<input name="content" type=text value= ${unit.rent_fee }/>
		</p>
		
		
		<p>
			사용기간 : <br />
			<input name="content" type=text value= ${unit.period }/>
		</p>
		
		
		<p>
			면적 : <br />
			<input name="content" type=text value= ${unit.size }/>
		</p>
		
		
		<p>
			입주일 : <br />
			<input name="content" type=text value= ${unit.coming }/>
		</p>
		
		
		<p>
			계약기간 : <br />
			<input name="content" type=text value= ${unit.leaving }/>
		</p>
		
		
		<input type="submit" value="글 수정">
	</form>
</body>
</html>