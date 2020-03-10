package com.zhangyaoxing.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhangyaoxing.entity.Brand;

public interface BrandService {
	PageInfo<Brand> listBrand(String name,int page);
	int addBrand(Brand brand);
	int delBrand(int id);
	int updBrand(Brand brand);
	
	Brand listBrandById(int id);
	
	List<Brand> listBrandAll();
}
