<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<input id="queryName" value="${queryName}">
	<button type="button" class="btn btn-primary" onclick="find()">
		查询
	</button>
	
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#staticBackdrop">
		添加
	</button>
<!--添加begin  -->
	<div class="modal fade" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">添加品牌</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        		<form action="" id="addbrand">
						<div class="form-group">
							<label for="spec_name">品牌名称</label> <input
								type="text" class="form-control" id="spec_name" name="name"
								aria-describedby="spec_nameHelp"> <small id="emailHelp"
								class="form-text text-muted">请输入规格名称</small>
						</div>
						<div class="form-group form-group-proper">
							<label for="inputAddress">英文</label> <input type="text" name="first_char"
								class="form-control" id="inputAddress"
								placeholder="英文">
						</div>
						<div class="form-group form-group-proper">
							<label for="inputAddress">数字</label> <input type="text" name="deleted_flag"
								class="form-control" id="inputAddress"
								placeholder="数字">
						</div>
					</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="commitbrand()">提交</button>
      </div>
    </div>
  </div>
</div>
	<!--添加end  -->
	
	<!-- 修改模态框begin -->
<div class="modal fade" id="staticBackdropupdate" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">修改品牌</h5>
        <button type="button" onclick="addprop('#updatespec')">添加品牌</button><!-- 传递form 的id下去 -->
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        		<form action="" id="updatespec">
        				<input type="hidden" name="id" id="updateid"><!-- id -->
						<div class="form-group">
							<label for="spec_name">品牌名称</label> <input
								type="text" class="form-control" id="updatname" name="name"
								aria-describedby="spec_nameHelp"> <small id="emailHelp"
								class="form-text text-muted">请输入品牌名称</small>
						</div>
						<div class="form-group form-group-proper">
							<label for="inputAddress">英文</label> <input type="text" name="first_char"
								class="form-control" id="first_char"
								placeholder="1234 Main St">
						</div>
						<div class="form-group form-group-proper">
							<label for="inputAddress">数字</label> <input type="text" name="deleted_flag"
								class="form-control" id="deleted_flag"
								placeholder="1234 Main St">
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
    <th>id</th>
    <th>名称</th>
    <th>英文</th>
    <th>数字</th>
  </tr>
  <c:forEach items="${info.list}" var="list">
  	<tr>
    <td>${list.id}</td>
    <td>${list.name}</td>
    <td>${list.first_char}</td>
    <td>${list.deleted_flag}</td>
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
<script type="text/javascript">
		function find(){//查找
			var url="/brand/list?name="+$("#queryName").val();
			$("#main").load(url);
		}

		function goPage(page){//分页
			var url="/brand/list?name="+$("#queryName").val()+'&page='+page;
			$("#main").load(url);
		}
		
		function commitbrand(){//添加
			$.post("/brand/add",
			$("#addbrand").serialize(),
			function(data){
				if(data){
					alert("成功");
					 $('#staticBackdrop').modal('hide');
				}else{
					alert("失败");
				} 
			})
		}
		
		//模态框关闭后 调用  添加的刷新
		$("#staticBackdrop").on('hidden.bs.modal',function(e){
			refresh();
		})
		//模态框关闭后 调用  修改的刷新
		$("#staticBackdropupdate").on('hidden.bs.modal',function(e){
			refresh();
		})
		
		/**
		* 刷新 而且保持查询条件和页码=====
		*/
		function refresh(){
			var url="/brand/list?name=${queryName}"+'&page=${info.pageNum}';
			$("#main").load(url);
		}
		
		function openUpdate(id){//修改的查找单行
			$.post("/brand/upda",
					{id:id},
					function(data){
						$("#updateid").val(data.id);
						$("#updatname").val(data.name);
						$("#first_char").val(data.first_char);
						$("#deleted_flag").val(data.deleted_flag);
						
					},"json");
			$("#staticBackdropupdate").modal('show');//弹出模态框
		}
		
		function commitspecupdate(){//修改
			$.post("/brand/upd",
				$("#updatespec").serialize(),
				function(data){
					if(data){
						alert("成功");
						 $('#staticBackdropupdate').modal('hide');
					}else{
						alert("失败");
					} 
				})
			}
		
		function delsec(id){//删除-------------------------------------------
			if(confirm("确定删除数据")){
				$.post("/brand/delspec",
						{id:id},
						function(data){
							if(data){
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
</script>