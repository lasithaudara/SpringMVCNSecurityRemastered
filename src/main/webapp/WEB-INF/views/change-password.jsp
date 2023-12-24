<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lasit
  Date: 12/19/2023
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Please sign in</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form:form class="form-signin" method="post" action="change-password">
        <h2 class="form-signin-heading">Change Password</h2>
        <c:if test="${param.invalid != null}">
            <div class="alert alert-danger" role="alert">Invalid password</div>
        </c:if>
        <p>
            <label for="oldPassword" class="sr-only">Password</label>
            <input type="password" id="oldPassword" name="oldPassword" class="form-control" placeholder="Old Password"
                   required="">
        </p>
        <p>
            <label for="newPassword" class="sr-only">Password</label>
            <input type="password" id="newPassword" name="newPassword" class="form-control" placeholder="New Password"
                   required="">
        </p>
        <c:if test="${param.notMatch != null}">
            <div class="alert alert-danger" role="alert">Not matched with new password</div>
        </c:if>
        <p>
            <label for="confirmPassword" class="sr-only">Password</label>
            <input type="password" id="confirmPassword" name="confirmPassword" class="form-control"
                   placeholder="Confirm Password" required="">
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form:form>
</div>
</body>
</html>
