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
    <p>Restaurant: ${restaurant.name}</p>
    <p>Addres: ${restaurant.address}</p>
    <p>Reservations:</p>
    <c:forEach items="${restaurant.reservationList}" var="reservation">
        <p>${reservation.id}</p>
        <p>${reservation.note}</p>
        <p>${reservation.status}</p>
        <p>Date: ${reservation.reservationFor}</p>
        <p>Client: $${reservation.client.name}</p>
    </c:forEach>
</c:forEach>
</body>
</html>
