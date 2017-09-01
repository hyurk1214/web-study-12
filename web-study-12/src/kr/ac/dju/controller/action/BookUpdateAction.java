package kr.ac.dju.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.dju.dao.BookDAO;
import kr.ac.dju.dto.BookVO;

public class BookUpdateAction implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    BookVO bVo = new BookVO();
    
    bVo.setNum(Integer.parseInt(request.getParameter("num")));
    bVo.setTitle(request.getParameter("title"));
    bVo.setWriter(request.getParameter("writer"));
    bVo.setPrice(Integer.parseInt(request.getParameter("price")));
    bVo.setPublisher(request.getParameter("publisher"));
    bVo.setPictureUrl(request.getParameter("pictureurl"));
    bVo.setBookcount(Integer.parseInt(request.getParameter("bookcount")));
    bVo.setDescription(request.getParameter("description"));
    
    BookDAO bDao = BookDAO.getInstance();
    bDao.updateBook(bVo);
    
    new BookListAction().execute(request, response);
  }

}
