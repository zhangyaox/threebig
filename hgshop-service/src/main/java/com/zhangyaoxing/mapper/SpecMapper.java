package com.zhangyaoxing.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhangyaoxing.entity.Spec;
import com.zhangyaoxing.entity.SpecOption;

public interface SpecMapper {
	
	List<Spec> list(@Param("name")String name);
	
	int add(Spec spec);
	
	int update(Spec spec);
	
	int delete(int id);
	
	//查找一个规格
	Spec findByid(int id);
	
	//批量删除
	int deletebatch();

	Spec get(int id);

	int addOption(SpecOption specOption);

	int deleteSpecotion(int id);

	int deleteSpec(int id);
	
	List<SpecOption> selectOptions(@Param("value")Integer value);
}
