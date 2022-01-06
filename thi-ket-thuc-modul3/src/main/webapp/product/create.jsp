<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/1/2022
  Time: 12:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<form method="post">

    <table>
        <tr>
            <td><label for="name">Name:</label></td>
            <td><input type="text" id="name" name="name"></td>
        </tr>
        <tr>
            <td><label for="price">Price:</label></td>
            <td><input type="text" id="price" name="price"></td>
        </tr>
        <tr>
            <td><label for="quantity">Quantity:</label></td>
            <td><input type="text" id="quantity" name="quantity"></td>
        </tr>
        <tr>
            <td><label for="color">Color:</label></td>
            <td><input type="text" id="color" name="color"></td>
        </tr>
        <tr>
            <td><label for="description">Description:</label></td>
            <td><input type="text" id="description" name="description"></td>
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
    <input type="submit" value="Create">
</form>

</body>
</html>
