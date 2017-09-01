package kr.ac.dju.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.ac.dju.dao.JoinDAO;

import kr.ac.dju.dto.JoinVO;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");

		  JoinVO jVo = new JoinVO();
		  
		jVo.setName(request.getParameter("name"));
		jVo.setUserid(request.getParameter("userid"));
		jVo.setPwd(request.getParameter("pwd"));
		jVo.setEmail(request.getParameter("email"));
		jVo.setPhone(request.getParameter("phone"));
		jVo.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		
		JoinDAO jDao = JoinDAO.getInstance();
		jDao.insertJoin(jVo);
		
		new BookListAction().execute(request, response);
	}

}
