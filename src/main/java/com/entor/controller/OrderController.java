package com.entor.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.Order;
import com.entor.service.OrderService;

@Controller
public class OrderController {

	@Resource
	private OrderService orderService;
	
	@RequestMapping("/listOrder/{currentPage}")
	public String listOrder(@PathVariable String currentPage,Map<String,Object> map) {
		int sp = 1;
		int pageSize = 2;
		int totals = orderService.getTotals(Order.class);
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
		List<Order> listOrder = orderService.queryByPage(Order.class, sp, pageSize);
		map.put("totals", totals);
		map.put("sp", sp);
		map.put("pageCounts", pageCounts);
		map.put("listOrder", listOrder);
		return "listOrder";
	}
}
