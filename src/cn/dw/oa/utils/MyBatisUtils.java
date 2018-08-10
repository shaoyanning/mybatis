package cn.dw.oa.utils;

import java.io.InputStream;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	
	private MyBatisUtils() {
		
	}
	// mysql:sqlsession就是jdbc connection
	private static SqlSessionFactory sessionFactory = null;
	
	public static SqlSession getSession() {
		return sessionFactory.openSession();
	}
	
	public static void close(SqlSession sqlSession) {
		if(sqlSession!=null)
			sqlSession.close();
	}
	
	
	public static void main(String[] args) {
		SqlSession session = MyBatisUtils.getSession();
		System.out.println(session.getConnection());
	}
	
	static {
		// 读取mybatis.cfg.xml
		InputStream input = MyBatisUtils.class.getResourceAsStream("/mybatis.cfg.xml");
		sessionFactory = new SqlSessionFactoryBuilder().build(input);
	}

}
