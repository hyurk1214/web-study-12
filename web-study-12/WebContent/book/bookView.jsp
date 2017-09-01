<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
 body{
	background: url(image/book4.jpg) no-repeat;
	background-size:1850px 1200px;
	background-position:center center;
	margin-top : 230px;
}
h1{
	color: darkgreen;
	font-size:5em;
}
</style>
<link rel="stylesheet" type="text/css" href="css/shopping.css">

</head>
<body>
<div id="wrap" align="center">
	<h1>책 상세보기</h1>
	<br><br><br><br>
	<table>
		<tr>
			<td>
				<c:choose>
					<c:when test="${empty book.pictureUrl }">
						<img src="upload/noimage.gif">
					</c:when>
					<c:otherwise>
						<img src="upload/${book.pictureUrl }">
					</c:otherwise>
				</c:choose>
			</td>
			<td>
				<table>
					<tr>
						<th>제목 </th>
						<td> ${book.title }</td>
					</tr>
					<tr>
						<th>작가</th>
						<td> ${book.writer }</td>
					</tr>
					<tr>
						<th>출판사</th>
						<td> ${book.publisher }</td>
					</tr>
					<tr>
						<th>가격</th>
						<td>${book.price}원</td>
					</tr>
					<tr>
						<th>설명</th>
						<td><textarea rows="10" cols="90" readonly>${book.description }</textarea></td>
					</tr>
					<tr>
						<th>수량</th>
						<td>${book.bookcount }</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<br><br>
	<input type="button" value="구매" onclick="alert('구매완료')">
	<input type="button" value="목록으로" onclick="location.href='BookServlet?command=book_list'">
	<input type="button" value="수정" onclick="location.href='BookServlet?command=book_update_form&num=${param.num}'">
	<input type="button" value="삭제" onclick="location.href='BookServlet?command=book_delete_form&num=${param.num }'">
</div>			
</body>
</html>
