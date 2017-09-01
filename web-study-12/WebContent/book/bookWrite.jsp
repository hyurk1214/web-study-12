<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 등록</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<style>
 body{
	background: url(image/book4.jpg) no-repeat;
	background-size:1850px 1200px;
	background-position:center center;
	margin-top : 200px;
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
		<h1>책 등록</h1>
		<form method="post" name="frm" encType="multipart/form-data" action="BookInsertServlet">
			<input type="hidden" name="command" value="book_write">
			<table>
				<tr>
					<th>책 제 목</th>
					<td><input type="text" name="title" size="80"> &nbsp; * 필수</td>
				</tr>
				
				<tr>
					<th>가 격</th>
					<td><input type="text" name="price">원 &nbsp; * 필수</td>
				</tr>

				<tr>
					<th>저 자</th>
					<td><input type="text" name="writer">  &nbsp; * 필수</td>
				</tr>

				<tr>
					<th>출 판 사</th>
					<td><input type="text" name="publisher"> &nbsp; * 필수</td>
				</tr>

				<tr>
					<th>수 량</th>
					<td><input type="text" name="bookcount"> &nbsp; * 필수</td>
				</tr>

				<tr>
					<th>사 진</th>
					<td><input type="file" name="pictureUrl"> <br>
						(주의 사항 : 이미지를 변경하고자 할때만 선택하시오)</td>
				</tr>

				<tr>
					<th>내 용</th>
					<td><textarea rows="10" cols="80" name="description"></textarea></td>
				</tr>
			</table>
			<br><br> 
			 	<input type="submit" value="등록" onclick="return bookCheck()">
			 	<input type="reset" value="다시작성">
			 	<input type="button" value="목 록" onclick="location.href='BookServlet?command=book_list'">
		</form>
	</div>
</body>
</html>