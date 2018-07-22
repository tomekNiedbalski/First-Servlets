<%@ page contentType="text/html;charset=UTF-8"%>
<%@  taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@  page  isELIgnored  =  "false"  %>
<%@  taglib  prefix  =  "fmt"  uri  = "http://java.sun.com/jsp/jstl/fmt"  %>
<%@  taglib  prefix  =  "fn"  uri  = "http://java.sun.com/jsp/jstl/functions"  %>
<html>
<body>

<h1>
    <c:out value="Hello, World! ${1000+1000}"/>
</h1>
<h2>Hello World!</h2>

<!--<%! int i = 25;%>                        deklaracja -->
<!--<% out.print("Hello, JSP!"); %><br>        skryplet -->
<!--<%= 5 * i%>                                wyrażeie -->
</body>

<jsp:include page="menu.jsp"/>


</html>
