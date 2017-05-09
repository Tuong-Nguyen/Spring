<%--
  Created by IntelliJ IDEA.
  User: nkim
  Date: 5/5/2017
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Course</title>
</head>
<body>
    <h1>Edit Course</h1>
    <form:form method="post" modelAttribute="courseForm" action="/editSave">
        <table >
            <tr>
                <td></td>
                <td><form:hidden path="id" /></td>
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
