<%--
  Created by IntelliJ IDEA.
  User: niedb
  Date: 21.07.2018
  Time: 07:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="menu.jsp"/>

<form method="post" action="add_person" >
    <div id="email_form">
        Name:           <br><input type="text" name="name" required> <br>
        Last name:      <br> <input type="text" name="lastName" required> <br>
        Born year:      <br><input type="number" name="bornYear" value="2000" required> <br>
        Phone:          <br><input type="tel" name="phoneNumber" placeholder="123456789"
                                   pattern="[0-9]{9}"
                                   required> <br>
        Sex:
        <br><select name="sex" required>
        <option value="UN">Choose...</option>
        <option value="F">Female</option>
        <option value="M">Male</option>
         </select><br>
        <input type="submit" value="Add person">
    </div>
</form>

</body>
</html>
