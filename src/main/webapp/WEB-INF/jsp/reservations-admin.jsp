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
        <h3><spring:message code="label.reservations"></spring:message></h3>
        <table class="table table-bordered">
            <tr>
                <th><spring:message code="label.restaurant.name"></spring:message></th>
                <th><spring:message code="label.client_admin.name"></spring:message></th>
                <th><spring:message code="label.reservation.for"></spring:message></th>
                <th><spring:message code="label.reservation.note"></spring:message></th>
                <th><spring:message code="label.reservation_status"></spring:message></th>
                <th><spring:message code="label.action"></spring:message></th>
            </tr>
            <tbody>
            <c:if test="${reservations.size() == 0}">
                <tr>
                    <td colspan="6" class="text-center text-info">
                        <spring:message code="label.no_reservations"></spring:message>
                    </td>
                </tr>
            </c:if>
            <c:forEach items="${reservations}" var="reservation">
                <tr>
                    <td><c:out value="${reservation.restaurant.name}"></c:out></td>
                    <td><c:out value="${reservation.client.name}"></c:out></td>
                    <td><c:out value="${reservation.reservationFor.toGMTString()}"></c:out></td>
                    <td><c:out value="${reservation.note}"></c:out></td>
                    <td><c:out value="${reservation.status}"></c:out></td>
                    <td>
                        <form method="POST" action="/accept-reservation">
                            <input name="reservation_id" type="hidden"
                                   value="<c:out value="${reservation.id}"></c:out>">
                            <input class="btn btn-success" type="submit"
                                   value="<spring:message code="label.accept-reservation"></spring:message>">
                        </form>

                        <form method="POST" action="/delete-reservation">
                            <input name="reservation_id" type="hidden"
                                   value="<c:out value="${reservation.id}"></c:out>">
                            <input class="btn btn-danger" type="submit"
                                   value="<spring:message code="label.delete-reservation"></spring:message>">
                        </form>

                    </td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
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
