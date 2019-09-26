package com.entor.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.entor.entity.Category;
import com.entor.service.CategoryService;
@Controller
public class CategoryController {
	@Resource
	private CategoryService categoryService;
	/**
	 * ��ѯ
	 * @param currentPage
	 * @param map
	 * @return
	 */
	@RequestMapping("/listCategory/{currentPage}")
	public String listCategory(@PathVariable String currentPage, Map<String,Object> map) {
		int sp = 1;
		int pageSize = 5;
		int totals = categoryService.getTotals(Category.class);
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
		List<Category> listCategory = categoryService.queryByPage(Category.class, sp, pageSize);
		map.put("totals", totals);
		map.put("sp", sp);
		map.put("pageCounts", pageCounts);
		map.put("listCategory", listCategory);
		return "listCategory";
	}
	
	/**
	 * �޸�
	 * @param category
	 * @param currentPage
	 * @return
	 */
	@RequestMapping("/update")
	public String update(Category category,String currentPage) {
		categoryService.update(category);
		return "redirect:/listCategory/"+currentPage;
	}
	
	//queryById/${sp}/${c.id}
	@RequestMapping("/queryById/{currentPage}/{id}")
	public String queryById(@PathVariable String currentPage,@PathVariable int id,Map<String,Object> map) {
		Category category = categoryService.queryById(Category.class, id);
		map.put("c", category);
		return "editCategory";
	}
	
	/**
	 * ɾ��
	 * @param currentPage
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteById/{currentPage}/{id}")
	public String deleteById(@PathVariable String currentPage,@PathVariable int id) {
		categoryService.deleteById(Category.class, id);
		return "redirect:/listCategory/"+currentPage;
	}
	
	/**
	 * �ļ��ϴ�
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	//String name�����ȡ�������ƵĲ�����Ҫ��jsp��nameֵ��Ӧ��MultipartFile file�����ȡ�����ļ����ƵĲ�����Ҫ��jsp��nameֵ��Ӧ
	@RequestMapping("/uploadFile")
	public String uploadFile(String name,MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException {
		System.out.println(name);
		Category category  = new Category();
		category.setName(name);
		categoryService.add(category);
		String path = request.getServletContext().getRealPath("/img/category/");
		if (file!=null) {
			//�ļ�����
			String contentType = file.getContentType();
			//�ļ�����(ͨ����ȡ��id��Ϊ�ļ�ͼƬ������)
			String fileName = String.valueOf(category.getId());
			//�ļ���С
			long size = file.getSize();
			System.out.println("�ļ����ͣ�"+contentType);
			System.out.println("�ļ����ƣ�"+fileName);
			System.out.println("�ļ���С��"+size);
			//�ϴ��ļ�
			file.transferTo(new File(path, fileName+".jpg"));
			System.out.println(path);
		}
		return "redirect:/listCategory/1";
		
	}
}
