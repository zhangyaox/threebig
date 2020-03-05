package com.zhangyaoxing.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangyaoxing.entity.Spec;
import com.zhangyaoxing.entity.SpecOption;
import com.zhangyaoxing.mapper.SpecMapper;
import com.zhangyaoxing.service.SpecService;
@Service(interfaceClass =SpecService.class)// 
public class SpecServiceImpl implements SpecService {
	
	@Autowired
	SpecMapper specMapper;
	
	public PageInfo<Spec> list(String name, int page) {
		PageHelper.startPage(page, 3);
		List<Spec> list = specMapper.list(name);
		return new PageInfo<Spec>(list);
	}

	public int add(Spec spec) {
		System.err.println(spec.getSpec_name());
		//添加主表
		int add = specMapper.add(spec);
		//获取主键id
		List<SpecOption> options = spec.getOptions();
		//添加子表
		int n=1;
		//要返回受影响的条数
		for (SpecOption specOption : options) {
			specOption.setSpecId(spec.getId());//添加返回的id 是子表的外键
			specMapper.addOption(specOption);
			n++;//计算成功次数
		}
		return n;
	}

	public int update(Spec spec) {//修改功能
		//删除子表
		specMapper.deleteSpecotion(spec.getId());//删除子表中的主表的键
		//修改主表
		int update = specMapper.update(spec);
		//添加子表
		for (SpecOption specOption : spec.getOptions()) {
			specOption.setSpecId(spec.getId());//添加返回的id 是子表的外键
			specMapper.addOption(specOption);
		}
		return update;
	}

	public int delete(int id) {
		//首先删除子表
		specMapper.deleteSpecotion(id);
		//删除主表
		int deleteSpec = specMapper.deleteSpec(id);
		return deleteSpec;
	}

	public Spec findByid(int id) {
		// TODO Auto-generated method stub
		return specMapper.get(id);
	}

	public int deletebatch(String id) {
		int deletebatch = specMapper.deletebatch(id);
		return deletebatch;
	}

}
