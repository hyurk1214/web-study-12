package kr.ac.dju.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.ac.dju.controller.action.Action;
import kr.ac.dju.dao.BookDAO;
import kr.ac.dju.dto.BookVO;


@WebServlet("/BookInsertServlet")
public class BookInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BookInsertServlet() {
        super();
        
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
		
    request.setCharacterEncoding("UTF-8");
    
    ServletContext context = getServletContext();
    String path = context.getRealPath("upload");
    String encType="UTF-8";
    int sizeLimit = 20 * 1024 * 1024;
    
    MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
     
    String title = multi.getParameter("title");
    int price = Integer.parseInt(multi.getParameter("price"));
    String description = multi.getParameter("description");
    String writer = multi.getParameter("writer");
    String publisher = multi.getParameter("publisher");
    int bookcount = Integer.parseInt(multi.getParameter("bookcount"));
    String pictureUrl = multi.getFilesystemName("pictureUrl");
    
    BookVO bVo = new BookVO();
   
    bVo.setPictureUrl(pictureUrl);
    bVo.setTitle(title);
    bVo.setDescription(description);
    bVo.setWriter(writer);
    bVo.setPrice(price);
    bVo.setBookcount(bookcount);
    bVo.setPublisher(publisher);
    
    BookDAO bDao = BookDAO.getInstance();
    bDao.insertBook(bVo);
 
    response.sendRedirect("BookServlet?command=book_list");
	}

}
