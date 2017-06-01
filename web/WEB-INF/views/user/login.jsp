<%--
  Created by IntelliJ IDEA.
  User: nttao
  Date: 5/4/2017
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <spring:url value="/user/login/" var="urlLogin" />
    <spring:url value="/user/register/" var="urlRegister" />
    <form:form method="post" action="${urlLogin}" modelAttribute="user">
        <div style="align-content: center">
            <table style="border: none; width: 700px; margin-left: auto; margin-right: auto;">
                <tr>
                    <td style="width:150px"><label>ID:</label></td>
                    <td style="width:250px"><form:input path="userId" type="text"/></td>
                </tr>
                <tr>
                    <td colspan="2"><form:errors path="userId" type="text" cssStyle="color: red"/></td>
                </tr>
                <tr>
                    <td style="width:150px"><label>Pass:</label></td>
                    <td style="width:250px"><form:input path="password" type="password" /></td>
                </tr>
                <tr>
                    <td colspan="2"><form:errors path="password" type="text" cssStyle="color: red"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <table style="border: none">
                            <tr>
                                <td style="width: 50%; align-content: center"><button type="submit" name="btnLogin" >Login</button></td>
                                <td style="width: 50%; align-content: center"><button type="button" name="btnRegister" onclick="location.href='${urlRegister}'">Register</button></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
    </form:form>
</body>
</html>