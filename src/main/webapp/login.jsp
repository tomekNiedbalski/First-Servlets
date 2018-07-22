<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@  page isELIgnored="false" %>
<%@  taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@  taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="menu.jsp"/>
<br>
<c:if test="${requestScope.loginError.equals('error')}">
    Wrong login/password!
</c:if>

<c:choose>
    <c:when test="${sessionScope.login == null}">
        <form method="post" action="/login">
            Login: <input type="text" name="login">
            Password: <input type="password" name="password"><br>
            <input type="submit" value="Login">
        </form>
    </c:when>
    <c:otherwise>
        ${sessionScope.login}, you are already logged in!
    </c:otherwise>
</c:choose>


</body>
</html>
