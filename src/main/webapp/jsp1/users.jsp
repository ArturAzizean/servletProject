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
    <table>
        <tr>
            <th>First name</th>
        </tr>
        <c:forEach items="${usersFromServer}" var="user">
            <tr>
                <td>${user.firstName}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
