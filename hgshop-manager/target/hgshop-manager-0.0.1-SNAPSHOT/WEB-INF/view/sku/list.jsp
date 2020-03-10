<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div>
	<table>
	  <tr>
	    <th>id</th>
	    <th>title</th>
	    <th>sell_point</th>
	    <th>price</th>
	    <th>stock_count</th>
	    <th>barcode</th>
	    <th>image</th>
	    <th>status</th>
	    <th>create_time</th>
	    <th>update_time</th>
	    <th>cost_price</th>
	  </tr>
	  <c:forEach items="${info.list }" var="list">
			<tr>
				<td>#{list }</td>
				<td></td>
			</tr>
		</c:forEach>
	</table>
</div>