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
    <title>Title</title>
    <link href="/css/signUp.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-5">
    <div class="form-style-5-heading">
        Please Sign up
    </div>
    <form method="post" action="/signUp">
        <label for="name">User name
            <input type="text" id="name" name="name">
        </label>
        <label for="birthDate">Birth date
            <input type="text" id="birthDate" name="birthDate">
        </label>
        <label for="password">Password
            <input type="password" id="password" name="password">
        </label>
        <input type="submit" value="Sign Up">
    </form>
</div>

<div class="form-style-5">
    <table>
        <tr>
            <th>User name</th>
            <th>Birth Date</th>
        </tr>
        <c:forEach items="${usersFromServer}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.birthDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
