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
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Welcome to Spitter</title>
</head>
<body>
<c:choose>
    <c:when test="${isLogin == false}">
        <h1>Welcome to Spitter!</h1>
        <label><a href="<c:url value="/user/login/" />">Login</a></label> |
        <label><a href="<c:url value="/user/register/" />">Register</a></label>
    </c:when>
    <c:when test="${isLogin == true}">
        <h1>Welcome <a href="<c:url value="/user/profile/?id=${userId}" />">${userName}</a></h1>
        <h4><a href="<c:url value="/course/encrollrequest/" />">Encroll Request Manager</a></h4>
        <label><a href="<c:url value="/user/logout/" />">Logout</a></label> |
        <label><a href="<c:url value="/user/register/" />">Register</a></label>
    </c:when>
</c:choose>

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
</body>
</html>
