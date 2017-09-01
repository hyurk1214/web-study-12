package kr.ac.dju.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.dju.dao.BookDAO;
import kr.ac.dju.dto.BookVO;

public class BookListAction implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    String url="/book/bookList.jsp";
    
    
    BookDAO bDao = BookDAO.getInstance();
    
    List<BookVO> bookList = bDao.selectAllBooks();
    
    request.setAttribute("bookList", bookList);
    
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }
  
  

}
