<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

  Created by IntelliJ IDEA.
  User: artur
  Date: 13.03.19
  Time: 8:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="/css/signUp.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-5">
    <div class="form-style-5-heading">
        Please Sign in
    </div>
    <form method="post" action="/login">
        <label for="name">User name
            <input class="color-input-field" type="text" id="name" name="name">
        </label>
        <label for="password">Password
            <input type="password" id="password" name="password">
        </label>
        <input type="submit" value="Sign In">
    </form>
</div>
</body>
</html>
