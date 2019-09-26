package com.entor.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.entity.PropertyValue;
import com.entor.service.PropertyValueService;

public class PropertyValueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PropertyValueService service = (PropertyValueService) context.getBean("propertyValueService");
		List<PropertyValue> list = service.queryAll(PropertyValue.class);
		for(PropertyValue propertyValue : list) {
			System.out.println(propertyValue);
			
		}
		
		/*PropertyValue propertyValue = service.queryById(PropertyValue.class, 716);
		System.out.println(propertyValue);*/
	}

}
