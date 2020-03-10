package com.zhangyaoxing.mapper;

import java.util.List;

import com.zhangyaoxing.entity.Category;

public interface CategoryMapper {
	
	List<Category> listCategory();
	int addCategory(Category brand);
	int updateCategory(Category brand);
	int deleteCategory(Integer id);
	
	Category findCategory(int id);
}
