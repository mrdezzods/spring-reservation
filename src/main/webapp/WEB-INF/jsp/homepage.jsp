<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="container" style="min-height: 500px;">
    <div class="row">
        <c:forEach items="${popularRestaurants}" var="restaurant">
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <div class="panel-title">${restaurant.name}</div>
                    </div>
                    <div class="panel-body restaurant-info">
                        <img class="img-responsive" src="<c:out value="${restaurant.logo}"/>" alt="">
                    </div>
                    <div class="panel-footer">
                            ${restaurant.address}
                    </div>
                    <div class="panel-footer">
                        <a href="/restaurants/${restaurant.slug}" class="btn btn-block btn-info">Reserve</a>
                    </div>
                </div>
            </div>
        </c:forEach>
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
        <p class="text-center">&copy; Vijay Sapkota | 2016-2017 | 2TX/1</p>
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
