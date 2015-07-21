<%--
  Created by IntelliJ IDEA.
  User: new
  Date: 19.07.15
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
      <!--
      sidebar:  ${param.sidebar} <br/>
      active: ${param.active}   -->
        <c:if test="${param.sidebar == 'partners'}">
        <ul class="nav nav-sidebar">
            <li <c:if test="${param.active == 'partners'}"> class="active" </c:if>><a href="/u/partners">Partnerzy</a></li>
            <li <c:if test="${param.active == 'add'}"> class="active" </c:if>><a href="/u/partners/add">Dodaj partnera</a></li>
        </ul>
        </c:if>
        <c:if test="${param.sidebar == 'showpartner'}">
        <ul class="nav nav-sidebar">
            <li <c:if test="${param.active == 'partner'}"> class="active" </c:if>><a href="/u/partners/show/${param.id}">Szczegóły partnera</a></li>
            <li <c:if test="${param.active == 'edit'}"> class="active" </c:if>> <a href="/u/partners/edit/${param.id}">Edytuj partnera</a></li>
            <li <c:if test="${param.active == 'address'}"> class="active" </c:if>><a href="/u/partners/add/adresses/${param.id}">Dodaj adres</a></li>
            <li <c:if test="${param.active == 'persons'}"> class="active" </c:if>><a href="/u/partners/add/persons/${param.id}">Dodaj osobę</a></li>
            <li <c:if test="${param.active == 'delete'}"> class="active" </c:if>><a href="/u/partners/remove/${param.id}">Usuń partnera</a></li>
        </ul>
        </c:if>
        <c:if test="${param.sidebar == 'home'}">
            <ul class="nav nav-sidebar">
                <li <c:if test="${param.active == 'home'}"> class="active" </c:if>><a href="/u">Strona główna</a></li>
            </ul>
        </c:if>
    </div>
