<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 31/12/2021
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Student</title>
</head>
<body>
<table border="1" cellpadding="5">
    <caption><h2>List of Users</h2></caption>
    <tr>
        <th>Ordinal</th>
        <th>Name</th>
        <th>Date Of Birth</th>
        <th>Address</th>
        <th>Phone Number</th>
        <th>Email</th>
        <th>Class Room</th>
        <th>Action</th>
    </tr>
    <c:forEach var="student" items="${students}" varStatus="loop">
        <tr>
            <td><c:out value="${student.id}"/></td>
            <td><c:out value="${student.name}"/></td>
            <td><c:out value="${student.dateOfBirh}"/></td>
            <td><c:out value="${student.address}"/></td>
            <td><c:out value="${student.phoneNumber}"/></td>
            <td><c:out value="${student.email}"/></td>
            <td><c:out value="${student.classRoomId}"/></td>
            <td>
                <a href="/users?action=edit&id=${student.id}">Edit</a>
                <a href="/users?action=delete&id=${student.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
