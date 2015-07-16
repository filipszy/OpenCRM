<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<%@include file="../theme/header.jsp" %>
<div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
        <ul class="nav nav-sidebar">
            <li><a href="/partners/show/${partId}">Partner</a></li>
            <li><a href="/partners/edit/${partId}">Edytuj</a></li>
            <li class="active"><a href="#"><c:if test="${!empty(adresses.id)}">Edytuj</c:if><c:if test="${empty(adresses.id)}">Dodaj</c:if> adres</a></li>
            <li><a href="/partners/remove/${PartId}">Usuń</a></li>
        </ul>
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
<div class="page-header">
    <h2><c:if test="${!empty(adresses.id)}">Edytuj</c:if><c:if test="${empty(adresses.id)}">Dodaj</c:if> adres</h2>
</div>
    <div class="col-md-12">
        <c:url var="saveAction" value="/partners/adresses/save/${partId}"></c:url>

        <form:form method="post" action="${saveAction}" modelAttribute="adressesSave" commandName="adressesSave"
                   class="form-horizontal">
        <c:if test="${!empty(adresses.id)}">
            <form:hidden path="id"/>
        </c:if>
        <div class="control-group">
            <form:label cssClass="control-label" path="title">Tytuł:</form:label>
            <div class="controls">
                <from:input cssClass="form-control" path="title"/>
            </div>
        </div>
        <div class="control-group">
            <form:label cssClass="control-label" path="street">Ulica:</form:label>
            <div class="controls">
                <from:input cssClass="form-control" path="street"/>
            </div>
        </div>
    </div>
    <div class="col-md-6">
        <div class="control-group">
            <form:label cssClass="control-label" path="streetNo">Nr lokalu:</form:label>
            <div class="controls">
                <form:input cssClass="form-control" path="streetNo"/>
            </div>
        </div>
    </div>

    <div class="col-md-6">
        <div class="control-group">
            <form:label cssClass="control-label" path="localNo">Nr pomieszczenia:</form:label>
            <div class="controls">
                <form:input cssClass="form-control" path="localNo"/>
            </div>
        </div>
    </div>
    <div class="col-md-12">
        <div class="control-group">
            <form:label cssClass="control-label" path="postCode">Kod pocztowy:</form:label>
            <div class="controls">
                <form:input cssClass="form-control" path="postCode"/>
            </div>
        </div>

        <div class="control-group">
            <form:label cssClass="control-label" path="city">Miasto:</form:label>
            <div class="controls">
                <form:input cssClass="form-control" path="city"/>
            </div>
        </div>
        <div class="clearfix">&nbsp;</div>
        <div class="control-group">
            <div class="controls">
                <c:if test="${!empty(adresses.id)}">
                    <input type="submit" value="Zapisz" class="btn btn-primary"/>
                </c:if>
                <c:if test="${empty(adresses.id)}">
                    <input type="submit" value="Dodaj adres" class="btn btn-primary"/>
                </c:if>
            </div>
        </div>
        </form:form>
    </div></div>
    <%@include file="../theme/footer.jsp" %>
