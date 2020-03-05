<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<input id="queryName" value="${queryName}">
	<button type="button" class="btn btn-primary" onclick="find()">
		查询
</button>
	<button type="button" class="btn btn-primary" onclick="delBatch()">
   	批量删除</button>
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#staticBackdrop">
		添加
</button>
<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">添加规格</h5>
        <button type="button" onclick="addprop('#addspec')">添加属性</button>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        		<form action="" id="addspec">
						<div class="form-group">
							<label for="spec_name">规格名称</label> <input
								type="text" class="form-control" id="spec_name" name="spec_name"
								aria-describedby="spec_nameHelp"> <small id="emailHelp"
								class="form-text text-muted">请输入规格名称</small>
						</div>
						<div class="form-group form-group-proper">
							<label for="inputAddress">属性</label> <input type="text" name="options[0].optionName"
								class="form-control" id="inputAddress"
								placeholder="1234 Main St">
								<button onclick="$(this).parent().remove()">删除</button>
						</div>
					</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="commitspec()">提交</button>
      </div>
    </div>
  </div>
</div>
<!-- 修改模态框begin -->
<div class="modal fade" id="staticBackdropupdate" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">修改规格</h5>
        <button type="button" onclick="addprop('#updatespec')">添加属性</button><!-- 传递form 的id下去 -->
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        		<form action="" id="updatespec">
        				<input type="hidden" name="id" id="updateid">
						<div class="form-group">
							<label for="spec_name">规格名称</label> <input
								type="text" class="form-control" id="updatname" name="spec_name"
								aria-describedby="spec_nameHelp"> <small id="emailHelp"
								class="form-text text-muted">请输入规格名称</small>
						</div>
						<div class="form-group form-group-proper">
							<label for="inputAddress">属性</label> <input type="text" name="options[0].optionName"
								class="form-control" id="inputAddress"
								placeholder="1234 Main St">
								<button onclick="$(this).parent().remove()">删除</button>
						</div>
					</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="commitspecupdate()">提交</button>
      </div>
    </div>
  </div>
</div>
<!-- 修改模态框end -->
</div>

<table class="table">
  <tr>
  	<th>
  		<button type="button" class="btn btn-primary btn-sm" onclick="selall(1)">全选</button>
		<button type="button" class="btn btn-secondary btn-sm" onclick="selall(2)">全不选</button>
		<button type="button" class="btn btn-success btn-sm" onclick="selall(3)">反选</button>
  	</th>
    <th>id</th>
    <th>名称</th>
    <th>详情</th>
  </tr>
  <c:forEach items="${info.list}" var="list">
  	<tr>
    <td><input type="checkbox" name="ids" value="${list.id}">${list.id}</td>
    <td>${list.spec_name}</td>
    <td>
    	<c:forEach items="${list.options}" var="li">
    		&nbsp;&nbsp;${li.optionName }
    	</c:forEach>
    </td>
    <td>
    	<button type="button" class="btn btn-danger" onclick="delsec(${list.id})">删除</button>
		<button type="button" class="btn btn-warning" onclick="openUpdate(${list.id})">修改</button>
	</td>
  </tr>
  </c:forEach>
  <tr>
  	<td>
  		<jsp:include page="../common/page.jsp"></jsp:include><!-- 分页 -->
	</td>
  </tr>
</table>

<input type="button" value="dd" onclick="refresh()">

<script type="text/javascript">
	var addindex=1;
	// fimd 是 id   $(fimd).append('     fimd是对id相对应的模态框追加内容的
	function addprop(fimd){
		$(fimd).append('<div class="form-group form-group-proper">'+
		'<label for="inputAddress">属性</label>'+ 
		'<input type="text" name="options['+addindex+'].optionName" class="form-control" id="inputAddress" placeholder="1234 Main St">'+
		'<button onclick="$(this).parent().remove()">删除</button>'+
	'</div>') 
	addindex++;
	}
	function commitspec(){//添加
		var formData = new FormData($("#addspec")[0]);
		$.ajax({url:"/spec/add",
			 // dataType:"json",
			  data:formData,
			  // 让jQuery 不要再提交数据之前进行处理
			  processData : false,
			  // 提交的数据不能加消息头
			  contentType : false,
			  // 提交的方式 
			  type:"post",
			  // 成功后的回调函数
			  success:function(data){
				 if(data=="success"){
					 alert("数据提交成功");
					 $('#staticBackdrop').modal('hide')
				 }else{
					 alert("数据保存失败")
				 }
				 
			  }
			  })
	}
	function find(){//查找
		var url="/spec/list?name="+$("#queryName").val();
		$("#main").load(url);
	}
	function goPage(page){//分页
		var url="/spec/list?name="+$("#queryName").val()+'&page='+page;
		$("#main").load(url);
	}
	
	function res(){//复位
		$(".form-group-proper").each(function(){
			$(this).remove();
		})
		addindex=1;
	$("#spec_name").val("");
	}
	// 给模态框增加显示成成功后的事件   模态框显示成功就运行它里面的事件
	$("#staticBackdrop").on('shown.bs.modal',function(e){
		res();
	})
	
	/**
	* 刷新 而且保持查询条件和页码=====
	*/
	function refresh(){
		
		var url="/spec/list?name=${queryName}"+'&page=${info.pageNum}';
		$("#main").load(url);
	}
	
	//模态框关闭后 调用
	$("#staticBackdrop").on('hidden.bs.modal',function(e){
		refresh();
	})
	
	function delsec(id){//删除-------------------------------------------
		if(confirm("确定删除数据")){
			$.post("/spec/delspec",
					{id:id},
					function(data){
						if(data=="success"){
							alert("成功");
							refresh();
						}else{
							alert("失败")
						}
					})
		}else{
			return;
		}
	}
	function delBatch(){//批量删除----------------------------------------------
		
		if($("[name=ids]:checked").length<=0){
			alert("没有数据被选中，不能删除")
			return;
		}
		
		var id=$("[name=ids]:checked").map(function(){
			return this.value;
		}).get().join();
		if(confirm("确定删除数据")){
			$.post("/spec/delspecbathch",
					{id:id},
					function(data){
						if(data=="success"){
							alert("成功");
							refresh();
						}else{
							alert("失败")
						}
					})
		}else{
			return;
		}
	}
	
	function selall(flag){
		if(flag==1){
			//全选
			$("[name=ids]").each(function(){
				$(this).attr("checked",true);
			})
		}
		if(flag==2){
			//全不选
			$("[name=ids]").each(function(){
				$(this).attr("checked",false);
			})
		}
		if(flag==3){
			$("[name=ids]").map(function(){
				this.checked=!this.checked;
			})
		}
		var allselected=$("[name=ids]").length==$("[name=ids]:checked");
	}
	
	function openUpdate(id){//修改的查找单行
		
		//清空数据
		$(".form-group-proper").each(function(){
			$(this).remove();
		})
		addindex=0;
		$("#updatname").val("");
		
		$.post("/spec/openupdate",
				{id:id},
				function(data){
					$("#updateid").val(data.id);
					$("#updatname").val(data.spec_name);
					for ( var i in data.options) {
						$("#updatespec").append('<div class="form-group form-group-proper">'+
								'<label for="inputAddress">属性</label>'+ 
								'<input type="hidden" name="options['+addindex+'].id" value="'+data.options[i].id+'" id="updateid">'+
								'<input type="text" name="options['+addindex+'].optionName" value="'+data.options[i].optionName+'" class="form-control" id="inputAddress" placeholder="1234 Main St">'+
								'<button onclick="$(this).parent().remove()">删除</button>'+
							'</div>') 
							addindex++;
					}
					
				},"json");
	
		$("#staticBackdropupdate").modal('show');//弹出模态框
	}
	
	function commitspecupdate(){
		var formData = new FormData($("#updatespec")[0]);
		$.ajax({url:"/spec/update",
			 // dataType:"json",
			  data:formData,
			  // 让jQuery 不要再提交数据之前进行处理
			  processData : false,
			  // 提交的数据不能加消息头
			  contentType : false,
			  // 提交的方式 
			  type:"post",
			  // 成功后的回调函数
			  success:function(data){
				 if(data=="success"){
					 alert("数据修改成功");
					 $('#staticBackdropupdate').modal('hide')
					 refresh();
				 }else{
					 alert("数据保存失败")
				 }
				 
			  }
			  })
	}
</script>