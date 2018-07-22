<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@  page isELIgnored="false" %>
<%@  taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@  taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="css/style.css"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="menu.jsp"/>
<br>
${requestScope.invalidUser}<br>
Register new user:<br>
<form method="post" action="/register">
    Login: <input type="text" name="login">
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Register">
</form>

</body>
</html>
