<%--
  Created by IntelliJ IDEA.
  User: nttao
  Date: 5/4/2017
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<div style="align-content: center">
    <table style="border: none; width: 400px; margin-left: auto; margin-right: auto;">
        <tr>
            <td style="width:150px"><label>ID:</label></td>
            <td style="width:250px"><input type="text" name="txtUserName"></td>
        </tr>
        <tr>
            <td style="width:150px"><label>Pass:</label></td>
            <td style="width:250px"><input type="password" name="txtPassWord"></td>
        </tr>
        <tr>
            <td style="width:150px"><label>Retype Pass:</label></td>
            <td style="width:250px"><input type="password" name="txtRetypePassWord"></td>
        </tr>
        <tr>
            <td style="width:150px"><label>User Name:</label></td>
            <td style="width:250px"><input type="text" name="txtUserName"></td>
        </tr>
        <tr>
            <td style="width:150px"><label>Birthday:</label></td>
            <td style="width:250px"><input type="text" name="txtBirthday"></td>
        </tr>
        <tr>
            <td style="width:150px"><label>Email:</label></td>
            <td style="width:250px"><input type="email" name="txtEmail"></td>
        </tr>
        <tr>
            <td colspan="2">
                <table style="border: none">
                    <tr>
                        <td style="width: 50%; align-content: center"><button name="btnRegister">Register</button></td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
