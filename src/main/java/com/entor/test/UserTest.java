package com.entor.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.entity.User;
import com.entor.service.UserService;

public class UserTest {

	public static void main(String[] args) {
		// TODO Auto-generated m0ethod stub

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = (UserService) context.getBean("userService");
		/*User user = service.queryById(User.class, 1);
		System.out.println(user);*/
		
		List<User> list = service.queryByPage(User.class, 1, 5);
		for(User user : list) {
			System.out.println(user);
		}
	}

}
