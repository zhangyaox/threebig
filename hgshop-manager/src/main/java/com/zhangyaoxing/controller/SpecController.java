package com.zhangyaoxing.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhangyaoxing.entity.Spec;
import com.zhangyaoxing.service.SpecService;

@Controller
@RequestMapping("spec")
public class SpecController {
	
	@Reference
	SpecService specService;
	
	@RequestMapping("list")
	public String list(@RequestParam(defaultValue ="1") int page,String name,Model m) {
		PageInfo<Spec> list = specService.list(name, page);
		m.addAttribute("info", list);
		return "spec/list";
	}
	@ResponseBody
	@RequestMapping("add")
	public String add(Spec spec) {
		System.out.println("spec" + spec);
				System.out.println();
				spec.getOptions().removeIf(x->{return x.getOptionName()==null;});
				System.out.println("spec 处理后：" + spec);
				//调用服务
				int add = specService.add(spec);
				return add>0?"success":"false";
	}
}
