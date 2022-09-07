<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Board</title>
</head>
<body>
<form action="writeBoard.do" method="post">
<table>
	<tr>
		<td></td><td><input type="text" name="title"></td>
		<td></td>
	</tr>
	<tr><td></td>
		<td><textarea rows="5" cols="100" name="content"></textarea></td>
		<td></td>
	</tr>
	<tr><td></td>
		<td><input type="hidden" name="current_seq" value="a"></td>
		<td></td>
	</tr>
	<tr><td></td>
		<td><input type="hidden" name="next_seq" value=" "></td>
		<td></td>
	</tr>
	<tr>
		<td colspan="3"><input type="submit" value="게시글 작성"></td>
	</tr>
	
	
	
	
	
</table>
</form>
</body>
</html>