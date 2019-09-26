package com.entor.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.Category;
import com.entor.entity.Product;
import com.entor.service.CategoryService;
import com.entor.service.ProductService;

@Controller
public class ProductController {
	@Resource
	private ProductService productService;
	/**
	 * 通过CategoryService对象获取Category的id（cid）
	 */
	@Resource
	private CategoryService categoryService;
	
	//listProduct/1/${c.id}   listProduct/2
	@RequestMapping("/listProduct/{currentPage}/{cid}")
	public String listProduct(@PathVariable String currentPage,@PathVariable String cid, Map<String,Object> map) {
		Category category = categoryService.queryById(Category.class, Integer.parseInt(cid));
		int sp = 1;
		int pageSize = 5;
		int totals = productService.getTotalsByCid(Integer.parseInt(cid));
		int pageCounts = totals/pageSize;
		if(totals%pageSize!=0) {
			pageCounts++;
		}
		try {
			sp = Integer.parseInt(currentPage);
		}catch(Exception e) {
			sp = 1;
		}
		if(sp>pageCounts) {
			sp = pageCounts;
		}
		if(sp<1) {
			sp = 1;
		}
		List<Product> listProduct = productService.queryProductsByCid(sp, pageSize, Integer.parseInt(cid));
		map.put("totals", totals);
		map.put("sp", sp);
		map.put("pageCounts", pageCounts);
		map.put("listProduct", listProduct);
		map.put("c", category);
		return "listProduct";
	}

}
