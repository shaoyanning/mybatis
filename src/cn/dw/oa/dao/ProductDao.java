package cn.dw.oa.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.dw.oa.model.Product;
import cn.dw.oa.utils.MyBatisUtils;

public class ProductDao {

	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
//		System.out.println(dao.getById(3));
		List<Product> pList = dao.queryByName("",1,5);
		for(Product temp:pList) {
			System.out.println(temp);
		}
		// Product product = new Product();
		// product.setName("mybatis测试");
		// product.setId(8);
		// product.setRemark("新的备注");
		// product.setPrice(300.00);
		//// dao.update(product);
		// dao.delete(5);
	}

	public Product getById(int id) {
		SqlSession session = MyBatisUtils.getSession();
		try {
			return session.selectOne("aa.bb.cc.getById", id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			MyBatisUtils.close(session);
		}
	}

	public List<Product> queryByName(String keyword, int page, int size) {
		SqlSession session = MyBatisUtils.getSession();
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("keyword", "%" + keyword + "%");
			paramMap.put("start", (page - 1) * size);
			paramMap.put("size", size);
			return session.selectList("aa.bb.cc.queryByName", paramMap);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			MyBatisUtils.close(session);
		}
	}

	// 数据更新需要事务提交才能生效,不同框架解决方案不同: jdbc + jdbcTemplate：自动提交, mybatis 手动提交
	public void save(Product product) {
		SqlSession session = MyBatisUtils.getSession();
		try {
			session.insert("aa.bb.cc.save", product);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw new RuntimeException(e);
		} finally {
			MyBatisUtils.close(session);
		}
	}

	public void update(Product product) {
		SqlSession session = MyBatisUtils.getSession();
		try {
			session.update("aa.bb.cc.update", product);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw new RuntimeException(e);
		} finally {
			MyBatisUtils.close(session);
		}
	}

	public void delete(int id) {
		SqlSession session = MyBatisUtils.getSession();
		try {
			session.delete("aa.bb.cc.delete", id);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw new RuntimeException(e);
		} finally {
			MyBatisUtils.close(session);
		}
	}

}
