<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="/assets/css/bootstrap.css">
    <script src="/assets/js/jquery.js"></script>
    <script src="/assets/js/bootstrap.js"></script>
    <title>JSP Page</title>
</head>
<body>
<jsp:include page="partials/header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-xs-12">
            <div class="alert alert-success">
                <h3><spring:message code="text.reservation.success"></spring:message></h3>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <h3><spring:message code="text.reservation.details"></spring:message></h3>
            <p><spring:message code="label.restaurant.name"></spring:message> <c:out
                    value="${reservation.restaurant.name}"/></p>
            <p><spring:message code="label.reservation.for"></spring:message>
                : ${reservation.reservationFor.toGMTString()}</p>
            <p><spring:message code="label.reservation.for.time"></spring:message> : ${reservation.reservationAt} </p>
            <p><spring:message code="label.client.name"></spring:message> : ${reservation.client.name}</p>
            <p><spring:message code="label.reservation.note"></spring:message> : ${reservation.note}</p>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-12 center-block">
            <img class="img-responsive center-block" src="/assets/img/thank-you.jpg"/>
        </div>
    </div>
</div>
<footer>
    <div class="row">
        <div class="col-xs-12 col-sm-4">
            <ul class="nav nav-pills">
                <li class="item"><a href="#">Contact</a></li>
                <li><a href="#">Privacy</a></li>
            </ul>
        </div>
    </div>
    <div class="row">
        <p class="text-center">&copy; <spring:message code="label.name"/>| 2016-2017 | 2TX/1</p>
    </div>
</footer>

</body>
</html>
