package com.zhangyaoxing.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangyaoxing.entity.Spu;
import com.zhangyaoxing.entity.SpuEsVo;
import com.zhangyaoxing.entity.SpuVo;
import com.zhangyaoxing.mapper.SpuMapper;
import com.zhangyaoxing.service.SpuService;
import com.zhangyaoxing.util.ElSearchUtil;
@Service(interfaceClass = SpuService.class)
public class SpuServiceImpl implements SpuService {
	
	@Autowired
	SpuMapper spuMapper;
	@Autowired
	ElSearchUtil<SpuEsVo> elSearchUtils;
	@Autowired
	KafkaTemplate<String, String> kafakTemplate;
	
	@Override
	public PageInfo<Spu> listSpu(int page, SpuVo spuvo) {
		PageHelper.startPage(page, 5);
		List<Spu> listSpu = spuMapper.listSpu(spuvo);
		return new PageInfo<Spu>(listSpu);
	}

	@Override
	public int addSpu(Spu spu) {
		
		int addSpu = spuMapper.addSpu(spu);
		// 将该数据收集到搜搜引擎当中
				Spu newSpu = spuMapper.selSpu(spu.getId());
				SpuEsVo spuEsVo = new SpuEsVo(newSpu);
				System.out.println(" >>>>>>>>>>> spuEsVo is " + spuEsVo);
				elSearchUtils.saveObject(spu.getId().toString(), spuEsVo);
				
				// 使用kafak 去发送消息  把商品id 发送到主题MyAddSpu 上。
				kafakTemplate.send("MyAddSpu", "addspu",spu.getId().toString() );
		
		return addSpu;
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
