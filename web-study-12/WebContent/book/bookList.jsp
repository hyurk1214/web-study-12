<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
.uptable {
	margin: auto;
}
</style>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body style="background-image:url(image/book4.jpg); background-repeat:no-repeat; background-size:1850px 1200px; margin-top:100px; background-position:center center">
 <div id="wrap" align="center"  >
 
 <br><br><br><br>
<h1 style="font-size: 5em; color:darkgreen">BookStore</h1>
<form method = "post" action = "/web-study-12/BookServlet" name = "frm">
		<input type="hidden" name="command" value = "book_search_form">
	<table class="uptable">
		<tr>
			<td colspan="5" style="border: white; text-align: right"><a href="BookServlet?command=book_login_form">로그인</a>
		 	<a href="BookServlet?command=book_join_form">회원가입</a></td>
		</tr>
	</table>
		<input type="text" name="search" size="80px">
		<input type="submit" value="검 색" style="margin-left: 18px;" onclick="return bookSearch()">
</form>
<br><br>
<table class="list">
	<tr>
		<td colspan="6" style="border: white; text-align: right">
			<a href="BookServlet?command=book_write_form">게시글 등록</a>
		</td>
	</tr>
	<tr>
		<th style="background:skyblue">번호</th>
		<th style="background:skyblue">제목</th>
		<th style="background:skyblue">저자</th>
		<th style="background:skyblue">출판사</th>
		<th style="background:skyblue">가격</th>
		<th style="background:skyblue">수량</th>
	</tr>
	<c:forEach var="book" items="${bookList }">
	<tr class="record">
		<td>${book.num }</td>
		<td>
			<a href="BookServlet?command=book_view&num=${book.num }">${book.title }</a>
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
