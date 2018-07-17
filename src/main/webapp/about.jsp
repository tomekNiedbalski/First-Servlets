<%@ page contentType="text/html;charset=UTF-8" %>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@  page isELIgnored="false" %>
<%@  taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@  taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>About!</h1>

<jsp:include page="menu.jsp"/>
<c:set var="person_list" scope="page" value="${personList}"/>

Our people list has: ${person_list.size()} person.<br>

<table border="1" cellspacing="0">
    <tr bgcolor="#7fffd4">
        <th>Name</th>
        <th>Last name</th>
        <th>Born in</th>
        <th>Phone</th>
        <th>Sex</th>
    </tr>
    <c:forEach items="${person_list}" var="person">
        <tr bgcolor="#ffe4c4">
            <td>${person.getName()}</td>
            <td>${person.getLastName()}</td>
            <td>${person.getBornYear()}</td>
            <td>${person.getPhoneNumber()}</td>
            <td>${person.getSex().getSymbol()}</td>
        </tr>
    </c:forEach>
</table>
Table by sex:

<table border="1" cellspacing="0">
    <tr bgcolor="#7fffd4">
        <th>Name</th>
        <th>Last name</th>
        <th>Born in</th>
        <th>Phone</th>
        <th>Sex</th>
    </tr>

    <c:forEach items="${person_list}" var="person">
        <c:if test="${person.getSex().getSymbol() == 'F'}">
        <tr bgcolor="#ffe4c4">
            <td>${person.getName()}</td>
            <td>${person.getLastName()}</td>
            <td>${person.getBornYear()}</td>
            <td>${person.getPhoneNumber()}</td>
            <td>${person.getSex().getSymbol()}</td>
        </tr>
    </c:if>
    </c:forEach>
    <c:forEach items="${person_list}" var="person">
        <c:if test="${person.getSex().getSymbol() == 'M'}">
            <tr bgcolor="#ffe4c4">
                <td>${person.getName()}</td>
                <td>${person.getLastName()}</td>
                <td>${person.getBornYear()}</td>
                <td>${person.getPhoneNumber()}</td>
                <td>${person.getSex().getSymbol()}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>

Table with age over 30 years:

<table border="1" cellspacing="0">
    <tr bgcolor="#ff4500">
        <th>Name</th>
        <th>Last name</th>
        <th>Born in</th>
        <th>Phone</th>
        <th>Sex</th>
    </tr>
    <c:forEach items="${person_list}" var="person">
        <c:if test="${((2018-person.getBornYear()) > 30)}">
            <c:choose>
                <c:when test="${person.getLastName().startsWith('K')}">
                    <tr bgcolor="#adff2f">
                </c:when>
                <c:otherwise>
                    <tr>
                </c:otherwise>
            </c:choose>

                <td>${person.getName()}</td>
                <td>${person.getLastName()}</td>
                <td>${person.getBornYear()}</td>
                <td>${person.getPhoneNumber()}</td>
                <td>${person.getSex().getSymbol()}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>

</body>
</html>
