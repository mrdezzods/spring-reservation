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
        <h2>Reservation in <c:out value="${restaurant.name}"></c:out></h2>
    </div>
    <div class="row">
        <c:if test="${errors != null}">
            <div class="alert alert-danger" style="margin-right: 15px;">
                <span class="close pull-right" data-dismiss="alert">&times;</span>

                <c:forEach items="${errors}" var="error">
                    <p> ${error.defaultMessage}</p>
                </c:forEach>
            </div>
        </c:if>

        <div class="col-sm-12 col-md-8">
            <form action="<c:url value="/reservations"/>" method="POST" class="form form-horizontal">
                <div class="form-group">
                    <label class="control-label">Name</label>
                    <input name="Client.name" value="<c:out value="${reservation.client.name}"/>" type="text"
                           class="form-control">
                </div>

                <div class="row">
                    <div class="col-xs-12 col-sm-6">
                        <div class="form-group">
                            <label class="control-label">Email</label>
                            <input name="Client.email" value="<c:out value="${reservation.client.email}"/>" type="email"
                                   class="form-control">
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6">
                        <div class="form-group">
                            <label class="control-label">Tel</label>
                            <input name="Client.tel" value="<c:out value="${reservation.client.tel}"/>" type="tel"
                                   class="form-control">
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-xs-12 col-sm-6">
                        <div class="form-group">
                            <label class="control-label">People</label>
                            <input type="number" value="<c:out value="${reservation.people}"/>" name="people" max="12"
                                   min="1" class="form-control">
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6">
                        <div class="form-group">
                            <label class="control-label">Date</label>

                            <input name="reservation_for" value="<c:out value="${reservation.reservationFor}"/>"
                                   type="date" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label">Note</label>
                    <textarea name="note" rows="3" cols="12" class="form-control"><c:out
                            value="${reservation.note}"/></textarea>
                </div>


                <div class="form-group">
                    <input type="submit" class="btn btn-success" value="Make Reservation!">
                </div>

            </form>
        </div>
        <div class="hidden-sm col-md-4">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <div class="panel-title">Extra info</div>
                </div>
                <div class="panel-body">
                    bla bla bla
                </div>
            </div>
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
