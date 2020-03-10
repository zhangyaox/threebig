package com.zhangyaoxing.service;

import com.github.pagehelper.PageInfo;
import com.zhangyaoxing.entity.Spu;
import com.zhangyaoxing.entity.SpuVo;

public interface SpuService {
 
	PageInfo<Spu> listSpu(int page,SpuVo spuvo);
	
	int addSpu(Spu spu);
	int delSpu(int id);
	int delsSpu(String id);
	int updSpu(Spu spu);
	Spu selSpu(int id);
}
