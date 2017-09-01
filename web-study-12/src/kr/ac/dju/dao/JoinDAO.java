package kr.ac.dju.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.ac.dju.dto.JoinVO;
import util.DBManager;


public class JoinDAO {
	private JoinDAO() {}
	
	private static JoinDAO instance = new JoinDAO();
	
	public static JoinDAO getInstance() {
		return instance;
	}
	
	public int insertJoin(JoinVO jVo) {
		String sql = "insert into join(name, userid, pwd ,email ,phone ,admin) values(?,?,?,?,?,?)";
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, jVo.getName());
			pstmt.setString(2, jVo.getUserid());
			pstmt.setString(3, jVo.getPwd());
			pstmt.setString(4, jVo.getEmail());
			pstmt.setString(5, jVo.getPhone());
			pstmt.setInt(6, jVo.getAdmin());
			
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	 public int userCheck(String userid , String pwd) {
	    int result = -1;
	    String sql = "select pwd from join where userid = ?" ;
	    
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	   
	    try {
	      conn = DBManager.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, userid);
	      rs = pstmt.executeQuery();
	     
	      if(rs.next()) {
	        if(rs.getString("pwd")!= null && rs.getString("pwd").equals(pwd)) {
	          result = 1;
	        }else {
	          result = 0;
	        }
	      }else {
	        result = -1;
	      }
	    }catch(SQLException e) {
	      e.printStackTrace();
	      System.out.println("usercheck");
	    }finally {
	      DBManager.close(conn, pstmt , rs);
	      }
	    
	    return result;
	  }
	  
	  public JoinVO getLogin(String userid) {
	    JoinVO jVo = null;
	    String sql = "select * from join where userid=?";
	    
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	      conn = DBManager.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, userid);
	      rs = pstmt.executeQuery();
	      
	      if (rs.next()) {
	        jVo = new JoinVO();
	        
	        jVo.setName(rs.getString("name"));
	        jVo.setUserid(rs.getString("userid"));
	        jVo.setPwd(rs.getString("pwd"));
	        jVo.setEmail(rs.getString("email"));
	        jVo.setPhone(rs.getString("phone"));
	        jVo.setAdmin(rs.getInt("admin"));
	      }
	    }catch(SQLException e) {
	      e.printStackTrace();
	      System.out.println("getLogin");
	    }finally {
	      DBManager.close(conn, pstmt,rs);
	    }
	    return jVo;
	  }
}
