package com.zhangyaoxing.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhangyaoxing.entity.Category;
import com.zhangyaoxing.mapper.CategoryMapper;
import com.zhangyaoxing.service.CategoryService;
@Service(interfaceClass =CategoryService.class)
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryMapper categoryMapper;
	
	@Override
	public List<Category> listCategory() {
		// TODO Auto-generated method stub
		return categoryMapper.listCategory();
	}

	@Override
	public int addCategory(Category brand) {
		// TODO Auto-generated method stub
		return categoryMapper.addCategory(brand);
	}

	@Override
	public int updateCategory(Category brand) {
		// TODO Auto-generated method stub
		return categoryMapper.updateCategory(brand);
	}

	@Override
	public int deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		return categoryMapper.deleteCategory(id);
	}

}
