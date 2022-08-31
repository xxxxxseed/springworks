package com.cloud.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"
})
public class MemberTests {

	@Autowired
	private DataSource ds;
	
	@Autowired
	private PasswordEncoder pwencoder;
	
	//ȸ�� 100�� ����
	/*@Test
	public void testInsertMember() {
		String sql = "INSERT INTO tbl_member(userid, userpw, username) "
				+ "VALUES (?, ?, ?)";
		
		for(int i=0; i<100; i++) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(2, pwencoder.encode("pw"+i));
				if(i < 80) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(3, "�Ϲݻ����" + i);
				}else if(i < 90) {
					pstmt.setString(1, "member" + i);
					pstmt.setString(3, "ȸ��" + i);
				}else {		//90~100
					pstmt.setString(1, "admin" + i);
					pstmt.setString(3, "������" + i);
				}
				pstmt.executeUpdate();		//����
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}//for�� ����
	}*/
	
	@Test
	public void testInsertAuth() {
		String sql = "INSERT INTO tbl_member_auth (userid, auth) "
				+ "VALUES (?, ?)";
		
		for(int i=0; i<100; i++) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				if(i < 80) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(2, "ROLE_USER");
				}else if(i < 90) {
					pstmt.setString(1, "member" + i);
					pstmt.setString(2, "ROLE_MEMBER");
				}else {		//90~100
					pstmt.setString(1, "admin" + i);
					pstmt.setString(2, "ROLE_ADMIN");
				}
				pstmt.executeUpdate();		//����
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}//for�� ����
	}
}
