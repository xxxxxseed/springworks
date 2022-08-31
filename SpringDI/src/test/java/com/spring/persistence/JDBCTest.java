package com.spring.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {

	@Test
	public void testConnection() throws Exception {
		Class<?> clz = Class.forName("oracle.jdbc.OracleDriver");
		
		System.out.println(clz);	//����̹� �̸�
		
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe",
				"c##spring", "spring");
		log.info(con);	//���� ��ü ���
		con.close();
	}
}
