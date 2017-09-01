<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" style="text/css" href="css/shopping.css">
</head>
<body>
<div id="wrap" align="center">
<h1>게시글 삭제</h1>
<form name="frm" method="post" action="BookDeleteServlet">
	<input type="hidden" name="command" value="board_delete">
	<input type="hidden" name="num" value="${book.num }">
	
	<table>
			<tr>
				<th>책 제 목</th>
					<td><input type="text" name="title" size="80" value="${book.title }" readonly></td>
				</tr>
				
				<tr>
					<th>가 격</th>
					<td><input type="text" name="price" value="${book.price }" readonly>원 </td>
				</tr>

				<tr>
					<th>저 자</th>
					<td><input type="text" name="writer" value="${book.writer }" readonly>  </td>
				</tr>

				<tr>
					<th>출 판 사</th>
					<td><input type="text" name="publisher" value="${book.publisher }" readonly> </td>
				</tr>

				<tr>
					<th>수 량</th>
					<td><input type="text" name="bookcount" value="${book.bookcount }" readonly> </td>
				</tr>

				<tr>
					<th>내 용</th>
					<td><textarea rows="10" cols="80" name="description" readonly >${book.description }</textarea></td>
				</tr>
			</table>
			<br><br> 
			 	<input type="submit" value="삭제">
			 	<input type="button" value="취소" onclick="location.href='BookServlet?command=book_list'">


</form>
</div>
</body>
</html>
