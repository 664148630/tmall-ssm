package com.entor.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.entity.Review;
import com.entor.service.ReviewService;

public class ReviewTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ReviewService service = (ReviewService) context.getBean("reviewService");
		List<Review> list = service.queryAll(Review.class);
		for(Review review : list) {
			System.out.println(review);
		}
	}

}
