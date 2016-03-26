<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<div class="container">
    <div class="row">
        <h2>Reservation in ${reservation.restaurant.name}</h2>
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
            <spring:url value="/add-reservation/${reservation.restaurant.slug}" var="formurl"></spring:url>
            <form:form action="${formurl}" method="post"
                       cssClass="form form-horizontal">
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
                            <select class="form-control" name="people"
                                    selected="<c:out value="${reservation.people}"/>">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6">
                        <div class="form-group">
                            <label class="control-label">Date</label>

                            <input name="reservationFor"
                                   value="<fmt:formatDate pattern="yyyy-MM-dd" value="${reservation.reservationFor}" />"
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
                    <input type="submit" class="btn btn-success"
                           value="<spring:message code="label.make_reservation"/>">
                </div>
            </form:form>
            </form>
        </div>
    </div>
</div>
<footer>
    <div class="row">
        <p class="text-center">&copy; <spring:message code="label.name"/>| 2016-2017 | 2TX/1</p>
    </div>
</footer>

</body>
</html>
