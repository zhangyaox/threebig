package com.zhangyaoxing.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangyaoxing.entity.Brand;
import com.zhangyaoxing.mapper.BrandMapper;
import com.zhangyaoxing.service.BrandService;
@Service(interfaceClass =BrandService.class)
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	BrandMapper brandMapper;
	
	@Override
	public PageInfo<Brand> listBrand(String name, int page) {
		Page<Object> startPage = PageHelper.startPage(page, 3);
		
		return new PageInfo<Brand>(brandMapper.listBrand(name));
	}

	@Override
	public int addBrand(Brand brand) {
		// TODO Auto-generated method stub
		return brandMapper.addBrand(brand);
	}

	@Override
	public int delBrand(int id) {
		// TODO Auto-generated method stub
		return brandMapper.delBrand(id);
	}

	@Override
	public int updBrand(Brand brand) {
		// TODO Auto-generated method stub
		return brandMapper.updBrand(brand);
	}

	@Override
	public Brand listBrandById(int id) {
		// TODO Auto-generated method stub
		return brandMapper.listBrandById(id);
	}

	@Override
	public List<Brand> listBrandAll() {
		// TODO Auto-generated method stub
		return brandMapper.listBrandAll();
	}

}
