package com.entor.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.entity.Order;
import com.entor.service.OrderService;

public class OrderTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService service = (OrderService) context.getBean("orderService");
		/*Order order = service.queryById(Order.class, 4);
		System.out.println(order);*/
		
		List<Order> list = service.queryByPage(Order.class, 1, 2);
		for(Order order : list) {
			System.out.println(order);
		}
	}

}
