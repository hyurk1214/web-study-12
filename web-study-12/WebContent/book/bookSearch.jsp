<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<meta charset="UTF-8">
<title></title>
<style>
 body{
	background: url(image/book4.jpg) no-repeat;
	background-size: 1850px 1200px;
	background-position:top center;
	padding-top: 100px;
}
h1{
	color: darkgreen;
	font-size:5em;
}
</style>
</head>
<body>
	<div id="wrap" align="center">
		<h1>검색 결과</h1>
		<br><br><br><br>
		<table class="list">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>저자</th>
				<th>출판사</th>
				<th>가격</th>
				<th>수량</th>
			</tr>
			<c:forEach var="book" items="${bookSearchForm }">
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
 	</div>
</body>
</html>
