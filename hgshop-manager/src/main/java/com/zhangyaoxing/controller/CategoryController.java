package com.zhangyaoxing.controller;

import java.util.List;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangyaoxing.entity.Category;
import com.zhangyaoxing.service.CategoryService;

@Controller
@RequestMapping("cat")
public class CategoryController {
	
	@Reference
	CategoryService categoryService;
	
	@RequestMapping("list")
	public String list() {
		return "cat/list";
	}
	
	@RequestMapping("treedata")
	@ResponseBody
	public List<Category> treedata(){
		List<Category> listCategory = categoryService.listCategory();
		
		return listCategory;
	}
	@RequestMapping("add")
	@ResponseBody
	public String add(@RequestParam(defaultValue = "1")int id,String name){
		Category category = new Category();
		category.setName(name);
		category.setParent_id(id);
		return categoryService.addCategory(category)>0?"success":"failed";
	}
	@RequestMapping("del")
	@ResponseBody
	public String del(int id){

		return categoryService.deleteCategory(id)>0?"success":"failed";
	}
	@RequestMapping("upd")
	@ResponseBody
	public String upd(Category category){
		
		return categoryService.updateCategory(category)>0?"success":"failed";
	}
}
