<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="theme/header.jsp">
    <jsp:param name="active" value="home"/>
</jsp:include>

<jsp:include page="theme/sidebar.jsp">
    <jsp:param name="sidebar" value="home" />
    <jsp:param name="active" value="home" />
</jsp:include>


    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <div class="page-header">
        <h2>Strona główna</h2>
    </div>
        <div class="col-md-12">
            Widok
    </div></div>
<%@include file="theme/footer.jsp"%>
