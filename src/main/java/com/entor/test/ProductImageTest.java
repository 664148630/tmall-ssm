package com.entor.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.entity.ProductImage;
import com.entor.service.ProductImageService;

public class ProductImageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductImageService service = (ProductImageService) context.getBean("productImageService");
		
	    List<ProductImage> list = service.queryAll(ProductImage.class);
	    for(ProductImage productImage : list) {
	    	System.out.println(productImage);
	    }
	}

}
