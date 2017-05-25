<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 25.05.2017
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Успех</title>
</head>
<body>
<div>${name} вы успешно прошли регистрацию. Воспользуйтесь формой авторизации ниже для входа в чат.
    <br>
    <table>
    <td class="login">
        <form action="loginUser">
            <input type="text" name="login">
            <br>
            <input type="text" name="password">
            <br>
            <input type="submit" value="Войти"></form>
    </td>
    </table>
</div>


</body>
</html>
