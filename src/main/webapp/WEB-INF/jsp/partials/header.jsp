<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="navbar">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                aria-expanded="false" aria-controls="navbar">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand text-capitalize text-info" href="#"><spring:message code="label.reservations"></spring:message></a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
            <li class="active"><a href="<c:url value="/"/>"><spring:message code="label.home"></spring:message></a></li>
            <li><a href="<c:url value="/reservations-admin"/>"><spring:message code="label.reservation_admin"></spring:message> </a></li>

            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                   <spring:message code="label.language"></spring:message>  <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="?lang=nl">Nederlands</a></li>
                    <li><a href="?lang=en">English</a></li>
                </ul>
            </li>


        </ul>
    </div>
</div>
