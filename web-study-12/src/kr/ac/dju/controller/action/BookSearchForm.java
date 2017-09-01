package kr.ac.dju.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.dju.dao.BookDAO;
import kr.ac.dju.dto.BookVO;



public class BookSearchForm implements Action{

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String url="book/bookSearch.jsp";
    String search = request.getParameter("search");
    System.out.println(search);
    
    BookDAO bDao = BookDAO.getInstance();
    
    List<BookVO> booklist = bDao.searchBook(search);
    
    request.setAttribute("bookSearchForm", booklist);

    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }

}
