<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 28/12/2021
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" >
    <input type="number" name="id" value="${changeProduct.id}">
    <input type="text" name = "name" value="${changeProduct.name}">
    <input type="number" name = "price" value="${changeProduct.price}">
    <button>Sửa!</button>
</form>
</body>
</html>
