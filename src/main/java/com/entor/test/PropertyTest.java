package com.entor.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.entity.Property;
import com.entor.service.PropertyService;

public class PropertyTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PropertyService service = (PropertyService) context.getBean("propertyService");
		/*Property property = service.queryById(Property.class, 1);
		System.out.println(property);*/
		
		/*257
		List<Property> list = service.queryAll(Property.class);
        for(Property property : list) {
        	System.out.println(property);
        }*/
		
		List<Property> list = service.queryPropertysByCid(1, 5, 60);
		for(Property property : list) {
			System.out.println(property);
		}
		/*int c = service.getTotalsByCid(60);
		System.out.println(c);*/
	}

}
