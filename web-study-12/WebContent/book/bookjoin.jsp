<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<style>
 body{
	background: url(image/book4.jpg) no-repeat;
	background-size: 1850px 1200px;
	background-position:center center;
	margin-top : 200px;
}
h1{
	color: darkgreen;
	font-size:5em;
}
</style>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/book.js"></script>
</head>
<body>


	<div id="wrap" align="center">
		<h1>회원 가입</h1>

		<form method="post" name="frm" action="JoinServlet">
			<input type="hidden" name="command" value="book_join">

			<table>

				<tr>
					<td>이름</td>
					<td><input type="text" name="name" size="20"></td>
				</tr>

				<tr>
					<td>아이디</td>
					<td><input type="text" name="userid" size="20">*필수</td>
				</tr>

				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pwd" size="20">*필수</td>
				</tr>

				<tr>
					<td>이메일</td>
					<td><input type="text" name="email" size="20"></td>
				</tr>

				<tr>
					<td>전화번호</td>
					<td><input type="text" name="phone" size="20"></td>
				</tr>

				<tr>
					<td>등급</td>
					<td><input type="radio" name="admin" value="1"
						checked="checked">관리자 <input type="radio" name="admin"
						value="0"> 일반회원</td>
				</tr>

			</table>

			<br> 
			<input type="submit" value="가입" onclick="return joinCheck()"> 
			<input type="reset" value="취소" onclick="location.href='BookServlet?command=book_list'"> 

		</form>
	</div>
</body>
</html>