<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@  page isELIgnored="false" %>
<%@  taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@  taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<h1>Contact</h1>

<jsp:include page="menu.jsp"/>

<i><b>Fill form to contact:</b></i>
<form method="post" action="" >
    <div id="email_form">
        Name:           <br><input type="text" name="name"> <br>
        Last name:      <br> <input type="text" name="lastName"> <br>
        Email:          <br><input type="email" name="email"> <br>
        Message title:  <br><input type="text" name="title"> <br>
        Message:        <br> <textarea type="text" name="message" cols="70" rows="10" size="1500">Enter your message</textarea><br>
        <input type="submit" value="Send email">
    </div>
</form>

</body>
</html>
