<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="theme/header.jsp">
    <jsp:param name="active" value="partners"/>
</jsp:include>

<jsp:include page="theme/sidebar.jsp">
    <jsp:param name="sidebar" value="partners" />
    <jsp:param name="active" value="partners" />
</jsp:include>


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
                        <th style="width: 30%">Nazwa skrócona</th>
                        <th style="width: 10%">Kod</th>
                        <th style="width: 128px">&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listPartners}" var="partner">
                        <tr>
                            <td><a href="/u/partners/show/${partner.id}">${partner.name}</a></td>
                            <td>${partner.shortName}</td>
                            <td>${partner.code}</td>
                            <td>
                                <a href="/u/partners/edit/${partner.id}" class="btn btn-default btn-xs">Edytuj</a>
                                <a href="/u/partners/show/${partner.id}" class="btn btn-xs btn-primary">Przejdź</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div></div>
<%@include file="theme/footer.jsp"%>
