<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@  page isELIgnored="false" %>
<%@  taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@  taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="menu.jsp"/>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Last name</th>
        <th>Born year</th>
        <th>Phone</th>
        <th>Sex</th>
    </tr>
    <c:forEach items="${requestScope.persons}" var="museum">
        <tr>
            <td>${museum.getName()}</td>
            <td>${museum.getLastName()}</td>
            <td>${museum.getBornYear()}</td>
            <td>${museum.getPhoneNumber()}</td>
            <td>${museum.getSex().getSymbol()}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
