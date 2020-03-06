<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/resource/js/jquery-3.2.1.js"></script>    


<link href="/resource/css/bootstrap.css" rel="stylesheet" >    
<link href="/resource/bootstrap-treeview/css/bootstrap-treeview.css" rel="stylesheet" >    
<script src="/resource/bootstrap-treeview/js/bootstrap-treeview.js"></script>   
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-6" id="cattree">
			
		</div>
		<div class="col-sm-6" id="edit">
			<!-- 用于添加的  开始  -->
			<form   action="">
				<div class="form-group">
    				<label for="">上一级别的id</label>
    				<input type="text" class="form-control" id="parentId" placeholder="节点名称">
  				</div>
  				<div class="form-group">
    				<label for="">上一级别的名称</label>
    				<input type="text" class="form-control" id="parentName" placeholder="节点名称">
  				</div>
  				<div class="form-group">
    				<label for="">名称</label>
    				<input type="text" class="form-control" id="name" placeholder="节点名称">
  				</div>
  				<button type="button" class="btn btn-primary" onclick="add()">添加</button>
			</form>
			<!-- 结束    用于添加 -->
			
			<!-- 开始    用于修改 and 删除-->
			<form   action="">
				<input id="currentChildLenth" value="0" type="hidden">
				<div class="form-group">
    				<label for="">当前的id</label>
    				<input type="text" class="form-control" id="currentId" placeholder="节点名称">
  				</div>
  				<div class="form-group">
    				<label for="">当前名称</label>
    				<input type="text" class="form-control" id="currentName" placeholder="节点名称">
  				</div>
  				<button type="button" class="btn btn-danger" onclick="del()">删除</button>
  				<button type="button" class="btn btn-primary" onclick="update()">修改</button>
			</form>
			<!-- 结束    用于修改 and 删除-->
		</div>
	</div>
</div>
<script>
function initTree() {
	//发送ajax获取树需要的数据
	$.post("/cat/treedata", {},
			function(treeData) {
				//初始化添加的时候分类的树
				$("#cattree").treeview({
					data : treeData,
					levels : 2,
					onNodeSelected : function(event, node) {
						
						//添加 复值
							$("#parentId").val(node.id);
							$("#parentName").val(node.text);
							$("#name").val("");//添加end
						
							// 给预备修改的地方赋值
							$("#currentId").val(node.id);
							$("#currentName").val(node.text);
							//删除的    按长度来判断是否是末一个
							$("#currentChildLenth").val(node.nodes.length)
					}
				});

			}, "json");
}
initTree();

//更新
function refresh(){
	$("#main").load("/cat/list");
}

function add(){
	$.post("/cat/add",
			{id:$("#parentId").val(),name:$("#name").val()},
			function(data){
					if(data=="success"){
						alert("添加成功");
						refresh();
					}else{
						alert("添加失败")
					}
			})
}
function del(){
	if($("#currentChildLenth").val()>0){
		alert("不可以删除，该节点还有子节点");
		return;
	}else{
		$.post("/cat/del",
				{id:$("#currentId").val()},
				function(data){
						if(data=="success"){
							alert("删除成功");
							refresh();
						}else{
							alert("删除失败")
						}
				})
	}
}
function update(){
	$.post("/cat/upd",
			{id:$("#currentId").val(),name:$("#currentName").val()},
			function(data){
					if(data=="success"){
						alert("修改成功");
						refresh();
					}else{
						alert("修改失败")
					}
			})
}
</script>