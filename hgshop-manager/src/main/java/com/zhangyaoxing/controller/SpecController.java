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
		System.err.println("---===="+name);
		PageInfo<Spec> list = specService.list(name, page);
		m.addAttribute("info", list);
		return "spec/list";
	}
	
	@ResponseBody
	@RequestMapping("add")
	public Object add(Spec spec) {
				System.out.println("spec" + spec);
				System.out.println();
				spec.getOptions().removeIf(x->{return x.getOptionName()==null;});
				System.out.println("spec 处理后：" + spec);
				//调用服务
				int add = specService.add(spec);
				return add>0?"success":"false";
	}
	
	@ResponseBody
	@RequestMapping("update")
	public Object update(Spec spec) {//修改
		System.out.println("spec" + spec);
		System.out.println();
		spec.getOptions().removeIf(x->{return x.getOptionName()==null;});
		System.out.println("spec 处理后：" + spec);
		//调用服务
		int add = specService.update(spec);
		return add>0?"success":"false";
	}
	
	@ResponseBody
	@RequestMapping("delspec")
	public Object delspec(int id) {
		int delete = specService.delete(id);
		return delete>0?"success":"false";
	}
	
	@ResponseBody
	@RequestMapping("delspecbathch")//批量删除
	public Object delspecbathch(String id) {
		int delete = specService.deletebatch(id);
		return delete>0?"success":"false";
	}
	
	@ResponseBody
	@RequestMapping("openupdate")//查找修改单行
	public Spec openUpdate(int id) {
		Spec findByid = specService.findByid(id);
		System.err.println(findByid);
		return findByid;
	}
	
}
