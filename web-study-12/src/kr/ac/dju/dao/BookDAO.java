package kr.ac.dju.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.dju.dto.BookVO;
import util.DBManager;

public class BookDAO {
  private BookDAO() {}
  private static BookDAO instance = new BookDAO();
  
  public static BookDAO getInstance() {
    return instance;
  }
  
  public List<BookVO> selectAllBooks(){
    String sql = "select * from book order by num desc";
    
    List<BookVO> list = new ArrayList<BookVO>();
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      conn = DBManager.getConnection();
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
      
      while(rs.next()) {
        BookVO bVo = new BookVO();
        
        bVo.setNum(rs.getInt("num"));
        bVo.setTitle(rs.getString("title"));
        bVo.setWriter(rs.getString("writer"));
        bVo.setPublisher(rs.getString("publisher"));
        bVo.setPrice(rs.getInt("price"));
        bVo.setPictureUrl(rs.getString("pictureUrl"));
        bVo.setDescription(rs.getString("description"));
        bVo.setBookcount(rs.getInt("bookcount"));
        
        list.add(bVo);
        
      }
    }catch(SQLException e) {
      e.printStackTrace();
    }finally {
      DBManager.close(conn, stmt, rs);
    }
    return list;
  }
  
  public BookVO selectOneBookByNum(String num) {
    String sql = "select * from book where num =?";
    
    BookVO bVo = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    try {
      conn = DBManager.getConnection();
      
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, num);
      
      rs = pstmt.executeQuery();
      
      if(rs.next()) {
        bVo = new BookVO();
        bVo.setNum(rs.getInt("num"));
        bVo.setTitle(rs.getString("title"));
        bVo.setWriter(rs.getString("Writer"));
        bVo.setPublisher(rs.getString("publisher"));
        bVo.setPrice(rs.getInt("price"));
        bVo.setPictureUrl(rs.getString("pictureUrl"));
        bVo.setDescription(rs.getString("description"));
        bVo.setBookcount(rs.getInt("bookcount"));
      }
    }catch(Exception e) {
      e.printStackTrace();
    }finally {
      DBManager.close(conn, pstmt, rs);
    }
    return bVo;
  }
 

  public void insertBook(BookVO bVo) {
    String sql = "insert into book(num, title , writer , publisher, price, pictureurl , description , bookcount) values(book_seq.nextval,?,?,?,?,?,?,?)";
    
      Connection conn = null;
      PreparedStatement pstmt = null;
    
      try {
        conn = DBManager.getConnection();
        pstmt = conn.prepareStatement(sql);
        
        pstmt.setString(1, bVo.getTitle());
        pstmt.setString(2, bVo.getWriter());
        pstmt.setString(3, bVo.getPublisher());
        pstmt.setInt(4, bVo.getPrice());
        pstmt.setString(5, bVo.getPictureUrl());
        pstmt.setString(6, bVo.getDescription());
        pstmt.setInt(7, bVo.getBookcount());
        
        pstmt.executeUpdate();
        
      }catch(SQLException e) {
        e.printStackTrace();
      }finally {
        DBManager.close(conn, pstmt);
      }
  }
  
  public void updateBook(BookVO bVo) {
    String sql = "update book set title=?, writer=?, publisher=?, price=?, pictureurl=?, description=?, bookcount=? where num=?";
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    
    try {
      conn = DBManager.getConnection();
      pstmt = conn.prepareStatement(sql);
      
      pstmt.setString(1, bVo.getTitle());
      pstmt.setString(2, bVo.getWriter());
      pstmt.setString(3, bVo.getPublisher());
      pstmt.setInt(4, bVo.getPrice());
      pstmt.setString(5, bVo.getPictureUrl());
      pstmt.setString(6, bVo.getDescription());
      pstmt.setInt(7, bVo.getBookcount());
      pstmt.setInt(8, bVo.getNum());
      
      pstmt.executeUpdate();
    }catch(SQLException e) {
      e.printStackTrace();
    }finally {
      DBManager.close(conn, pstmt);
    }
  }
  public List<BookVO> searchBook(String search) {
    
    
    List<BookVO> list = new ArrayList<BookVO>();
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
 
    
    try {
      conn = DBManager.getConnection();
      stmt =  conn.createStatement();
      //pstmt = conn.prepareStatement(sql);
      //pstmt.setString(1, search);
      //rs = pstmt.executeQuery();
      String sql = "select * from book where title like '%" + search + "%' or writer like '%"+search+"%' or publisher like '%"+search+"%'";
      rs = stmt.executeQuery(sql);
      
      while(rs.next()) {
        BookVO bVo = new BookVO();
        
        bVo.setNum(rs.getInt("num"));
        bVo.setTitle(rs.getString("title"));
        bVo.setWriter(rs.getString("writer"));
        bVo.setPublisher(rs.getString("publisher"));
        bVo.setPrice(rs.getInt("price"));
        bVo.setPictureUrl(rs.getString("pictureUrl"));
        bVo.setDescription(rs.getString("description"));
        bVo.setBookcount(rs.getInt("bookcount"));
        
        list.add(bVo);
        
      }
    }catch(SQLException e) {
      e.printStackTrace();
    }finally {
      DBManager.close(conn, stmt, rs);
    }
    return list;
  }
  
  public void deleteBook(String num) {
    String sql = "delete book where num=?";
    
    Connection conn = null;
    PreparedStatement pstmt = null;
  
    try {
      conn = DBManager.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, num);
      pstmt.executeUpdate();
      
    }catch(SQLException e) {
      e.printStackTrace();
    }finally {
      DBManager.close(conn, pstmt);
    }
  }
}
