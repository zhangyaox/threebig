<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/resource/js/jquery-3.2.1.js"></script>    

<link href="/resource/css/bootstrap.css" rel="stylesheet" >    
<link href="/resource/bootstrap-treeview/css/bootstrap-treeview.css" rel="stylesheet" >    
<script src="/resource/bootstrap-treeview/js/bootstrap-treeview.js"></script>   

<div>
	<form id="fom">
		<div class="form-row">
		    <div class="col">
		       <label>商品名称</label>	
		        <input type="text" name="goods_name" class="form-control" placeholder="商品名称">
		    </div>
		  </div>
		  
		  <div class="form-row">
		    <div class="col">
		       <label>标题</label>	
		        <input type="text" name="caption" class="form-control" placeholder="标题">
		    </div>
		  </div>
		  
		  <div class="form-row">
		    <div class="col">
		       <label>分类</label>
		       <input type="hidden" name="category_id" id="category_id">	
		        <input type="text" name="categoryName" id="category"
		          onclick="showTree()"
		         class="form-control" placeholder="分类">
		    </div>
		    <div id="cattree"
				style="display: none; position: absolute; z-index: 1010; background-color: white; width: 96%">
				</div>
		  </div>
		  
		  <div class="form-row">
		    <div class="col">
		       <label>品牌</label>	
		       <select class="form-control form-control-lg" name="brand_id">
				  <c:forEach items="${listBrandAll}" var="list">
				  		<option value="${list.id}">${list.name}</option>
				  </c:forEach>
				</select>
		    </div>
		  </div>
		   
		    <div class="form-row">
		    <div class="col">
		       <label>小图</label>	
		      <input type="file" name="file" class="form-control-file" id="exampleFormControlFile1">
		    </div>
		  </div>
  		
  		<button type="button" class="btn btn-success" onclick="add()">添加</button>
	</form>
</div>
<script type="text/javascript">
function initTree() {
	//发送ajax获取树需要的数据
	$.post("/cat/treedata", {},
			function(treeData) {
				//初始化添加的时候分类的树
				$("#cattree").treeview({
					data : treeData,
					levels : 2,
					onNodeSelected : function(event, node) {
						$("#category").val(node.text);//点击回显值
						$("#category_id").val(node.id);//id
						$("#cattree").hide();	//回显完成关闭
					}
				});

			}, "json");
}
initTree();

function showTree(){//树起来树
	$('#cattree').show();
}

		function add(){
			// 获取表单数据
			var formData = new FormData($("#fom")[0]);
			$.ajax({url:"/spu/ad",
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
						 }else{
							 alert("数据保存失败");
						 }  
					 
				  }
				  })
		}
</script>