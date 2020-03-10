package com.zhangyaoxing.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.zhangyaoxing.entity.Brand;
import com.zhangyaoxing.entity.Spu;
import com.zhangyaoxing.entity.SpuVo;
import com.zhangyaoxing.service.BrandService;
import com.zhangyaoxing.service.SpuService;

@Controller
@RequestMapping("spu")
public class SpuController {
	
	@Reference
	SpuService spuService;
	
	@Reference
	BrandService brandService;
	
	@RequestMapping("list")
	public String list(@RequestParam(defaultValue = "1") int page,SpuVo spuvo,Model m) {
		PageInfo<Spu> listSpu = spuService.listSpu(page, spuvo);
		m.addAttribute("info", listSpu);
		return "spu/list";
	}
	
	@RequestMapping("add")
	public String add(Model m) {
		//获取品牌
		List<Brand> listBrandAll = brandService.listBrandAll();
		m.addAttribute("listBrandAll", listBrandAll);
		return "spu/add";
	}
	
	@ResponseBody
	@RequestMapping("ad")
	public int ad(Spu spu,@RequestParam(value="file") MultipartFile file ) throws IllegalStateException, IOException {
		String path="d:/pic/";//把文件放到d盘
		int addSpu = 0;
		if(!file.isEmpty()) {//file  要和我 网页的 name中的一样
			
			//获取原始的文件名称
			String filename=file.getOriginalFilename();
			
			//防止文件重名
			String newfileName=UUID.randomUUID()+filename.substring(filename.lastIndexOf("."));//路径
			file.transferTo(new File(path,newfileName));//拷贝
			//上面是把我传过来的 图片存入到了  d盘
			spu.setSmall_pic(newfileName);
			 addSpu = spuService.addSpu(spu);
		}
		//int addSpu = spuService.addSpu(spu);
		return addSpu;
	}
	
	@RequestMapping("down")
	public void downLoad(HttpServletResponse response, String filename) throws FileNotFoundException {
		 /* // 下载本地文件
	    String fileName = "Operator.doc".toString(); // 文件的默认保存名
*/	    // 读到流中
	    InputStream inStream = new FileInputStream("d:\\pic\\"+filename);// 文件的存放路径
	    // 设置输出的格式
	    response.reset();
	    response.setContentType("bin");
	    response.addHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
	   
	    // 循环取出流中的数据
	    byte[] b = new byte[1024];
	    int len;
	    try {
	      while ((len = inStream.read(b)) > 0)
	        response.getOutputStream().write(b, 0, len);
	      inStream.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	
	}
}
