package com.zhangyaoxing.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangyaoxing.entity.Sku;
import com.zhangyaoxing.entity.SpecOption;
import com.zhangyaoxing.mapper.SkuMapper;
import com.zhangyaoxing.service.SkuService;
@Service
public class SkuServiceImpl implements SkuService {
	
	@Autowired
	SkuMapper skuMapper;
	
	@Override
	public PageInfo<Sku> list(Sku sku, int page) {
		Page<Object> startPage = PageHelper.startPage(page, 5);
		List<Sku> list = skuMapper.list(sku);
		return new PageInfo<Sku>(list);
	}

	@Override
	public Sku find(int id) {
		// TODO Auto-generated method stub
		return skuMapper.find(id);
	}

	@Override
	public int addSku(Sku sku) {
		//添加主表
		int addSku = skuMapper.addSku(sku);
		System.err.println("================="+sku+addSku);
		//
		List<SpecOption> specs = sku.getSpecs();
		for (SpecOption specOption : specs) {
			addSku+=skuMapper.addSkuSpec(sku.getId(), specOption);
		}
		return addSku;
	}

	
	@Override
	public int updateSku(Sku sku) {
		// TODO Auto-generated method stub
		return skuMapper.updateSku(sku);
	}

	@Override
	public int delSku(int id) {
		// TODO Auto-generated method stub
		return skuMapper.delSku(id);
	}

	@Override
	public int addSkuSpec(int skuid, SpecOption specopeion) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSkuBatch(int[] id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
