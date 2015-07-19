<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<jsp:include page="../theme/header.jsp">
    <jsp:param name="active" value="partners"/>
</jsp:include>

<jsp:include page="../theme/sidebar.jsp">
    <jsp:param name="sidebar" value="showpartner" />
    <jsp:param name="active" value="persons" />
    <jsp:param name="id" value="${partId}" />
</jsp:include>

    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
<div class="page-header">
    <h2><c:if test="${personsSave.id>0}">Edytuj</c:if><c:if test="${personsSave.id==0}">Dodaj</c:if> osobę kontaktową</h2>
</div>
    <div class="col-md-12">
        <c:url var="saveAction" value="/partners/persons/save/${partId}"></c:url>

        <form:form method="post" action="${saveAction}" modelAttribute="personsSave" commandName="personsSave" class="form-horizontal">
            <form:hidden path="id"/>
        <div class="control-group">
            <form:label cssClass="control-label" path="contactType">Typ kontaktu*:</form:label>
            <form:errors path="contactType" cssClass="text-danger"/>
            <div class="controls">
                <from:input cssClass="form-control" path="contactType"/>
            </div>
        </div>
        </div>
        <div class="col-md-6">
        <div class="control-group">
            <form:label cssClass="control-label" path="firstName">Imię:</form:label>
            <form:errors path="firstName" cssClass="text-danger"/>
            <div class="controls">
                <from:input cssClass="form-control" path="firstName"/>
            </div>
        </div>
    </div>
    <div class="col-md-6">
        <div class="control-group">
            <form:label cssClass="control-label" path="lastName">Nazwisko:</form:label>
            <form:errors path="lastName" cssClass="text-danger"/>
            <div class="controls">
                <form:input cssClass="form-control" path="lastName"/>
            </div>
        </div>
    </div>
        <div class="col-md-12">
            <div class="control-group">
                <form:label cssClass="control-label" path="title">Tytuł:</form:label>
                <form:errors path="title" cssClass="text-danger"/>
                <div class="controls">
                    <from:input cssClass="form-control" path="title"/>
                </div>
            </div>
            </div>
    <div class="col-md-6">
        <div class="control-group">
            <form:label cssClass="control-label" path="phone">Telefon*:</form:label>
            <form:errors path="phone" cssClass="text-danger"/>
            <div class="controls">
                <form:input cssClass="form-control" path="phone"/>
            </div>
        </div>
    </div>
    <div class="col-md-6">
        <div class="control-group">
            <form:label cssClass="control-label" path="mobile">Telefon komórkowy:</form:label>
            <form:errors path="mobile" cssClass="text-danger"/>
            <div class="controls">
                <form:input cssClass="form-control" path="mobile"/>
            </div>
        </div>
        </div>
        <div class="col-md-12">
        <div class="control-group">
            <form:label cssClass="control-label" path="email">Email*:</form:label>
            <form:errors path="email" cssClass="text-danger"/>
            <div class="controls">
                <form:input cssClass="form-control" path="email"/>
            </div>
        </div>
        <div class="clearfix">&nbsp;</div>
        <div class="control-group">
            <div class="controls">
                <c:if test="${personsSave.id>0}">
                    <input type="submit" value="Zapisz" class="btn btn-primary"/>
                </c:if>
                <c:if test="${personsSave.id==0}">
                    <input type="submit" value="Dodaj adres" class="btn btn-primary"/>
                </c:if>
            </div>
        </div>
        </form:form>
    </div></div>
    <%@include file="../theme/footer.jsp" %>
