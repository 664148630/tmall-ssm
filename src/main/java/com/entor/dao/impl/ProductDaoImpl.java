package com.entor.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.entor.dao.ProductDao;
import com.entor.entity.Product;
@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

	@Override
	public int getTotalsByCid(int cid) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(Product.class.getSimpleName()+".getTotalsByCid",cid);
	}

	@Override
	public List<Product> queryProductsByCid(int currentPage, int pageSize, int cid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage", (currentPage-1)*pageSize);
		map.put("pageSize", currentPage*pageSize);
		map.put("cid", cid);
		return getSqlSession().selectList(Product.class.getSimpleName()+".queryProductsByCid",map);
	}

}
