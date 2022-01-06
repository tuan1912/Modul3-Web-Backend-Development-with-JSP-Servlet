<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/1/2022
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
</head>
<body>
<a href="/product?action=create">CREATE NEW PRODUCT</a>
<table border="1" cellpadding="5">
    <caption><h2>List of Users</h2></caption>
    <tr>
        <th>Ordinal</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Color</th>
        <th>Desciption</th>
        <th>Category</th>
        <th>Action</th>
    </tr>
    <c:forEach var="i" begin = "0" end="${products.size()-1}"  >
        <tr>
            <td><c:out value="${i}"/></td>
            <td><c:out value="${products.get(i).name}"/></td>
            <td><c:out value="${products.get(i).price}"/></td>
            <td><c:out value="${products.get(i).quantity}"/></td>
            <td><c:out value="${products.get(i).color}"/></td>
            <td><c:out value="${products.get(i).description}"/></td>
            <td><c:out value="${categories.get(i).name}"/></td>

            <td>
                <a href="/product?action=edit&id=${products.get(i).getId()}">Edit</a>
                <a href="/product?action=delete&id=${products.get(i).getId()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table></body>
</html>
