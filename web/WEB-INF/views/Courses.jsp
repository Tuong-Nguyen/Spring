<%--
  Created by IntelliJ IDEA.
  User: nkim
  Date: 5/16/2017
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Welcome to Courses</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<h1>Courses</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Title</th><th>Description</th><th>Start Date</th><th>End Date</th><th>Pax</th><th>Active</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="item" items="${list}">
        <tr>
            <td><a href="<spring:url value="/courses/${item.id}/get"/>">${item.title}</a></td>
            <td>${item.description}</td>
            <td>${item.startDate}</td>
            <td>${item.endDate}</td>
            <td>${item.pax}</td>
            <td>${(item.active == true? "Yes": "No")}</td>
            <td><a href="/courses/${item.id}/edit">Edit</a> </td>
            <td><a href="/courses/${item.id}/delete">Delete</a> </td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="/courses/create">Add New Course</a>
<button id="PUTbtn">PUT</button>
</body>
</html>
