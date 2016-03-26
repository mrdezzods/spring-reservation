<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<spring:url value="/assets/css/bootstrap.css"></spring:url>">
    <script src="<spring:url value="/assets/js/jquery.js"></spring:url>"></script>
    <script src="<spring:url value="/assets/js/bootstrap.js"></spring:url>"></script>
    <title>Reservation</title>
</head>
<body>
<jsp:include page="partials/header.jsp"/>
<div class="container" style="min-height: 500px;">
    <div class="row">
        <c:forEach items="${popularRestaurants}" var="restaurant">
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <div class="panel-title">${restaurant.name}</div>
                    </div>
                    <div class="panel-body restaurant-info">
                        <img class="img-responsive" src="<spring:url value="${restaurant.logo}"></spring:url>" alt="">
                    </div>
                    <div class="panel-footer">
                            ${restaurant.address}
                    </div>
                    <div class="panel-footer">
                        <a href="<spring:url value="/reservations/${restaurant.slug}"></spring:url>"
                           class="btn btn-block btn-info">Reserve</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<footer>
    <div class="row">
        <p class="text-center">&copy; <spring:message code="label.name"/>| 2016-2017 | 2TX/1</p>
    </div>
</footer>

<style>
    .restaurant-info {
        height: 300px;
    }

    #jumbotron-text {
        position: absolute;
        bottom: 0;
        width: 100%;
        height: 50px;
        clear: both;
    }
</style>
</body>
</html>
