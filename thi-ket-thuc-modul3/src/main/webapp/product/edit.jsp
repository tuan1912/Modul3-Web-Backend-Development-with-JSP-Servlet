<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/1/2022
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>

<form method="post">
    <input type="text" hidden name="id" value="${product.id}">
    <table>
        <tr>
            <td><label for="name">Name:</label></td>
            <td><input type="text" id="name" name="name" value="${product.name}"></td>
        </tr>
        <tr>
            <td><label for="price">Price:</label></td>
            <td><input type="text" id="price" name="price" value="${product.price}"></td>
        </tr>
        <tr>
            <td><label for="quantity">Quantity:</label></td>
            <td><input type="text" id="quantity" name="quantity" value="${product.quantity}"></td>
        </tr>
        <tr>
            <td><label for="color">Color:</label></td>
            <td><input type="text" id="color" name="color" value="${product.color}"></td>
        </tr>
        <tr>

<%--            <c:if test="${product.description = null}">--%>
<%--                <td><label for="description1">Description:</label></td>--%>
<%--                <td><input type="text" id="description1" name="description" value="${product.name}"></td>--%>
<%--            </c:if>--%>
            <td><label for="description2">Description:</label></td>
            <td><input type="text" id="description2" name="description" value="${product.description}"></td>
        </tr>
        <tr>
            <td>Category</td>
            <td><select name="category" id="category">
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>
            </td>
        </tr>
    </table>
    <input type="submit" value="Edit">
</form>
</body>
</html>
