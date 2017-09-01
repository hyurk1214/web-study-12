<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<style type="text/css">
.uptable {
	margin: auto;
}
</style>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<style>
 body{
	background: url(image/book4.jpg) no-repeat;
	background-size:1850px 1200px;
	background-position:center center;
	margin-top : 250px;
}
h1{
	color: darkgreen;
	font-size:5em;
}
</style>
</head>
<body>
	<div id="wrap" align="center">
		<h1>BookStore</h1>
		<form name="frm" action="BookServlet" method="post">
			<table class="uptable">
				<tr>
					<td colspan="5" style="border: white; text-align: right">
					안녕하세요. ${loginUser.name }(${loginUser.userid})님 
					<a href="BookServlet?command=book_list">로그아웃</a>
					</td>
				</tr>
			</table>
			
				<input type="text" name="search" size="80px">
				<input type="button" value="검 색" style="margin-left: 18px;"
					onclick="location.href='BookServlet?command=book_search'">
			<table class="list">
				<tr>
					<td colspan="6" style="border: white; text-align: right"><a
						href="BookServlet?command=book_write_form">게시글 등록</a></td>
				</tr>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>저자</th>
					<th>출판사</th>
					<th>가격</th>
					<th>수량</th>
				</tr>
				<c:forEach var="book" items="${bookList }">
					<tr class="record">
						<td>${book.num }</td>
						<td><a href="BookServlet?command=book_view&num=${book.num }">${book.title }</a>
						</td>
						<td>${book.writer }</td>
						<td>${book.publisher }</td>
						<td>${book.price }원</td>
						<td>${book.bookcount }</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>