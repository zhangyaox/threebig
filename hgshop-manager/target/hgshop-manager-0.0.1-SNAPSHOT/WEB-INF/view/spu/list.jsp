<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<button type="button" class="btn btn-success" onclick="add()">添加</button>

<table class="table">
  <tr>
    <th>id</th>
    <th>goods_name</th>
    <th>is_marketable</th>
    <th>caption</th>
    <th>small_pic</th>
    <th>brand</th>
    <th>category</th>
  </tr>
  <c:forEach items="${info.list}" var="list">
		<tr>
			<td>${list.id}</td>
			<td>${list.goods_name}</td>
			<td>${list.is_marketable==1?"在卖":"no在卖"}</td>
			<td>${list.caption}</td>
			<td><img width="100px" height="100px" src="/pic/${list.small_pic}"></td>
			<td>${list.brand.name}</td>
			<td>${list.category.name}</td>
			<td>
				<button type="button" class="btn btn-success">详情</button>
				<button type="button" class="btn btn-danger">删除</button>
				<button type="button" class="btn btn-warning">修改</button>
				<button type="button" class="btn btn-warning" onclick="addsku()">添加sku</button>
				<a target="_blank" href="/spu/down?filename=${list.small_pic}">下载图片</a>
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
	function add(){
		$("#main").load("/spu/add");
	}
	function goPage(page){//分页
		var url="/spu/list?page="+page;
		$("#main").load(url);
	}
	function addsku(){
		
	}
</script>