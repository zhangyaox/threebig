<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-end">
    <li class='page-item <c:if test="${info.pageNum==1}">disabled</c:if>'>
      <a class="page-link" href="javascript:goPage(1)" tabindex="-1"  <c:if test="${info.pageNum==1}">aria-disabled="true"</c:if> >首页</a>
    </li>
    
    <c:forEach begin="1" end="${info.pages}" var="currentPage">
    	<li class="page-item"><a class="page-link" href="javascript:goPage(${currentPage})">${currentPage}</a></li>
    </c:forEach>
    
    <li class='page-item <c:if test="${info.pageNum==info.pages}">disabled</c:if>' >
      <a class="page-link" href="javascript:goPage(${info.pages})" <c:if test="${info.pageNum==info.pages}">aria-disabled="true"</c:if> >尾页</a>
    </li>
  </ul>
</nav>