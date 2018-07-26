<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>查看类别</h1>
<h3><a href="addCategory.jsp">添加类别</a></h3>

<table border=2 cellspading=5>
	<tr>
		<th>类别id</th>
		<th>父类别id</th>
		<th>类别名称</th>
		<th>类别状态</th>
		<th>排序编号</th>
		<th>创建时间</th>
		<th>更新时间</th>
		<th>操作选项</th>
	</tr>
	<c:forEach items="${pageModel.data}" var="category">
	
	<tr>
		<td>${category.id}</td> 
		<td>${category.parent_id}</td>
		<td>${category.name}</td>
		<td>${category.status }</td>
		<td>${category.sort_order }</td>
		<td>${category.create_time }</td>
		<td>${category.update_time }</td>
		<td><a href="Category1?id=${category.id}&opera=4">删除</a></td>
		<td><a href="Category1?id=${category.id}&opera=5">修改</a></td>
	</tr>
	</c:forEach>

</table>

<c:forEach var="accss" begin="1" end="${pageModel.totalPage}" step="1" >
    <c:choose>
       <c:when test="${pageModel.currentPage==accss}">
          <a  style="color:red"  href="Category1?opera=2&pageNo=${accss}&pageSize=3">${accss}</a>
       </c:when>
    <c:when test="${pageModel.currentPage!= accss}">
    <a href="Category1?opera=2&pageNo=${accss}&pageSize=3">${accss}</a>
    </c:when>
   </c:choose>
    

</c:forEach>


</body>
</html>