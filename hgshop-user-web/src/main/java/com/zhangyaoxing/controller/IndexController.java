package com.zhangyaoxing.controller;

import java.util.List;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.zhangyaoxing.entity.Sku;
import com.zhangyaoxing.entity.Spu;
import com.zhangyaoxing.entity.SpuVo;
import com.zhangyaoxing.service.SkuService;
import com.zhangyaoxing.service.SpuService;

@Controller
public class IndexController {
	
	@Reference
	SpuService SpuService;
	@Reference
	SkuService SkuService;
	
	@RequestMapping({"index","/"})
	public String index(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "0") int catid,Model m) {//进入首页
		PageInfo<Spu> listSpu = SpuService.listSpu(page, new SpuVo());
		m.addAttribute("info", listSpu);
		return "index";
	}
	
	@RequestMapping("detail")//显示商品详情
	public String toindex(int spuid,Model m) {//进入首页  int spuid
		Spu selSpu = SpuService.selSpu(spuid);
		//根据spu 的id 获取使有sku
		List<Sku> bySpuid = SkuService.getBySpuid(spuid);
		m.addAttribute("spu", selSpu);
		m.addAttribute("bySpuid", bySpuid);
		return "detail";
	}
}
