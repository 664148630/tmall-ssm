package com.entor.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.Category;
import com.entor.entity.Property;
import com.entor.service.CategoryService;
import com.entor.service.PropertyService;

@Controller
public class PropertyController {

	@Resource
	private PropertyService propertyService;
	/**
	 * ͨ��CategoryService�ӿڶ����ȡCategory��id��cid��
	 */
	@Resource
	private CategoryService categoryService;
	
	@RequestMapping("/listProperty/{currentPage}/{cid}")
	public String listProperty(@PathVariable String currentPage,@PathVariable String cid , Map<String,Object> map) {
		Category category = categoryService.queryById(Category.class, cid);
		//��ǰҳ��
		int sp = 1;
		//ÿҳ��¼��
		int pageSize = 5;
		int totals = propertyService.getTotalsByCid(Integer.parseInt(cid));
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
		List<Property> listProperty = propertyService.queryPropertysByCid(sp,pageSize,Integer.parseInt(cid));
		map.put("totals", totals);
		map.put("sp", sp);
		map.put("pageCounts", pageCounts);
		map.put("listProperty", listProperty);
		map.put("c", category);
		return "listProperty";
	}
	
	/**
	 * �޸�
	 * @param category
	 * @param currentPage
	 * @return
	 */
	/*@RequestMapping("/update")
	public String update(Property property,String currentPage) {
		propertyService.update(property);
		return "redirect:/listProperty/"+currentPage;
	}
	
	//queryById/${sp}/${c.id}
	@RequestMapping("/queryByIdProduct/{currentPage}/{id}")
	public String queryByIdProduct(@PathVariable String currentPage,@PathVariable int id,Map<String,Object> map) {
		Property property = propertyService.queryById(Property.class, id);
		map.put("p", property);
		return "editProperty";
	}*/
	
	/**
	 * ɾ��
	 * @param currentPage
	 * @param id
	 * @return
	 */
	/*@RequestMapping("/deleteById/{currentPage}/{id}")
	public String deleteById(@PathVariable String currentPage,@PathVariable int id) {
		categoryService.deleteById(Category.class, id);
		return "redirect:/listCategory/"+currentPage;
	}*/
}
