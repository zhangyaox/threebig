<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@  taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<div class="container">
 		<div class="row">
 			<div class="col-md-3">
 				<label>名称</label>
 				<label>${find.title}</label>
 			</div>
 		</div>
 		<div class="row">
 			<div class="col-md-3">
 				<label>价格</label>
 				<label>${find.price}</label>
 			</div>
 		</div>
 		
 		<div class="row">
 			以下是规格
 		</div>
 		<c:forEach items="${find.specs}" var="spec"> 
 			<div class="row">
 			<div class="col-md-3">
 				<label>${spec.speccname}:</label>
 				<label>${spec.optionName}</label>
 			</div>
 			</div>
 		</c:forEach>
 		
 </div>