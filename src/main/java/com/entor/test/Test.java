package com.entor.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.entity.Category;
import com.entor.service.CategoryService;

public class Test {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryService service = (CategoryService)context.getBean("categoryService");
		
//		Category category = service.queryById(Category.class, 60);
//		System.out.println(category);
		
		/*List<Category> list = service.queryByPage(Category.class, 1, 5);
		for(Category category : list) {
			System.out.println(category);
		}*/
		
	/*	int category = service.getTotals(Category.class);
		System.out.println(category);*/
		
		/*Category category = new Category();
		category.setName("蓝牙耳机");
		service.add(category);*/
//		System.out.println("成功新增"+category+"条数据");
		
//		service.deleteById(Category.class, 88);
		
		Category category = new Category();
		category.setId(85);
		category.setName("无线耳机");
		service.update(category);
	}
}
