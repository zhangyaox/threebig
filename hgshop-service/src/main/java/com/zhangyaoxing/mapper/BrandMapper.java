package com.zhangyaoxing.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhangyaoxing.entity.Brand;

public interface BrandMapper {
	List<Brand> listBrand(@Param("name")String name);
	
	int addBrand(Brand brand);
	int delBrand(int id);
	int updBrand(Brand brand);
	
	Brand listBrandById(int id);
	
	List<Brand> listBrandAll();
}
