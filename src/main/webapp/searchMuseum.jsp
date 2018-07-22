<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<form method="post" action="/searchMuseum" >
    <div>
        <br><select name="searchParameter">
        <option value="name">Name</option>
        <option value="city">City</option>
        <option value="street">Street</option>
        <option value="foundator">Fundator</option>
    </select>
        <input type="text" name="searchString"><br>
        <input type="submit" value="Search">
    </div>
</form>
Results: ${requestScope.searchResult.size()}
<table border="1" cellspacing="0" width="1100">
    <tr>
        <th>Name</th>
        <th width="70">Postal code</th>
        <th width="70">City</th>
        <th>Street</th>
        <th>Foundator</th>
        <th>Date of sign in</th>
        <th>Status</th>
    </tr>
    <c:forEach items="${requestScope.searchResult}" var="museum">
        <tr>
            <td>${museum.getName()}</td>
            <td>${museum.getPostalCode()}</td>
            <td>${museum.getCity()}</td>
            <td>${museum.getStreetPrefix()} ${museum.getStreet()} ${museum.getStreetNumber()}/${museum.getHomeNumber()}</td>
            <td>${museum.getMuseumFoundator()}</td>
            <td>${museum.getDateOfEntry()}</td>
            <td>${museum.getStatus()}</td>
        </tr>
    </c:forEach>
</table>



</body>
</html>
