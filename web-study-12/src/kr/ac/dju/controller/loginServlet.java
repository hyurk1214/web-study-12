package kr.ac.dju.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.dju.controller.action.Action;
import kr.ac.dju.dao.JoinDAO;
import kr.ac.dju.dto.JoinVO;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
      request.setCharacterEncoding("UTF-8");
     
      
      String command = request.getParameter("command");
      System.out.println("BoardServlet 요청을 받음 : " + command);
      
      ActionFactory af = ActionFactory.getInstance();
      Action action = af.getAction(command);
      
      if(action != null) {
        action.execute(request, response);
  }
}
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    String url="book/booklogin.jsp";
    
    String userid = request.getParameter("userid");
    String pwd = request.getParameter("pwd");
    
    JoinDAO jDao = JoinDAO.getInstance();
    int result = jDao.userCheck(userid, pwd);
    
    if(result == 1) {
      JoinVO jVo = jDao.getLogin(userid);
      HttpSession session = request.getSession();
      session.setAttribute("loginUser", jVo);
      request.setAttribute("message", "로그인에 성공했습니다.");
      url="/BookServlet?command=book_List2";
    }else if (result == 0) {
      request.setAttribute("message", "비밀번호가 맞지 않습니다.");
    }else if (result == -1) {
      request.setAttribute("message", "존재하지 않는 회원 입니다.");
    }
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
    //response.sendRedirect("BookServlet?command=book_List2");
  }
  
}
