<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read Board</title>
</head>
<body>
<form action="reply.do" method="post">
<table>
	<tr>
		<td></td><td><input type="text" name="title" value=""></td>
		<td></td>
	</tr>
	<tr><td></td>
		<td><textarea rows="5" cols="100" name="content" value=""></textarea></td>
		<td></td>
	</tr>
	<tr><td></td>
		<td><input type="hidden" name="current_seq" value=""></td>
		<td></td>
	</tr>
	<tr><td></td>
		<td><input type="hidden" name="next_seq" value=" "></td>
		<td></td>
	</tr>
	<tr><td></td>
		<td><input type="hidden" name="write_seq" value=" "></td>
		<td></td>
	</tr>
	<tr>
		<td colspan="3"><input type="submit" value="댓글 작성"></td>
	</tr>
</table>
</body>
</html>