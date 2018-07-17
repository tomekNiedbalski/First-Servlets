<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@  page isELIgnored="false" %>
<%@  taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@  taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <meta http-equiv="Refresh" content="5;url=contact.jsp">
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>

<jsp:include page="menu.jsp"/>

<h3>Hello ${requestScope.name} ${requestScope.lastName}!</h3>
<p>Thanks for your message.</p>
<p>Your email: ${requestScope.email}</p>
<p><i>Your message:</i></p>
${requestScope.message}




</body>
</html>
