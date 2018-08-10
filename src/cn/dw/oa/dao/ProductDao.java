package cn.dw.oa.dao;

import org.apache.ibatis.session.SqlSession;

import cn.dw.oa.model.Product;
import cn.dw.oa.utils.MyBatisUtils;

public class ProductDao {
	
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		Product product = new Product();
		product.setName("mybatis测试");
		dao.save(product);
	}
	// 数据更新需要事务提交才能生效,不同框架解决方案不同: jdbc + jdbcTemplate：自动提交, mybatis 手动提交
	public void save(Product product) {
		SqlSession session = MyBatisUtils.getSession();
		try {
			session.insert("aa.bb.cc.save", product);
			session.commit();
		}catch (Exception e) {
			session.rollback();
			throw new RuntimeException(e);
		}finally {
			MyBatisUtils.close(session);
		}
		
		
	}
}
