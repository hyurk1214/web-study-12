package kr.ac.dju.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.dju.dao.BookDAO;

public class BookDeleteAction implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    
    String num = request.getParameter("num");
    
    BookDAO bDao = BookDAO.getInstance();
    
    bDao.deleteBook(num);
    
    new BookListAction().execute(request, response);
  }

}
