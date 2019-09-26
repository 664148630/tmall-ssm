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
	 * 查询
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
	 * 修改
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
	 * 删除
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
	 * 文件上传
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	//String name代表获取的是名称的参数，要与jsp的name值对应，MultipartFile file代表获取的是文件名称的参数，要与jsp的name值对应
	@RequestMapping("/uploadFile")
	public String uploadFile(String name,MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException {
		System.out.println(name);
		Category category  = new Category();
		category.setName(name);
		categoryService.add(category);
		String path = request.getServletContext().getRealPath("/img/category/");
		if (file!=null) {
			//文件类型
			String contentType = file.getContentType();
			//文件名称(通过获取的id作为文件图片的名称)
			String fileName = String.valueOf(category.getId());
			//文件大小
			long size = file.getSize();
			System.out.println("文件类型："+contentType);
			System.out.println("文件名称："+fileName);
			System.out.println("文件大小："+size);
			//上传文件
			file.transferTo(new File(path, fileName+".jpg"));
			System.out.println(path);
		}
		return "redirect:/listCategory/1";
		
	}
}
