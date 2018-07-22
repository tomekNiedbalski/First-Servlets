<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@  page isELIgnored="false" %>
<%@  taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@  taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="css/style.css"/>
<c:if test="${sessionScope.login != null}">
Logged in: ${sessionScope.login}
    <form method="post" action="/logout">
    <input type="submit" value="Logout">
    </form>
</c:if>
<h4>Menu:</h4><br>
<div class="main_menu">
    <a href="index.jsp" style="padding: 10px 0px" >Home</a>
    <a href="instagram">Get photos to gallery</a>
    <a href="add_person">Add person to database</a>
    <a href="showPersons">Show persons from database</a>
    <a href="gallery">Visit our gallery</a>
    <a href="gallery2">Visit our gallery2</a>
    <a href="searchMuseum">Find your museum</a>
    <a href="about">About</a>
    <a href="login.jsp">Login</a>
    <a href="register.jsp">Register</a>
    <a href="contact">Contact</a>
</div>
