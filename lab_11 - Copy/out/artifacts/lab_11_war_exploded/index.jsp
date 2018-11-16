
<%--
  Created by IntelliJ IDEA.
  User: KevinJustice
  Date: 11/15/2018
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
  <title>Login Page</title>
</head>
<body>
<form action="login" method="post" autocomplete="on">
  <label>Enter User Name: <input id="username" name="username" value="${cookie.user.value}"></label>
  <label>Enter Password: <input type="password" id="password" name="password"></label>
    <label>Remember Me <input type="checkbox" name="remember" value="yes" /></label>
  <%--<c:if test="${cookie.containsKey('user')}">checked</c:if>></label>--%>
      <button type="submit">Login</button><br />
    <span>${err_msg}</span>
</form>
</body>
</html>
