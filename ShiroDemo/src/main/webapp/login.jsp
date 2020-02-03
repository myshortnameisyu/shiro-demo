<%--
  Created by IntelliJ IDEA.
  User: island
  Date: 2020/1/15
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <h4>Login Pages</h4>
    <form action="./shiro/login" method="post">
        username:<input type="text" name="username"/>
        <br/>
        password:<input type="password" name="password">
        <br/>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
