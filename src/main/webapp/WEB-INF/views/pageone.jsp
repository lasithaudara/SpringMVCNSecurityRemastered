<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Page One</title>
</head>
<body>
<h1><%= "Page One!" %></h1>
<br/>
<a href="${pageContext.request.contextPath}/home">goto Home</a>
</body>
</html>