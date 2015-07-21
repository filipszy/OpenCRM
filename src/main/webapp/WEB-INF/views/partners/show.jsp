<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="../theme/header.jsp">
    <jsp:param name="active" value="partners"/>
</jsp:include>


<jsp:include page="../theme/sidebar.jsp">
    <jsp:param name="sidebar" value="showpartner" />
    <jsp:param name="active" value="partner" />
    <jsp:param name="id" value="${partner.id}" />
</jsp:include>

    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <div class="page-header">
        <c:if test="${!empty(partner.shortName)}">
            <h2>${partner.shortName}</h2>
        </c:if>
        <c:if test="${empty(partner.shortName)}">
            <h2>${partner.name}</h2>
        </c:if>
    </div>

        <c:if test="${!empty(partner.shortName)}">
            <div class="col-md-9">
            Pełna nazwa: <strong>${partner.name}</strong>
            </div>
        </c:if>
        <div class="col-md-3" style="float: right; text-align: right">
        Kod: <strong>${partner.code}</strong>
        </div>

        <div class="col-md-12">
            <hr/>
        </div>
        <c:if test="${!empty(partner.description)}">
            <div class="col-md-12">
                ${partner.description}
            </div>
            <div class="col-md-12">
                <hr/>
            </div>
        </c:if>

       <div class="col-md-6">
           <h3>Adresy</h3>
           <c:if test="${!empty(partner.addressesEntity)}">
           <c:forEach items="${partner.addressesEntity}" var="ad">
               <strong>${ad.title}</strong>
               <span class="pull-right">
               <a href="/u/partners/${ad.id}/adresses/edit/${partner.id}"><span class="glyphicon glyphicon-pencil"></span></a>
               <a href="/u/partners/${partner.id}/adresses/remove/${ad.id}"><span class="glyphicon glyphicon-trash"></span></a></span><br/>
               ul. ${ad.street} ${ad.streetNo}
               <c:if test="${!empty(ad.localNo)}">
                   / ${ad.localNo}
               </c:if><br/>
               ${ad.postCode} ${ad.city}<br/>
               <hr/>
               <div class="clearfix">&nbsp;</div>
           </c:forEach>
        </c:if>
       </div>

        <div class="col-md-6">
            <h3>Osoby kontaktowe</h3>
            <c:if test="${!empty(partner.personsEntity)}">
                <c:forEach items="${partner.personsEntity}" var="pe">
                    <strong>${pe.contactType}</strong>
               <span class="pull-right">
               <a href="/u/partners/${pe.id}/persons/edit/${partner.id}"><span class="glyphicon glyphicon-pencil"></span></a>
               <a href="/u/partners/${partner.id}/persons/remove/${pe.id}"><span class="glyphicon glyphicon-trash"></span></a></span><br/>
                    ${pe.firstName} ${pe.lastName}<br/>
                    <c:if test="${!empty(pe.title)}">
                        <i>${pe.title}</i><br/>
                    </c:if>
                    <span class="glyphicon glyphicon-phone-alt"></span> ${pe.phone}
                    <c:if test="${!empty(pe.mobile)}"><span class="glyphicon glyphicon-phone"></span> ${pe.mobile}</c:if><br/>
                    <span class="glyphicon glyphicon-envelope"></span> ${pe.email}
                    <hr/>
                    <div class="clearfix">&nbsp;</div>
                </c:forEach>
            </c:if>
        </div>
    </div>
</div>
<%@include file="../theme/footer.jsp"%>
