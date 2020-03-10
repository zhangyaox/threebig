package com.zhangyaoxing.service;

import java.util.List;


import com.github.pagehelper.PageInfo;
import com.zhangyaoxing.entity.Sku;
import com.zhangyaoxing.entity.SpecOption;

public interface SkuService {
	
	PageInfo<Sku> list(Sku sku,int page);
	
	Sku find(int id);
	
	int addSku(Sku sku);//添加sku
	
	int addSkuSpec(int skuid,SpecOption specopeion);//添加sku的属性值
	
	int updateSku(Sku sku);
	
	int delSku(int id);
	
	int deleteSkuBatch(int[] id);
}
