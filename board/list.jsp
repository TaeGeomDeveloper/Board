<%@page import="gntp.lesson.board.vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	a {
		text-decoration : none;
	}
</style>
<title>Board List</title>
</head>
<body>
<a href="viewWriteBoard.do">작성하기</a>
<table>
	<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
<% 

ArrayList<BoardVO> list = (ArrayList<BoardVO>)session.getAttribute("list");
for(BoardVO board : list) { 

%>
<tr>
	<td><%=board.getSeq()%></td>
	<td><%=board.getWriteSeq() %></td>
	<td width="50px" style="background-color:lightgrey;"><%=board.getCurrentSeq() %></td>
	<td>
		<a href="read.do?seq=<%=board.getSeq()%>">
			<%
/* 			int len = board.getCurrentSeq().length();
			for(int i=0;i<board.getCurrentSeq().length()*2;i++){
				out.print("&nbsp;");
			}
			if(len!=1){
				out.print("↳");
			} */
			out.print(board.getTitle());	
			%>
		</a></td>
	<td><%

		out.print(board.getContent()); 
		%></td>
	<td width="50px" style="background-color:white;text-align:center"><%=board.getNextSeq() %></td>
	<td><%=board.getWriter() %></td>
	<td><%=board.getUserId() %></td>
	<td><%=board.getWriteDate() %></td>
</tr>
<%  } %>	
</table>
</body>
</html>