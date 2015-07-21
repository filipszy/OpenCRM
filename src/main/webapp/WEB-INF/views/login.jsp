<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page session="true"%>

<html>
<html lang="pl">
<head>
    <meta charset="iso-8859-2">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">


    <title>OpenCRM</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://bootswatch.com/flatly/bootstrap.css">

    <!-- Optional theme -->
    <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">-->

    <script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
    body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #eee;
    }

    .form-signin {
        max-width: 330px;
        padding: 15px;
        margin: 0 auto;
    }
    .form-signin .form-signin-heading,
    .form-signin .checkbox {
        margin-bottom: 10px;
    }
    .form-signin .checkbox {
        font-weight: normal;
    }
    .form-signin .form-control {
        position: relative;
        height: auto;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        padding: 10px;
        font-size: 16px;
    }
    .form-signin .form-control:focus {
        z-index: 2;
    }
    .form-signin input[type="email"] {
        margin-bottom: -1px;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
    }
    .form-signin input[type="password"] {
        margin-bottom: 10px;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
    }

</style>
</head>
<body onload='document.loginForm.username.focus();'>

<div class="container">


    <c:url value='/j_spring_security_check' var="loginUrl" />

    <form name='loginForm'
          action="${loginUrl}" method='POST' class="form-signin">
        <h2 class="form-signin-heading">Logowanie</h2>

        <c:if test="${not empty error}">
            <div class="alert alert-danger" role="alert">${error}</div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="alert alert-info" role="alert">${msg}</div>
        </c:if>


        <label for="username" class="sr-only">Nazwa użytkownika</label>
        <input type="text" name="username" id="username" class="form-control" placeholder="Nazwa użytkownika" required="" autofocus="">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Hasło" required="">

        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />

        <button class="btn btn-lg btn-primary btn-block" type="submit">Zaloguj</button>
    </form>

</div>



</body>
</html>