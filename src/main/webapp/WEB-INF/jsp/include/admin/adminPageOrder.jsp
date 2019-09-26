<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分类管理分页</title>
<script>
$(function(){
	$("ul.pagination li.disabled a").click(function(){
		return false;
	});
});

</script>
</head>
<body>
	<nav>

		<a href="${pageContext.request.contextPath}/listOrder/1">首页</a>&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath}/listOrder/${sp-1 }">上一页</a>&nbsp;&nbsp;
		<form action="${pageContext.request.contextPath}/listOrder" method="post" style="display: inline;">
			<input type="text" name="currentPage" value="${sp }" size="4">
		</form>&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath}/listOrder/${sp+1 }">下一页</a>&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath}/listOrder/${pageCounts }">末页</a><br>
		总记录数：${totals }&nbsp;&nbsp;
		总页数：${pageCounts }&nbsp;&nbsp;
		当前页：${sp}
	</nav>
</body>
</html>