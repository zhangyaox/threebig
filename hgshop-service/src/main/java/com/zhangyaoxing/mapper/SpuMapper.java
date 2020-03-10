package com.zhangyaoxing.mapper;

import java.util.List;

import com.zhangyaoxing.entity.Spu;
import com.zhangyaoxing.entity.SpuVo;

public interface SpuMapper {
	
	List<Spu> listSpu(SpuVo spuvo);
	
	int addSpu(Spu spu);
	int delSpu(int id);
	int delsSpu(String id);
	int updSpu(Spu spu);
	Spu selSpu(int id);
}
