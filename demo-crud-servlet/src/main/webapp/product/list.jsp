<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 28/12/2021
  Time: 9:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<a href="/product?action=create">Tạo mới sản phẩm</a>
<c:forEach items='${products}' var="product">
    <h3>${product.id},${product.name},${product.price},<a href="/product?action=edit&&id=${product.id}">Sửa</a>,<a href="/product?action=delete&&id=${product.id}">Xóa</a></h3>
</c:forEach>

</body>
</html>
