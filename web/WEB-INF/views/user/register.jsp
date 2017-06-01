<%--
  Created by IntelliJ IDEA.
  User: nttao
  Date: 5/31/2017
  Time: 11:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<spring:url value="/user/register/" var="urlRegister" />
<form:form method="post" action="${urlRegister}" modelAttribute="user">
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
                <td style="width:150px"><label>Retype Pass:</label></td>
                <td style="width:250px"><form:input path="retypePassWord" type="password" /></td>
            </tr>
            <tr>
                <td colspan="2"><form:errors path="retypePassWord" type="text" cssStyle="color: red"/></td>
            </tr>
            <tr>
                <td style="width:150px"><label>User Name:</label></td>
                <td style="width:250px"><form:input path="userName" type="text" /></td>
            </tr>
            <tr>
                <td colspan="2"><form:errors path="userName" type="text" cssStyle="color: red"/></td>
            </tr>
            <tr>
                <td style="width:150px"><label>Birthday:</label></td>
                <td style="width:250px">
                    <table style="border: none; padding:0px; margin: 0px;">
                        <tr style="width: 100%; padding:0px; margin: 0px;">
                            <td style="width: 25%;"><select style="width: 40px;" type="text" name="date">
                                <c:forEach var = "i" begin="1" end="31">
                                    <option value="${i}">${i}</option>
                                </c:forEach>
                            </select></td>
                            <td style="width: 25%;"><select style="width: 40px;" type="text" name="month">
                                <c:forEach var = "i" begin="1" end="12">
                                    <option value="${i}">${i}</option>
                                </c:forEach>
                            </select></td>
                            </select></td>
                            <td style="width: 50%;"><input style="width: 82px;" type="number" name="year" min="1900" max="2017"></td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="2"><form:errors path="birthday" type="text" cssStyle="color: red"/></td>
            </tr>
            <tr>
                <td style="width:150px"><label>Email:</label></td>
                <td style="width:250px"><form:input path="email" type="email" name="Email" /></td>
            </tr>
            <tr>
                <td colspan="2"><form:errors path="email" type="text" cssStyle="color: red"/></td>
            </tr>
            <tr>
                <td style="width:150px"><label>Gender:</label></td>
                <td style="width:250px"><form:radiobuttons path="gender" items="${gender}" /></td>
            </tr>
            <tr>
                <td colspan="2"><form:errors path="gender" type="text" cssStyle="color: red"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <table style="border: none">
                        <tr>
                            <td style="width: 50%; align-content: center"><button type="submit" name="btnRegister">Register</button></td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
</form:form>
</body>
</html>