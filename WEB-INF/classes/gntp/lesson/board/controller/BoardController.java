package gntp.lesson.board.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gntp.lesson.board.dao.BoardDAO;
import gntp.lesson.board.vo.BoardVO;

@WebServlet("*.do")
public class BoardController extends HttpServlet {

	public void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String path = req.getRequestURI();
		String[] temp = path.split("/");
		String command = temp[temp.length-1];
		System.out.println(command);
		String url = "./board/list.jsp";
		BoardDAO dao = new BoardDAO();
		if(command.equals("viewWriteBoard.do")) {
			url = "./board/writeBoard.jsp";
		} else if(command.equals("writeBoard.do")) {
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String currentSeq = req.getParameter("current_seq");
			String nextSeq = req.getParameter("next_seq");
			String userId = "user";
			String writer = "user";
			BoardVO board = new BoardVO();
			board.setCurrentSeq(currentSeq);
			board.setTitle(title);
			board.setContent(content);
			board.setNextSeq(nextSeq);
			board.setWriter(writer);
			board.setUserId(userId);
			try {
				dao.insertItem(board);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			url = "list.do";
		} else if(command.equals("list.do")) {
			try {
				ArrayList<BoardVO> list = dao.selectAll();
				HttpSession session = req.getSession();
				session.setAttribute("list", list);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.equals("read.do")) {
			String seq = req.getParameter("seq");
			BoardVO board = dao.selectBoard(seq);
			req.setAttribute("board", board);
			url = "./board/read.jsp";
		} else if(command.equals("replyInput.do")) {
			
			
			url = "list.do";
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doHandler(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doHandler(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
	}

}
