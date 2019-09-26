package com.entor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entor.dao.ProductDao;
import com.entor.entity.Product;
import com.entor.service.ProductService;
@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

	@Resource
	private ProductDao productDao;
	@Override
	public List<Product> queryProductsByCid(int currentPage, int pageSize, int cid) {
		// TODO Auto-generated method stub
		return productDao.queryProductsByCid(currentPage, pageSize, cid);
	}

	@Override
	public int getTotalsByCid(int cid) {
		// TODO Auto-generated method stub
		return productDao.getTotalsByCid(cid);
	}

}
