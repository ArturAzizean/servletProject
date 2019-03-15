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
        Please add user
    </div>
    <form method="post" action="/users">
        <label for="first-name">First name
            <input class="color-input-field" type="text" id="first-name" name="first-name">
        </label>
        <label for="last-name">Last name
            <input type="text" id="last-name" name="last-name">
        </label>
        <input type="submit" value="Add user">
    </form>
</div>
</body>
</html>
