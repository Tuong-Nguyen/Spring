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
<form:form method="post" modelAttribute="courseForm" action="/courses">
    <table >
        <tr>
            <td>Id : </td>
            <td><form:input path="id" /></td>
        </tr>
        <tr>
            <td>Title : </td>
            <td><form:input path="title"  /></td>
            <td><form:errors style="color:red" path="title"/></td>
        </tr>
        <tr>
            <td>Description :</td>
            <td><form:input path="description" /></td>
            <td><form:errors style="color:red" path="description"/></td>
        </tr>
        <tr>
            <td>Start Date :</td>
            <td><form:input path="startDate" /></td>
        </tr>
        <tr>
            <td>End Date :</td>
            <td><form:input path="endDate" /></td>
        </tr>
        <tr>
            <td>Pax :</td>
            <td><form:input path="pax" /></td>
        </tr>
        <tr>
            <td>Active :</td>
            <td><form:checkbox path="active" /></td>
        </tr>
        <tr>
            <td>Add Lessons :</td>
        </tr>
        <tr>
            <td>Lessons 1:</td>
            <td>
        <tr>
            <td>Id :</td>
            <td><form:input path="lessons[0].id" /></td>
        </tr>
        <tr>
            <td>Title :</td>
            <td><form:input path="lessons[0].title" /></td>
        </tr>
        <tr>
            <td>Time(m) :</td>
            <td><form:input path="lessons[0].time" /></td>
        </tr>
        </td>
        </tr>
        <tr>
            <td>Lessons 2:</td>
            <td>
        <tr>
            <td>Id :</td>
            <td><form:input path="lessons[1].id" /></td>
        </tr>
        <tr>
            <td>Title :</td>
            <td><form:input path="lessons[1].title" /></td>
        </tr>
        <tr>
            <td>Time(m) :</td>
            <td><form:input path="lessons[1].time" /></td>
        </tr>
        </td>
        </tr>
        <tr>
            <td>Lessons 3:</td>
            <td>
        <tr>
            <td>Id :</td>
            <td><form:input path="lessons[2].id" /></td>
        </tr>
        <tr>
            <td>Title :</td>
            <td><form:input path="lessons[2].title" /></td>
        </tr>
        <tr>
            <td>Time(m) :</td>
            <td><form:input path="lessons[2].time" /></td>
        </tr>
        </td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>
