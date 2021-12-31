<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 28/12/2021
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<h1>Tạo sản phẩm mới</h1>
<form method="post" >
    <input type="number" name="id">
    <input type="text" name = "name">
    <input type="number" name = "price">
    <button>Tạo!</button>
</form>
</body>
</html>
