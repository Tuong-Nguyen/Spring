<%--
  Created by IntelliJ IDEA.
  User: nkim
  Date: 5/8/2017
  Time: 5:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Course</title>
</head>
<body>
<h1>Add Course</h1>
<form:form method="post" modelAttribute="courseForm" action="/save">
    <table >
        <tr>
            <td>Id : </td>
            <td><form:input path="id" /></td>
        </tr>
        <tr>
            <td>Title : </td>
            <td><form:input path="title"  /></td>
        </tr>
        <tr>
            <td>Description :</td>
            <td><form:input path="description" /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>
