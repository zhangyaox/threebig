package com.zhangyaoxing.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhangyaoxing.entity.Sku;
import com.zhangyaoxing.entity.SpecOption;

public interface SkuMapper {
	
	List<Sku> list(Sku sku);
	
	Sku find(int id);
	
	int addSku(Sku sku);//添加sku
	
	int addSkuSpec(@Param("skuid")int skuid,@Param("specopeion")SpecOption specopeion);//添加sku的属性值
	
	int updateSku(Sku sku);
	
	int delSku(int id);
	
	//根据spu 的id 获取使有sku
	
		List<Sku> getBySpuid(int id);
}
