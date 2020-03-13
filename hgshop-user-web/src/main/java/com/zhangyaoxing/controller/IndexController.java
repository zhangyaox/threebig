package com.zhangyaoxing.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zhangyaoxing.comm.HgShopConstant;
import com.zhangyaoxing.entity.Category;
import com.zhangyaoxing.entity.Sku;
import com.zhangyaoxing.entity.Spu;
import com.zhangyaoxing.entity.SpuEsVo;
import com.zhangyaoxing.entity.SpuVo;
import com.zhangyaoxing.service.CategoryService;
import com.zhangyaoxing.service.SkuService;
import com.zhangyaoxing.service.SpuService;
import com.zhangyaoxing.util.ElSearchUtil;

@Controller
public class IndexController {
	
	@Autowired
	RedisTemplate<String, PageInfo<Spu>> redisTemplate;
	@Reference
	SpuService SpuService;
	@Reference
	SkuService SkuService;
	@Reference
	CategoryService categoryService;
	// 搜索引擎
	@Autowired 
	ElSearchUtil<SpuEsVo> elUtils;
	
	@RequestMapping({"index","/"})
	public String index(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "0") int catid,Model m) {//进入首页
		//加一个redis
		if(page==1 && catid==0) {
			ValueOperations<String, PageInfo<Spu>> opsForValue = redisTemplate.opsForValue();
			//有缓存
			if(redisTemplate.hasKey(HgShopConstant.SPU_CACHE_KEY)) {
				PageInfo<Spu> pageInfo = opsForValue.get(HgShopConstant.SPU_CACHE_KEY);
				m.addAttribute("info", pageInfo);
				return "index";
			}else {
				// 从服务中获取数据
				PageInfo<Spu> listSpu = SpuService.listSpu(page, new SpuVo());
				// 数据放入缓存当中
				//缓存30分钟
				opsForValue.set(HgShopConstant.SPU_CACHE_KEY, listSpu,30,TimeUnit.MINUTES);
				m.addAttribute("info", listSpu);
				return "index";
			}
		}
		
		PageInfo<Spu> listSpu = SpuService.listSpu(page, new SpuVo());
		m.addAttribute("info", listSpu);
		return "index";
	}
	
	@RequestMapping("detail")//显示商品详情
	public String toindex(int spuid,Model m) {//进入首页  int spuid
		Spu selSpu = SpuService.selSpu(spuid);
		//根据spu 的id 获取使有sku
		List<Sku> bySpuid = SkuService.getBySpuid(spuid);
		m.addAttribute("spu", selSpu);
		m.addAttribute("bySpuid", bySpuid);
		return "detail";
	}
	
	@RequestMapping("search")
	public String search(Model m,
			String key,@RequestParam(defaultValue="1") int page) {
		
		AggregatedPage<SpuEsVo> queryObjects = elUtils.queryObjects(SpuEsVo.class, page, 10, new String[]{"goodsname","caption","brandname","categoryname"},key );
		//aggregatedPage.getContent();
		m.addAttribute("pageInfo", queryObjects);
		return "search";
		
	}
	
	@RequestMapping("treeData")
	@ResponseBody
	public List<Category> treeData() {
		
		return categoryService.listCategory();
	}
}
