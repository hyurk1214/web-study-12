package kr.ac.dju.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.dju.controller.action.Action;
import kr.ac.dju.dao.BookDAO;


@WebServlet("/BookDeleteServlet")
public class BookDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BookDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  request.setCharacterEncoding("UTF-8");
    
    
    String command = request.getParameter("command");
    System.out.println("BoardServlet에서 요쳥을 받음을 확인 : " + command);
    
    ActionFactory af = ActionFactory.getInstance();
    Action action = af.getAction(command);
    
    if(action != null) {
      action.execute(request, response);
    }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  
	  request.setCharacterEncoding("UTF-8");
		String num = request.getParameter("num");
		
		BookDAO bDao = BookDAO.getInstance();
		
		bDao.deleteBook(num);
		
		response.sendRedirect("BookServlet?command=book_list");
		
		
	}

}
