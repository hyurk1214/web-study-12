package kr.ac.dju.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.dju.dao.BookDAO;
import kr.ac.dju.dto.BookVO;

public class BookUpdateFormAction implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    String url="/book/bookUpdate.jsp";
    
    String num = request.getParameter("num");
    
    BookDAO bDao = BookDAO.getInstance();
    
    BookVO bVo = bDao.selectOneBookByNum(num);
    
    request.setAttribute("book", bVo);
    
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }

}
