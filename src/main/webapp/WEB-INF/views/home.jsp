<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Welcome Home</title>
</head>
<body>
<h1><%= "Welcome Home!" %></h1>
<br/>
<a href="${pageContext.request.contextPath}/pageone">goto PageOne</a>

<div class="container">
  <form:form class="form-signin" method="post" action="logout">
    <button class="btn btn-lg btn-primary btn-block" type="submit">logout</button>
  </form:form>
</div>
</body>
</html>