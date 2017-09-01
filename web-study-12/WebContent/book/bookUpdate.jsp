<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" style="text/css" href="css/shopping.css">
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
<h1>게시글 수정</h1>
<form name="frm" method="post" enctype="multipart/form-data" action="BookUpdateServlet">
	<input type="hidden" name="command" value="board_update">
	<input type="hidden" name="num" value="${book.num }">
	
	<table>
			<tr>
				<th>책 제 목</th>
					<td><input type="text" name="title" size="80" value="${book.title }"> &nbsp; * 필수</td>
				</tr>
				
				<tr>
					<th>가 격</th>
					<td><input type="text" name="price" value="${book.price }">원 &nbsp; * 필수</td>
				</tr>

				<tr>
					<th>저 자</th>
					<td><input type="text" name="writer" value="${book.writer }">  &nbsp; * 필수</td>
				</tr>

				<tr>
					<th>출 판 사</th>
					<td><input type="text" name="publisher" value="${book.publisher }"> &nbsp; * 필수</td>
				</tr>

				<tr>
					<th>수 량</th>
					<td><input type="text" name="bookcount" value="${book.bookcount }"> &nbsp; * 필수</td>
				</tr>

				<tr>
					<th>사 진</th>
					<td><input type="file" name="pictureUrl"> <br>
						(주의 사항 : 이미지를 변경하고자 할때만 선택하시오)</td>
				</tr>

				<tr>
					<th>내 용</th>
					<td><textarea rows="10" cols="80" name="description" >${book.description }</textarea></td>
				</tr>
			</table>
			<br><br> 
			 	<input type="submit" value="수정완료" onclick="return bookCheck()">
			 	<input type="reset" value="다시작성">
			 	<input type="button" value="목 록" onclick="location.href='BookServlet?command=book_list'">



</form>

</div>
 
</body>
</html>
