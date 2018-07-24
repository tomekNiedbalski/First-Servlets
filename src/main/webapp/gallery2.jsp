<%@ page import="pl.sdacademy.model.Gallery" %>
<%@ page import="java.util.List" %>
<%@ page import="pl.sdacademy.servlets.GalleryServlet2" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Gallery2</h1>

<jsp:include page="menu.jsp"/>

<%
    List<String> linkList = (List) request.getAttribute("link_list");
%>

<h4> Gallery name: <%= linkList%>
</h4>
<h5> Created: <%= linkList%>
</h5>

Showing mode:
<form action="/gallery2" method="post">
    <input type="radio" name="showingChoice" value="1"> in 1 column
    <input type="radio" name="showingChoice" value="2"> in 2 column
    <input type="radio" name="showingChoice" value="3"> in 3 column
    <input type="radio" name="showingChoice" value="4"> in 4 column
    <input type="radio" name="showingChoice" value="5"> in 5 column
    <input type="radio" name="showingChoice" value="6"> in 6 column
    <input type="submit">
</form>

<table>

    <%=
      request.getAttribute("photosToPrint")
    %>
</table>

</body>
</html>
