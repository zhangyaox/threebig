<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#staticBackdrop">
		添加
</button>
<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">添加规格</h5>
        <button type="button" onclick="addprop()">添加属性</button>
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
						<div class="form-group">
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
</div>

<table class="table">${info }
  <tr>
    <th>id</th>
    <th>名称</th>
    <th>详情</th>
  </tr>
  <c:forEach items="${info.list}" var="list">
  	<tr>
    <td>${list.id}</td>
    <td>${list.spec_name}</td>
    <td>
    	<c:forEach items="${list.options}" var="li">
    		&nbsp;&nbsp;${li.optionName }
    	</c:forEach>
    </td>
  </tr>
  </c:forEach>
</table>
<script type="text/javascript">
	var addindex=1;
	function addprop(){
		$("#addspec").append('<div class="form-group">'+
		'<label for="inputAddress">属性</label>'+ 
		'<input type="text" name="options['+addindex+'].optionName" class="form-control" id="inputAddress" placeholder="1234 Main St">'+
		'<button onclick="$(this).parent().remove()">删除</button>'+
	'</div>') 
	addindex++;
	}
	function commitspec(){
		var formData = new FormData($("#addspec")[0]);
		$.ajax({url:"/spec/add",
			  dataType:"json",
			  data:formData,
			  // 让jQuery 不要再提交数据之前进行处理
			  processData : false,
			  // 提交的数据不能加消息头
			  contentType : false,
			  // 提交的方式 
			  type:"post",
			  // 成功后的回调函数
			  success:function(data){
				 alert(data)  
				 
			  }
			  })
	}
</script>