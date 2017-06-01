<%@ page import="java.util.Calendar" %>
<%@ page import="org.springframework.web.bind.annotation.ModelAttribute" %>
<%@ page import="spitter.web.models.User.User" %><%--
  Created by IntelliJ IDEA.
  User: nttao
  Date: 5/10/2017
  Time: 6:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <style type="text/css">
    </style>
    <script type="text/javascript">
        function enableEdit() {
            document.getElementById('txtName').removeAttribute("disabled");
            document.getElementById('txtBirthDay').removeAttribute("disabled");
//            document.getElementById("selectDate").removeAttribute("disabled");
//            document.getElementById("selectMonth").removeAttribute("disabled");
//            document.getElementById("selectYear").removeAttribute("disabled");
            document.getElementById("rdGender1").removeAttribute("disabled");
            document.getElementById("rdGender2").removeAttribute("disabled");
            document.getElementById("btnEnableEdit").setAttribute("onclick", "cancelEdit()");
            document.getElementById("btnEnableEdit").innerHTML = "Cancel";
        };
        function cancelEdit() {
            document.getElementById('txtName').setAttribute("disabled", "true");
            document.getElementById('txtBirthDay').setAttribute("disabled", "true");
//            document.getElementById("selectDate").setAttribute("disabled", "true");
//            document.getElementById("selectMonth").setAttribute("disabled", "true");
//            document.getElementById("selectYear").setAttribute("disabled", "true");
            document.getElementById("rdGender1").setAttribute("disabled", "true");
            document.getElementById("rdGender2").setAttribute("disabled", "true");
            document.getElementById("btnEnableEdit").setAttribute("onclick", "enableEdit()");
            document.getElementById("btnEnableEdit").innerHTML = "Edit";
        };

    </script>
</head>
<body>
    <form:form action="/user/profile/" method="post" modelAttribute="user">
        <div style="align-content: center">
            <table style="width: 510px">
                <thead>
                    <tr><h3>Password Change</h3></tr>
                </thead>
                <tbody>
                    <tr>
                        <td style="width: 120px"><label>Current pass: </label></td>
                        <td style="width: 380px"><input id="txtCurrentPass" type="password" name="CurrentPass" ></input></td>
                    </tr>
                    <tr>
                        <td style="width: 120px"><label>New pass: </label></td>
                        <td style="width: 380px"><input id="txtNewPass" type="password" name="NewPass" ></input></td>
                    </tr>
                    <tr>
                        <td style="width: 120px"><label>Retype new pass: </label></td>
                        <td style="width: 380px"><input id="txtRetypeNewPass" type="password" name="RetypeNewPass" ></input></td>
                    </tr>
                </tbody>
            </table>
            <table style="width: 510px">
                <thead>
                    <tr><h3>Profile</h3></tr>
                </thead>
                <tbody>
                    <tr>
                        <td style="width: 120px"><label>Name: </label></td>
                        <td style="width: 380px"><form:input id="txtName" path="userName" disabled="true" ></form:input></td>
                    </tr>
                    <tr>
                        <td style="width: 120px"><label>Email: </label></td>
                        <td style="width: 380px"><form:input path="email" disabled="true"></form:input></td>
                    </tr>
                    <tr>
                        <td style="width:120px"><label>Birthday:</label></td>
                        <td style="width: 380px"><form:input id="txtBirthDay" path="birthday" disabled="true"></form:input></td>
                    </tr>
                    <tr>
                        <td style="width: 120px"><label>Gender: </label></td>
                        <td style="width: 380px"><form:radiobuttons  id="rdGender" disabled="true" path="gender" items="${gender}" /></td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td style="align-content: center"><button id="btnEnableEdit" type="button" onclick="enableEdit()" >Edit</button></td>
                        <td style="align-content: center"><button type="submit" >Save</button></td>
                    </tr>
                </tfoot>
            </table>
        </div>
        <%--<div>--%>
            <%--<h3> My Course</h3>--%>
            <%--<table>--%>
                <%--<tr>--%>
                    <%--<th>Name</th>--%>
                    <%--<th>Description</th>--%>
                    <%--<th>Status</th>--%>
                <%--</tr>--%>
                <%--<c:forEach var="item" items="${account.enrollmentList}" varStatus="loop" >--%>
                    <%--<tr>--%>
                        <%--<td style="border: solid"><label>${item.course.title}</label></td>--%>
                        <%--<td style="border: solid"><label>${item.course.description}</label></td>--%>
                        <%--<td style="border: solid"><form:select path="enrollmentList[${loop.index}].status" items="${statuses}" disabled="true" /></td>--%>
                    <%--</tr>--%>
                <%--</c:forEach>--%>
            <%--</table>--%>
        <%--</div>--%>
    </form:form>
</body>
</html>
