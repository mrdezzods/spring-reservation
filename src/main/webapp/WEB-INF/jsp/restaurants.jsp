<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mrdezzods
  Date: 27/02/16
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant</title>
</head>
<body>

<c:forEach items="${restaurants}" var="restaurant">
    <p>Restaurant: ${restaurant}</p>
</c:forEach>
</body>
</html>
