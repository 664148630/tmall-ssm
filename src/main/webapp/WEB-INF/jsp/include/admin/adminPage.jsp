<!-- 模仿天猫整站ssm 教程 为how2j.cn 版权所有-->
<!-- 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关-->
<!-- 供购买者学习，请勿私自传播，否则自行承担相关法律责任-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

	
<script>
$(function(){
	$("ul.pagination li.disabled a").click(function(){
		return false;
	});
});

</script>


<nav>

	<a href="${pageContext.request.contextPath}/listCategory/1">首页</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/listCategory/${sp-1 }">上一页</a>&nbsp;&nbsp;
	<form action="${pageContext.request.contextPath}/listCategory" method="post" style="display: inline;">
		<input type="text" name="currentPage" value="${sp }" size="4">
	</form>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/listCategory/${sp+1 }">下一页</a>&nbsp;&nbsp;
	<a href="${pageContext.request.contextPath}/listCategory/${pageCounts }">末页</a><br>
	总记录数：${totals }&nbsp;&nbsp;
	总页数：${pageCounts }&nbsp;&nbsp;
	当前页：${sp}
	
  <%-- <ul class="pagination">
    <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
      <a  href="?start=0${page.param}" aria-label="Previous" >
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>

    <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
      <a  href="?start=${page.start-page.count}${page.param}" aria-label="Previous" >
        <span aria-hidden="true">&lsaquo;</span>
      </a>
    </li>    

    <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">
    
    	
		    <li <c:if test="${status.index*page.count==page.start}">class="disabled"</c:if>>
		    	<a  
		    	href="?start=${status.index*page.count}${page.param}"
		    	<c:if test="${status.index*page.count==page.start}">class="current"</c:if>
		    	>${status.count}</a>
		    </li>
		
    </c:forEach>

    <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
      <a href="?start=${page.start+page.count}${page.param}" aria-label="Next">
        <span aria-hidden="true">&rsaquo;</span>
      </a>
    </li>
    <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
      <a href="?start=${page.last}${page.param}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul> --%>
</nav>
