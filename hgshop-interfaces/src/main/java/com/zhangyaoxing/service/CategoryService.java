package com.zhangyaoxing.service;

import java.util.List;

import com.zhangyaoxing.entity.Category;

public interface CategoryService {
	List<Category> listCategory();
	int addCategory(Category brand);
	int updateCategory(Category brand);
	int deleteCategory(Integer id);
}
