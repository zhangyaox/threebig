package com.zhangyaoxing.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhangyaoxing.entity.Sku;
import com.zhangyaoxing.entity.Spec;
import com.zhangyaoxing.entity.SpecOption;
import com.zhangyaoxing.entity.Spu;
import com.zhangyaoxing.service.SkuService;
import com.zhangyaoxing.service.SpecService;
import com.zhangyaoxing.service.SpuService;

@Controller
@RequestMapping("sku")
public class SkuController {
	@Reference
	SkuService skuService;
	@Reference
	SpuService spuService;
	@Reference
	SpecService specService;
	
	@RequestMapping("list")
	public String list(@RequestParam(defaultValue = "1") int page,Model m,Sku sku) {
		PageInfo<Sku> list = skuService.list(sku, page);
		m.addAttribute("info", list);
		return "sku/list";
	}
	
	@RequestMapping("xq")
	public String xq(int id,Model m) {
		Sku find = skuService.find(id);
		m.addAttribute("find", find);
		return "sku/detail";
	}
	
	@RequestMapping("toaddsku")
	public String toaddsku(int id,Model m) {//id是商品的id
		Spu selSpu = spuService.selSpu(id);//要给哪一个商品添加sku
		m.addAttribute("spu", selSpu);
		List<Spec> listSpec = specService.listSpec();//查找所有的属性
		m.addAttribute("listSpec", listSpec);
		return "sku/add";
	}
	
	@ResponseBody
	@RequestMapping("addsku")
	public int addsku(Sku sku,int[] specids,int[] specOptionIds) {//id是商品的id
		List<SpecOption> specs = new ArrayList<>();
		
		System.out.println("specIds + " + specids.length + " and specOptionIds is " + specOptionIds.length);
		
		
		for (int i = 0; i < specids.length && i < specOptionIds.length; i++) {
			int j = specids[i];
			SpecOption specOption = new SpecOption();
			//属性的id
			specOption.setSpecId(specids[i]);
			// 具体的属性值 的id
			specOption.setId(specOptionIds[i]);
			specs.add(specOption);
		}
		//存放属性的数据
		sku.setSpecs(specs);
		int addSku = skuService.addSku(sku);
		return addSku;
	}
}
