<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@include file="../theme/header.jsp"%>
<div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
        <ul class="nav nav-sidebar">
            <c:if test="${!empty(partner.id)}">
            <li><a href="/partners/show/${partner.id}">Partner</a></li>
            <li class="active"><a href="/partners/edit/${partner.id}">Edytuj</a></li>
            <li><a href="/partners/add/adresses/${partner.id}">Dodaj adres</a></li>
            <li><a href="/partners/remove/${partner.id}">Usuń</a></li>
            </c:if>
            <c:if test="${empty(partner.id)}">
                <li><a href="/partners/">Partnerzy</a></li>
                <li class="active"><a href="#">Dodaj partnera</a></li>
            </c:if>
        </ul>
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

    <div class="page-header">
        <h2><c:if test="${!empty(partner.id)}">Edytuj</c:if><c:if test="${empty(partner.id)}">Dodaj</c:if> partnera</h2>
    </div>
        <div class="col-md-12">
            <c:url var="saveAction" value="/partners/save" ></c:url>

            <form:form method="post" action="${saveAction}" modelAttribute="partnerSave" commandName="partnerSave" class="form-horizontal">
                <c:if test="${!empty(partner.id)}">
                    <form:hidden path="id" />
                </c:if>
                <div class="control-group">
                    <form:label cssClass="control-label" path="name">Nazwa:*</form:label>
                    <div class="controls">
                        <form:errors path="name" cssClass="error"/>
                        <form:input cssClass="form-control" path="name"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label cssClass="control-label" path="shortName">Nazwa skrócona:</form:label>
                    <div class="controls">
                        <from:input cssClass="form-control" path="shortName" />
                    </div>
                </div>
                <div class="control-group">
                    <form:label cssClass="control-label" path="code">Kod:*</form:label>
                    <div class="controls">
                        <form:errors path="code" cssClass="error"/>
                        <form:input cssClass="form-control" path="code"/>
                    </div>
                </div>

                <div class="control-group">
                    <form:label cssClass="control-label" path="description">Opis:</form:label>
                    <div class="controls">
                        <form:textarea cssClass="form-control" path="description"/>
                    </div>
                </div>
                <div class="clearfix">&nbsp;</div>
                <div class="control-group">
                    <div class="controls">
                        <c:if test="${!empty partner.name}">
                            <input type="submit" value="Zapisz" class="btn btn-primary"/>
                        </c:if>
                        <c:if test="${empty partner.name}">
                            <input type="submit" value="Dodaj partnera" class="btn btn-primary"/>
                        </c:if>
                    </div>
                </div>
            </form:form>
        </div></div>
<%@include file="../theme/footer.jsp"%>