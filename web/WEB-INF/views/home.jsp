<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%--
  Created by IntelliJ IDEA.
  User: lnthao
  Date: 4/28/2017
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Welcome to Spitter</title>
</head>
<body>

<h1>Welcome to ${welcome}</h1>
<a href="<c:url value="/login/" />">Login</a> |
<a href="<c:url value="/register/" />">Register</a>

<h1>Courses</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Title</th><th>Description</th><th>Start Date</th><th>End Date</th><th>Pax</th><th>Active</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="item" items="${list}">
        <tr>
            <td>${item.title}</td>
            <td>${item.description}</td>
            <td>${item.startDate}</td>
            <td>${item.endDate}</td>
            <td>${item.pax}</td>
            <td>${(item.active == true? "Yes": "No")}</td>
            <td><a href="editCourse/${item.id}">Edit</a> </td>
            <td><a href="deleteCourse/${item.id}">Delete</a> </td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="addCourse">Add New Course</a>
</body>
</html>
