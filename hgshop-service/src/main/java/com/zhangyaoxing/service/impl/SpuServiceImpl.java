package com.zhangyaoxing.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangyaoxing.entity.Spu;
import com.zhangyaoxing.entity.SpuVo;
import com.zhangyaoxing.mapper.SpuMapper;
import com.zhangyaoxing.service.SpuService;
@Service(interfaceClass = SpuService.class)
public class SpuServiceImpl implements SpuService {
	
	@Autowired
	SpuMapper spuMapper;
	
	@Override
	public PageInfo<Spu> listSpu(int page, SpuVo spuvo) {
		PageHelper.startPage(page, 5);
		List<Spu> listSpu = spuMapper.listSpu(spuvo);
		return new PageInfo<Spu>(listSpu);
	}

	@Override
	public int addSpu(Spu spu) {
		// TODO Auto-generated method stub
		return spuMapper.addSpu(spu);
	}

	@Override
	public int delSpu(int id) {
		// TODO Auto-generated method stub
		return spuMapper.delSpu(id);
	}

	@Override
	public int delsSpu(String id) {
		// TODO Auto-generated method stub
		return spuMapper.delsSpu(id);
	}

	@Override
	public int updSpu(Spu spu) {
		// TODO Auto-generated method stub
		return spuMapper.updSpu(spu);
	}

	@Override
	public Spu selSpu(int id) {
		// TODO Auto-generated method stub
		return spuMapper.selSpu(id);
	}

}
