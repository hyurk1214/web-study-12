<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로 그 인</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<style>
 body{
	background: url(image/book4.jpg) no-repeat;
	background-size:cover;
	background-position:center center;
	margin-top : 300px;
}
h1{
	color: darkgreen;
	font-size:5em;
}
</style>
<script type="text/javascript" src="script/book.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>로 그 인</h1>
		<br><br><br>
		<form method="post" name="frm" action="loginServlet" style="text-align:center">
		<input type="hidden" name="command" value="book_list2">

			<table>
				<tr>
					<td style="border: white; text-align:right">아이디</td>
					<td style="border: white"><input type="text" name="userid" id="userid"></td>
				</tr>

				<tr>
					<td style="border: white; text-align:right">비밀번호</td>
					<td style="border: white"><input type="password" name="pwd"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center" style="border: white">
					<br><br><br>
					<input type="submit" value="로그인" onclick="return loginCheck()"> &nbsp;&nbsp;
					<input type="reset" value="취소" onclick="location.href='BookServlet?command=book_list'"> &nbsp;&nbsp;
					<input type="button" value="회원 가입" onclick="location.href='BookServlet?command=book_join_form'">
					</td>
				</tr>
			<tr><td colspan="2" style="border: white">${message }</td></tr>
			</table>
		</form>
	</div>


</body>
</html>