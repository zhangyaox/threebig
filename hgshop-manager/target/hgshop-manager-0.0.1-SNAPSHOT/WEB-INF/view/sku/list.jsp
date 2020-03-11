<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@  taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<div>
	<table class="container-fluid">
	  <tr>
	    	<th>id</th>
	  		<th>标题</th>
	  		<th>价格</th>
	  		<th>库存</th>
	  		<th>发布时间</th>
	  		<th>品牌</th>
	  		<th>分类</th>
	  		<th>操作</th>
	  </tr>
	  <c:forEach items="${info.list }" var="list">
			<tr>
	  			<td>${list.id}</td>
	  			<td>${list.title}</td>
	  			<td>${list.price}</td>
	  			<td>${list.stock_count}</td>
	  			<td>
	  				<fmt:formatDate  value="${list.create_time}" pattern="yyyy-MM-dd"/> 
	  			
	  			</td>
	  			
	  			<td>${list.spu.brand.name}</td>
	  			<td>${list.spu.category.name}</td>
	  			<td>
		  			<button type="button" class="btn btn-success" onclick="xq(${list.id})">详情</button>
					<button type="button" class="btn btn-danger">删除</button>
					<button type="button" class="btn btn-warning">修改</button>
	  			</td>
	  		</tr>
		</c:forEach>
		<tr>
  	<td>
  		<jsp:include page="../common/page.jsp"></jsp:include><!-- 分页 -->
	</td>
  </tr>
	</table>
</div>
<script type="text/javascript">
	function xq(id){
		$("#main").load("/sku/xq?id="+id)
	}
	
	function goPage(page){//分页
		var url="/sku/list?page="+page;
		$("#main").load(url);
	}
</script>