<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 회원 가입 </title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/book.js"></script>
</head>
<body>
<div id="wrap" align = "center">
<h2> 회원 가입</h2>
<form method="post" action="02_addMember.jsp">
<table>
	<tr>
	<td> 이름  </td>
	<td> <input type="text" name="name" size="20" > </td>
	</tr>
	
	<tr>
	<td> 아이디  </td>
	<td> <input type="text" name="userid" size="20" > </td>
	</tr>
	
	<tr>
	<td> 비밀번호 </td>
	<td> <input type="text" name="pwd" size="20" > </td>
	</tr>
	
	<tr>
	<td> 이메일  </td>
	<td> <input type="text" name="email" size="10" > @
		 <select name="email">
  		 <option value="ema">nate.net</option>
  		 <option value="ema1">duam.net</option>
  		 <option value="ema2" selected="selected">naver.com</option>
	</select></td>
	</tr>
	
	<tr>
	<td> 전화번호  </td>
	<td> <select name="phone">
  		 <option value="num1">017</option>
  		 <option value="num2">011</option>
  		 <option value="num3" selected="selected">010</option>
	</select>
	<input type="text" name="phone" size="5" > <input type="text" name="phone" size="5"></td>
	</tr>
	
	<tr>
	<td> 등급  </td>
	
	<td> 
	<input type="radio" name="admin" value="1" checked="checked"  >관리자
	<input type="radio" name="admin" value="0"   > 일반회원
	</td>
	</tr>
</table>
	<br>
	 <input type="submit" value="가입"> 
	 <input type="reset" value="취소">



</form>
</div>


</body>
</html>