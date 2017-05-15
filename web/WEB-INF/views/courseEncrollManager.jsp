<%--
  Created by IntelliJ IDEA.
  User: nttao
  Date: 5/15/2017
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager Course Request</title>
</head>
<body>
    <form:form action="/course/save/" method="post" modelAttribute="account">
        <div>
            <h3> Encroll Course Requests</h3>
            <table>
                <tbody>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Status</th>
                    </tr>
                    <c:forEach var="i" begin="1" end="${fn:length(account.listCourse)}">
                        <tr>
                            <td style="border: solid"><form:label path="listCourse[${i-1}].course.title">${account.listCourse[i-1].course.title}</form:label></td>
                            <td style="border: solid"><form:label path="listCourse[${i-1}].course.description">${account.listCourse[i-1].course.description}</form:label></td>
                            <td style="border: solid"><form:select path="listCourse[${i-1}].status" items="${statuses}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <td><button type="submit" >Save</button></td>
                </tfoot>
            </table>
        </div>
    </form:form>
</body>
</html>
