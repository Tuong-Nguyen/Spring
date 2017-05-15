<%@ page import="java.util.Calendar" %>
<%@ page import="org.springframework.web.bind.annotation.ModelAttribute" %>
<%@ page import="spitter.web.models.AccountModel" %><%--
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
        function getDayofMonth(year, month) {
            if(month == 4 || month == 6 || month == 9 || month == 11){
                return 30;
            }
            if(month == 2){
                if(year % 4 == 0)
                    return 29;
                return 28;
            }
            return 31;
        };
        function enableEdit() {
            document.getElementById('txtName').removeAttribute("disabled");
            document.getElementById("selectDate").removeAttribute("disabled");
            document.getElementById("selectMonth").removeAttribute("disabled");
            document.getElementById("selectYear").removeAttribute("disabled");
            document.getElementById("rdGender1").removeAttribute("disabled");
            document.getElementById("rdGender2").removeAttribute("disabled");
            document.getElementById("btnEnableEdit").setAttribute("onclick", "cancelEdit()");
            document.getElementById("btnEnableEdit").innerHTML = "Cancel";
        };
        function cancelEdit() {
            document.getElementById('txtName').setAttribute("disabled", "true");
            document.getElementById("selectDate").setAttribute("disabled", "true");
            document.getElementById("selectMonth").setAttribute("disabled", "true");
            document.getElementById("selectYear").setAttribute("disabled", "true");
            document.getElementById("rdGender1").setAttribute("disabled", "true");
            document.getElementById("rdGender2").setAttribute("disabled", "true");
            document.getElementById("btnEnableEdit").setAttribute("onclick", "enableEdit()");
            document.getElementById("btnEnableEdit").innerHTML = "Edit";
        };

    </script>
</head>
<body>
    <form:form action="/user/profile/" method="post" modelAttribute="account">
        <div style="align-content: center">
            <table style="width: 510px">
                <thead>
                    <tr><h3>Password Change</h3></tr>
                </thead>
                <tbody>
                    <tr>
                        <td style="width: 120px"><label>Current pass: </label></td>
                        <td style="width: 380px"><input id="txtCurrentPass" type="password" name="strCurrentPass" ></input></td>
                    </tr>
                    <tr>
                        <td style="width: 120px"><label>New pass: </label></td>
                        <td style="width: 380px"><input id="txtNewPass" type="password" name="strNewPass" ></input></td>
                    </tr>
                    <tr>
                        <td style="width: 120px"><label>Retype new pass: </label></td>
                        <td style="width: 380px"><input id="txtRetypeNewPass" type="password" name="strRetypeNewPass" ></input></td>
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
                        <td style="width: 380px"><form:input id="txtName" path="strName" disabled="true" ></form:input></td>
                    </tr>
                    <tr>
                        <td style="width: 120px"><label>Email: </label></td>
                        <td style="width: 380px"><form:input path="strEmail" disabled="true"></form:input></td>
                    </tr>
                    <tr>
                        <td style="width:120px"><label>Birthday:</label></td>
                        <td style="width:380px">
                            <table style="border: none; padding:0px; margin: 0px;">
                                <tr style="width: 100%; padding:0px; margin: 0px;">
                                    <td style="width: 25%;"><select id="selectDate" disabled style="width: 40px;" type="text" name="date" value="${account.dBirthDay.date}>
                                        <c:forEach var = "i" begin="1" end="31">
                                            <option value="${i}">${i}</option>
                                        </c:forEach>
                                    </select></td>
                                    <td style="width: 25%;"><select id="selectMonth" disabled style="width: 40px;" type="text" name="month" value="${account.dBirthDay.month}>
                                        <c:forEach var = "i" begin="1" end="12">
                                            <option value="${i}">${i}</option>
                                        </c:forEach>
                                    </select></td>
                                    </select></td>
                                    <td style="width: 50%;"><input path="${account}" id="selectYear" disabled style="width: 82px;" type="number" name="year" min="1900" max="2017" value="${account.dBirthDay.year}"></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 120px"><label>Gender: </label></td>
                        <td style="width: 380px"><form:radiobuttons  id="rdGender" disabled="true" path="strGender" items="${gender}" /></td>
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
        <div>
            <h3> My Course</h3>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Approved</th>
                </tr>
                <c:forEach var="i" begin="0" end="${fn:length(account.listCourse) -1}">
                    <tr>
                        <td style="border: solid"><form:label path="listCourse[${i}].course.title">${account.listCourse[i].course.title}</form:label></td>
                        <td style="border: solid"><form:label path="listCourse[${i}].course.description">${account.listCourse[i].course.description}</form:label></td>
                        <td style="border: solid"><form:checkbox path="listCourse[${i}].approved"  disabled="true" /></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </form:form>
</body>
</html>
