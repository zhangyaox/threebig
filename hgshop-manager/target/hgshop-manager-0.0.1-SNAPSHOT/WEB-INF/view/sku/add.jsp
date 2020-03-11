<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<div>
	<form id="addform">
	
		<div class="form-row">
			<div class="col">
				<label>商品名称</label>
				<input type="hidden" name="spu_id" value="${spu.id}">
		        <input type="text" disabled="disabled" value="${spu.goods_name}" name="goods_name" class="form-control" placeholder="商品名称">
			</div>
		</div>
		
		<div class="form-row">
		    <div class="col">
		       <label>标题</label>	
		        <input type="text" name="title" class="form-control" placeholder="标题">
		    </div>
		  </div>
		  
		  <div class="form-row">
		    <div class="col">
		       <label>卖点</label>	
		        <input type="text" name="sell_point" class="form-control" placeholder="卖点">
		    </div>
		  </div>
		  
		  <div class="form-row">
		    <div class="col">
		       <label>价格</label>	
		        <input type="text" name="price" class="form-control" placeholder="价格">
		    </div>
		  </div>
		  
		   <div id="oneSpec"> 
		    <div class="form-row">
			    <div class="col">
			       <label>属性</label>
			       <select  name="specids" class="form-control form-control-lg"
			       onchange="specchange($(this))">
					 	<c:forEach items="${listSpec}" var="spec" >
					 		<option value="${spec.id}" >${spec.spec_name}</option>
					 	</c:forEach>
					</select>
			    </div>
			    <div class="col">
			       <label>属性选项（数值）</label>	
			       <select  name="specOptionIds" class="form-control form-control-lg">
					 	
					</select>
			    </div>
			    <div class="col">
			     <label></label>
			    	<button type="button" class="btn btn-danger" onclick="del($(this))">删除</button>
			    </div>
			  </div>
			  
			  </div>
		  <div id="speclList">
			  
		  </div>
		
		 <div>
		  	 <button type="button" class="btn btn-danger" onclick="addspec()">增加属性</button>
		  </div>
		
		<div class="form-row">
		    <div class="col">
				<button type="button" class="btn btn-primary"  onclick="add()">添加 </button>
   			</div>
   		</div>
	</form>
</div>
<script>
		//属性选项（数值） 前一个点击 改变 下一个追加
		function specchange(specSel) {
			// 获取一个属性的所有的属性数值
			$.post("/spec/openupdate",{id:specSel.val()},function(specData){
				// 属性值的下拉框
				var specOption = specSel.parent().next().children().filter("select").first();
				specOption.empty()
				for (var i = 0; i < specData.options.length; i++) {
					//obj.parent().next().children().filter("input").first().val(obj.val()+"aaa");
					specOption.append("<option value='"+specData.options[i].id+"' >" +specData.options[i].optionName +"</option>")
					
					//console.log(specData.options[i].id)
				} ;
				
			});
		}
		
		//添加下拉框
		function addspec(){
			$("#speclList").append($("#oneSpec").html())
		}
		
		function add(){
			var formData = new FormData($("#addform")[0])
			//提交数据
			$.ajax({url:"/sku/addsku",
				  //dataType:"json",
				  data:formData,
				  // 让jQuery 不要再提交数据之前进行处理
				  processData : false,
				  // 提交的数据不能加消息头
				  contentType : false,
				  // 提交的方式 
				  type:"post",
				  // 成功后的回调函数
				  success:function(data){
					  if(data){
							 alert("数据提交成功");
							 //刷新
							$("#main").load("/sku/list");
						 }else{
							 alert("数据保存失败");
						 }  
					 
				  }
				  })
		}
		
		function del(thi){
			thi.parent().parent().remove();
		}
</script>