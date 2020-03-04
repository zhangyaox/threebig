package com.zhangyaoxing.service;

import com.github.pagehelper.PageInfo;
import com.zhangyaoxing.entity.Spec;

public interface SpecService {
	PageInfo<Spec> list(String name,int page);
	
	int add(Spec spec);
	
	int update(Spec spec);
	
	int delete(int id);
	
	//查找一个规格
	Spec findByid(int id);
	
	//批量删除
	int deletebatch(String id);
}
