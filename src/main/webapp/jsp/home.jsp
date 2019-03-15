<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 14.03.19
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<span style="color: ${cookie.color.value}">Hello</span>

<form method="post" action="/home">
    <label for="color">
    <select name="color" id="color">
        <option value="red">Красный</option>
        <option value="black">Черный</option>
        <option value="white">Белый</option>
    </select>
    </label>
    <input type="submit" value="Color send">
</form>
</body>
</html>
