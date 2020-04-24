package kr.co.moosong.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import kr.co.moosong.controller.DBController;
import kr.co.moosong.model.Member;

public class MemberDao {
	//회원가입
	public boolean insert(Member m) {
		boolean result = false;
		
		Connection con = null;
		Statement stmt = null;
//		ResultSet rs = null;
		
		try {
			con = DBController.getConnection();
			stmt = con.createStatement();
			if(stmt.executeUpdate("INSERT INTO members(email, nick, pass) VALUES("
			+m.getEmail()+","+m.getNick()+",PASSWORD('"+m.getPassword()+"'));")>0) {
				result = true;
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBController.close(stmt, con);
		}
		return result;
	}
	
	//회원탈퇴
	public boolean delete(Member m) {
		boolean result = false;
		
		Connection con = null;
		Statement stmt = null;
//		ResultSet rs = null;
		
		try {
			con = DBController.getConnection();
			stmt = con.createStatement();
			String sql = "Delete from members where email like '"+m.getEmail()+"'";
			if(stmt.executeUpdate(sql)>0) {
				System.out.println(result);
				result = true;
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBController.close(stmt, con);
		}
		return result;
	}
	
	//회원조회
	public Member search(String email, String password) {
		Member m = null;
		
		Connection con = null;
		 Statement stmt = null;
		 ResultSet rs = null;
		 
		 try {
			con = DBController.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * from members Where email='"+email+"' and pass=password("+password+")");
			
			if (rs.next()) {
				m = new Member();
				m.setEmail(rs.getString("email"));
				m.setNick(rs.getString("nick"));
				m.setPassword(rs.getString("pass"));
				m.setRegdate(rs.getString("regdate"));
				m.setRemoveAt(rs.getString("remove_at"));
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBController.close(rs, stmt, con);
		}
		return m;
	}
	
	//회원목록가져오기
	public ArrayList<Member> getMemberList() {//String pattern
		ArrayList<Member> list = new ArrayList<Member>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = DBController.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * from members;");
			
			if (rs.next()) {
				Member m = new Member();
				m.setEmail(rs.getString("email"));
				m.setNick(rs.getString("nick"));
				m.setPassword(rs.getString("pass"));
				m.setRegdate(rs.getString("regdate"));
				m.setRemoveAt(rs.getString("remove_at"));
				list.add(m);
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBController.close(rs, stmt, con);
		}
		
		
		return list;
	}
}
