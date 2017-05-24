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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
<jsp:include page="../views/fragments/header.jsp"></jsp:include>
<c:choose>
    <c:when test="${isLogin == false}">
        <h1>Welcome to Spitter!</h1>
        <label><a href="<c:url value="/login/" />">Login</a></label> |
        <label><a href="<c:url value="/register/" />">Register</a></label>
    </c:when>
    <c:when test="${isLogin == true}">
        <h1>Welcome <a href="<c:url value="/user/profile/" />">${user}</a></h1>
        <h4><a href="<c:url value="/course/encrollrequest/" />">Encroll Request Manager</a></h4>
        <label><a href="<c:url value="/logout/" />">Logout</a></label> |
        <label><a href="<c:url value="/register/" />">Register</a></label>
    </c:when>
</c:choose>
</body>
</html>
