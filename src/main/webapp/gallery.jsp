<%@ page import="pl.sdacademy.model.Gallery" %>
<%@ page import="pl.sdacademy.model.Image" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Gallery</h1>

<jsp:include page="menu.jsp"/>

<% Gallery playersGallery = (Gallery) request.getAttribute("players");%>

<h4> Gallery name: <%= playersGallery.getName()%>
</h4>
<h5> Created: <%= playersGallery.getDate()%>
</h5>

<table>

    <%  int listSize = playersGallery.getImageList().size();
        List<Image> imageList = playersGallery.getImageList();
        Image image =null;
        for (int i = 0; i < listSize; i++) {
        if(listSize<2){%>
            <tr>
                <td>
                    <img src="<%=imageList.get(i).getUrlAddress()%>" title=<%=imageList.get(i).getDescription()%> width="200" height="150">
                </td>
            </tr>
        <%}
        else {
            if(i%2==0){
                image = imageList.get(i);
            }
            else {%>
    <tr>
        <td>
            <img src="<%=imageList.get(i).getUrlAddress()%>" title=<%=imageList.get(i).getDescription()%> width="200" height="150">
        </td>
        <td>
            <img src="<%=image.getUrlAddress()%>" title=<%=image.getDescription()%> width="200" height="150">
        </td>
    </tr>
            <%}
        }
    }
    %>

</table>

</body>
</html>
