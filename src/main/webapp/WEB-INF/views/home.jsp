<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Welcome Home</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <h1 class="form-signin-heading"><%= "Welcome Home!" %></h1>
    <br/>
    <sec:authorize access="hasAuthority('ADMIN')"><a class="form-signin-heading" href="${pageContext.request.contextPath}/admin-dashboard">goto AdminDashboard</a></sec:authorize>
    <br/>
    <sec:authorize access="hasAuthority('USER')"><a class="form-signin-heading" href="${pageContext.request.contextPath}/user-dashboard">goto UserDashboard</a></sec:authorize>
    <br/>
    <form:form class="form-signin" method="post" action="logout">
        <button class="btn btn-lg btn-primary btn-block" type="submit">logout</button>
    </form:form>
</div>
</body>
</html>