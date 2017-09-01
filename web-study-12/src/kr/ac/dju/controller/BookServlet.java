package kr.ac.dju.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.ac.dju.controller.action.Action;


@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  request.setCharacterEncoding("UTF-8");
	 
	  
		String command = request.getParameter("command");
		System.out.println("BookServlet에서 요쳥을 받음을 확인 : " + command);
		
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);
		
		if(action != null) {
		  action.execute(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	  doGet(request, response);
	}
	
}

