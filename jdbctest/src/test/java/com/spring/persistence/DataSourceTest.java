package com.spring.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTest {

	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConnection() throws Exception {
		
		Class clz = Class.forName("oracle.jdbc.OracleDriver");
		
		System.out.println(clz);
		
		Connection con =
				DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"c##spring",
						"spring");
		
		log.info(con);
		
		con.close();
	}
	
	
	@Test
	public void testMyBatis() {
		try(SqlSession session = sqlSessionFactory.openSession();
				Connection con = session.getConnection()){
			log.info(session);		//session °´Ã¼ Ãâ·Â
			log.info(con);			//con °´Ã¼ Ãâ·Â
		}catch(Exception e) {
			e.getMessage();
		}
	}
}
