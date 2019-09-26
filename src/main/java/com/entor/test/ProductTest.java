package com.entor.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.entity.Product;
import com.entor.service.ProductService;

public class ProductTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductService service = (ProductService) context.getBean("productService");
		
		List<Product> list = service.queryAll(Product.class);
		for(Product product : list) {
			System.out.println(product);
		}
	}

}
