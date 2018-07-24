<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@  page isELIgnored="false" %>
<%@  taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@  taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="menu.jsp"/>

<i><b>Fill form to download photos from instagram:</b></i>
<form method="post" action="/instagram" >
    <div id="email_form">
        Instagram account:           <br><input type="text" name="instagram_account"> <br>
        Number of photos:            <br> <input type="text" name="number_of_photos"> <br>
        <input type="submit" value="Download photos">
    </div>
</form>

</body>
</html>
