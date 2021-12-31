<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 28/12/2021
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<form method="post" >
    <input type="number" name="id" value="${deleteProduct.id}">
    <input type="text" name = "name" value="${deleteProduct.name}">
    <input type="number" name = "price" value="${deleteProduct.price}">
    <button>Xóa!</button>
</form>
</body>
</html>
