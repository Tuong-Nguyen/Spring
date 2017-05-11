<%--
  Created by IntelliJ IDEA.
  User: nttao
  Date: 5/10/2017
  Time: 6:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            document.getElementById("rdGender").removeAttribute("disabled");
        };
        function cancelEdit() {
            document.getElementById('txtName').setAttribute("disabled");
            document.getElementById("selectDate").setAttribute("disabled");
            document.getElementById("selectMonth").setAttribute("disabled");
            document.getElementById("selectYear").setAttribute("disabled");
            document.getElementById("rdGender").setAttribute("disabled");
        };

    </script>
</head>
<body>
    <form:form action="" method="PUT" modelAttribute="account">
        <table>
            <thead>
                <tr>Your Profile</tr>
            </thead>
            <tbody>
                <tr>
                    <td style="width: 30%"><label>Name: </label></td>
                    <td style="width: 70%"><form:input id="txtName" path="strName" disabled="true"></form:input></td>
                </tr>
                <tr>
                    <td style="width: 30%"><label>Email: </label></td>
                    <td style="width: 70%"><form:input path="strEmail" disabled="true"></form:input></td>
                </tr>
                <tr>
                    <td style="width:150px"><label>Birthday:</label></td>
                    <td style="width:250px">
                        <table style="border: none; padding:0px; margin: 0px;">
                            <tr style="width: 100%; padding:0px; margin: 0px;">
                                <td style="width: 25%;"><select id="selectDate" disabled style="width: 40px;" type="text" name="date">
                                    <c:forEach var = "i" begin="1" end="31">
                                        <option value="${i}">${i}</option>
                                    </c:forEach>
                                </select></td>
                                <td style="width: 25%;"><select id="selectMonth" disabled style="width: 40px;" type="text" name="month" >
                                    <c:forEach var = "i" begin="1" end="12">
                                        <option value="${i}">${i}</option>
                                    </c:forEach>
                                </select></td>
                                </select></td>
                                <td style="width: 50%;"><input id="selectYear" disabled style="width: 82px;" type="number" name="year" min="1900" max="2017"></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td style="width: 30%"><label>Gender: </label></td>
                    <td style="width: 70%"><form:radiobuttons  id="rdGender" disabled="true" path="strGender" items="${gender}" /></td>
                </tr>
            </tbody>
            <tfoot>
                <tr>
                    <td><button type="button" onclick="enableEdit()" >Edit</button></td>
                    <td><button type="button" >Save</button></td>
                </tr>
            </tfoot>
        </table>
    </form:form>
</body>
</html>
