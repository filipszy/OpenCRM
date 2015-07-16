<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="theme/header.jsp"%>
<div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
        <ul class="nav nav-sidebar">
                <li class="active"><a href="#">Partnerzy</a></li>
                <li><a href="/partners/add">Dodaj partnera</a></li>
        </ul>
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <div class="page-header">
        <h2>Partnerzy</h2>
    </div>
        <div class="col-md-12">
            <c:if test="${!empty listPartners}">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>Nazwa</th>
                        <th>Nazwa skrócona</th>
                        <th>Kod</th>
                        <th style="width: 190px">&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listPartners}" var="partner">
                        <tr>
                            <td><a href="/partners/show/${partner.id}">${partner.name}</a></td>
                            <td>${partner.shortName}</td>
                            <td>${partner.code}</td>
                            <td>
                                <a href="/partners/edit/${partner.id}" class="btn btn-xs">Edytuj</a>
                                <a href="/partners/show/${partner.id}" class="btn btn-xs btn-primary">Przejdź</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div></div>
<%@include file="theme/footer.jsp"%>
