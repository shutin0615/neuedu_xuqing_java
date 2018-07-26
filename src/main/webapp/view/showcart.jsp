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
<h1>查看购物车</h1>

<table>
<tr>
	 <th>购物车Id</th>
	 <th>商品id</th>
	 <th>商品名称</th>
	 <th>商品价格</th>
	 <th>商品图片</th>
	 <th>商品规格</th>
	 <th>商品库存</th>
	 <th>商品描述</th>
	 <th>购买数量</th>
	 <th>操作购物车</th>

</tr>
      <c:forEach items="${carts}" var="cart">
<tr style="color:red">

	<td>${cart.id}</td>
	<td>${cart.product.id}</td>
	<td>${cart.product.name}</td>
    <td>${cart.product.price}</td>
    <td>${cart.product.image}</td>
    <td>${cart.product.rule}</td>
    <td>${cart.product.stock}</td>
    <td>${cart.product.desc}</td>
    <td>${cart.productnum}</td>
 
    <td><a href="cart?id=${cart.id}&operation=3">删除</a>
	<a href="cart?id=${cart.id}&operation=5">修改</a></td>
</tr>


</c:forEach>

</table>

<a href="order?operation=1">立即下单</a>


</body>
</html>