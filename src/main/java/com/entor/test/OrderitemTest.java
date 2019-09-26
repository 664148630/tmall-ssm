package com.entor.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.entity.Orderitem;
import com.entor.service.OrderitemService;

public class OrderitemTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderitemService service = (OrderitemService) context.getBean("orderitemService");
		/*Orderitem orderitem = service.queryById(Orderitem.class, 4);
		System.out.println(orderitem);*/
		
		/*List<Orderitem> list = service.queryByPage(Orderitem.class, 1, 2);
		for(Orderitem orderitem : list) {
			System.out.println(orderitem);
		}*/
		
		List<Orderitem> list = service.queryAll(Orderitem.class);
		for(Orderitem orderitem : list) {
			System.out.println(orderitem);
		}
	}

}
