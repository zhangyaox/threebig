package com.zhangyaoxing.service;

import com.github.pagehelper.PageInfo;
import com.zhangyaoxing.entity.Brand;
import com.zhangyaoxing.entity.Category;

public interface GoodsService {
	int addBrand(Brand brand);
	int updateBrand(Brand brand);
	int deleteBrand(Integer id);
	PageInfo<Brand> listBrand(String name, int page);
	
	int addCategory(Category brand);
	int updateCategory(Category brand);
	int deleteCategory(Integer id);
}
