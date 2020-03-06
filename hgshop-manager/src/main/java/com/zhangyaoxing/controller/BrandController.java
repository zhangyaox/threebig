package com.zhangyaoxing.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhangyaoxing.entity.Brand;
import com.zhangyaoxing.service.BrandService;

@Controller
@RequestMapping("brand")
public class BrandController {
	
	@Reference
	BrandService brandService;
	
	@RequestMapping("list")
	public String list(@RequestParam(defaultValue = "1")int page,String name,Model m) {
		PageInfo<Brand> listBrand = brandService.listBrand(name, page);
		m.addAttribute("info", listBrand);
		return "brand/list";
	}
	
	@ResponseBody
	@RequestMapping("add")
	public Object add(Brand brand) {
		System.err.println(brand);
		
		return brandService.addBrand(brand);
	}
	
	@ResponseBody
	@RequestMapping("upda")
	public Brand upda(int id) {
		
		return brandService.listBrandById(id);
	}
	
	@ResponseBody
	@RequestMapping("upd")
	public Object upd(Brand brand) {
		System.err.println(brand);
		return brandService.updBrand(brand);
	}
	@ResponseBody
	@RequestMapping("delspec")
	public Object delspec(int id) {

		return brandService.delBrand(id);
	}
}
