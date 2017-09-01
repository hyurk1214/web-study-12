package kr.ac.dju.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.dju.controller.action.Action;
import kr.ac.dju.dao.JoinDAO;
import kr.ac.dju.dto.JoinVO;


@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
   
    public JoinServlet() {
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
    
    request.setCharacterEncoding("UTF-8");
    
    String name = request.getParameter("name");
    String userid = request.getParameter("userid");
    String pwd = request.getParameter("pwd");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String admin = request.getParameter("admin");
    
    JoinVO jVo = new JoinVO();
    
    jVo.setName(name);
    jVo.setUserid(userid);
    jVo.setPwd(pwd);
    jVo.setEmail(email);
    jVo.setPhone(phone);
    jVo.setAdmin(Integer.parseInt(admin));
    
    JoinDAO jDao = JoinDAO.getInstance();
    int result = jDao.insertJoin(jVo);
    
    HttpSession session = request.getSession();
    
    if(result == 1) {
      session.setAttribute("userid", jVo.getUserid());
      request.setAttribute("message", "회원가입에 성공했습니다.");
    }else {
      request.setAttribute("message", "회원 가입에 실패했습니다.");
    }
    
//    RequestDispatcher dispatcher = request.getRequestDispatcher("/book/bookjoin.jsp");
//    dispatcher.forward(request, response);
    response.sendRedirect("BookServlet?command=book_List2");
  }

}
